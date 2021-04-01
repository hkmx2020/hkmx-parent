package com.hkmx.elasticsearch;


import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryAction;
import org.elasticsearch.index.reindex.UpdateByQueryRequestBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.idsQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;
import static org.elasticsearch.index.query.QueryBuilders.scriptQuery;

@Slf4j
public class ElasticsearchDemo {

    private static final Logger LOGGER = LogManager.getLogger(ElasticsearchDemo.class);

    private static final String INDEX = "mytest";
    private static final String TYPE = "mytest";

    TransportClient client = getClient();

    @Test
    public void createIndex() throws IOException {

        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                .startObject()
                // .startObject("default")
                .startObject("properties")

                .startObject("user_uid").field("type", "keyword").endObject()
                .startObject("created").field("type", "date").endObject()
                .startObject("orgs").field("type", "keyword").endObject()

                // .endObject()
                .endObject()
                .endObject();

        client.admin().indices().prepareCreate(INDEX).get();
        try {
            client.admin().indices()
                    .putMapping(Requests.putMappingRequest(INDEX).type(TYPE).source(xContentBuilder)).get();
        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error("init index datamapping {} error ", e);
        }

        LOGGER.info("create index success");
    }

    @Test
    public void onCreateUser() {

        // String userUid = "maoxingwen";
        String userUid = "xingda";

        XContentBuilder b = null;

        try {
            b = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("user_uid", userUid)
                    .field("created", new Date())
                    .field("orgs", new String[]{})
                    .endObject();
        } catch (IOException e) {
            throw new RuntimeException("on create user error {}", e);
        }

        client.prepareIndex(INDEX, TYPE).setId(userUid).setSource(b)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.NONE)
                .execute();

        System.out.println("add user success");
    }

    @Test
    public void updateOrgs() {

        String userUid = "xingda";

        List<String> userOrgs = new ArrayList<>();
        userOrgs.add("beijing");
        // userOrgs.add("shanghai");

        UpdateByQueryRequestBuilder request = UpdateByQueryAction.INSTANCE
                .newRequestBuilder(client);
        request.source(INDEX).filter(boolQuery()
                .must(idsQuery().addIds(userUid))
                .must(scriptQuery(new Script("doc['orgs'].size() == 0"))))
                .script(new Script(Script.DEFAULT_SCRIPT_TYPE, Script.DEFAULT_SCRIPT_LANG,
                        "ctx._source.orgs.addAll(params.orgs)",
                        ImmutableMap.of("orgs", new ArrayList<>(userOrgs))))
                .setMaxRetries(1);

        request.execute(new ActionListener<BulkByScrollResponse>() {
            @Override
            public void onResponse(BulkByScrollResponse bulkByScrollResponse) {
                if(bulkByScrollResponse.getBulkFailures().size() == 0) {
                    LOGGER.debug("done update orgs : {}", bulkByScrollResponse);
                }else{
                    LOGGER.error("update orgs result : {} ", bulkByScrollResponse);
                }
            }

            @Override
            public void onFailure(Exception e) {
                LOGGER.error("error update orgs : {}",e);
            }
        });

    }

    @Test
    public void search() {


        MultiSearchRequestBuilder request = client.prepareMultiSearch();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(new Date());
        List<String> days = new ArrayList<>();
        days.add(today);

        // orgId为null时搜索的是当天全部数据
        final QueryBuilder orgsQuery = this.getOrgsFilter("beijing");

        days.forEach(day ->
                request.add(getClient().prepareSearch(INDEX)
                        .setQuery(boolQuery().filter(orgsQuery).filter(rangeQuery("created").format("yyyyMMdd").lte(day)))
                        .setFetchSource(false))
        );

        Map<String, Long> singleStat = getSingleStat(days, request);
        System.out.println(singleStat);
    }

    private QueryBuilder getOrgsFilter(String orgId){
        QueryBuilder orgsQuery = matchAllQuery();
        if(!StringUtils.isBlank(orgId)){
            orgsQuery = matchQuery("orgs",orgId);
        }
        return orgsQuery;
    }

    private Map<String, Long> getSingleStat(List<String> days,
                                            MultiSearchRequestBuilder multiSearchRequestBuilder) {

        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[0];

        try {
            items = multiSearchRequestBuilder.execute().get().getResponses();
        } catch (Exception e) {
            LOGGER.error("execute fail : {}", e);
            throw new RuntimeException("execute fail  ", e);
        }

        Map<String, Long> ret = new HashMap<>();

        for (int i = 0; i < items.length; i++) {
            if(items[i].getFailure() != null){
                LOGGER.error("error statistic user :  ",items[i].getFailure());
                continue;
            }
            ret.put(days.get(i), items[i].getResponse().getHits().totalHits);
        }

        return ret;
    }

    public static TransportClient getClient() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        Settings settings = Settings.builder().put("client.transport.ignore_cluster_name", true)
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        try {
            String address ="localhost";
            String port = "9300";
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(address), Integer.parseInt(port)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    public TransportClient getMyClient(){
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        try {
            client = client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        System.out.println(client);
        return client;
    }

    public static void main(String[] args) {

        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");

        System.out.println(1);
    }

}
