package com.hkmx.kafka.apachekafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
@Component
public class WebConsumer {

    public static ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    /**
     * 在 web 项目中可以通过此方式来启动 kafka 消费者,
     * 可以在此方法中写 {@link CustomConsumer )} 类中的消费者逻辑的代码
     */
    @Async
    public void startKafkaConsumer() {
        System.out.println("线程b名称：" + Thread.currentThread().getName());
        log.info("========================启动kafka消费者============================");

        KafkaConsumer<String, String> deleteConsumer = new KafkaConsumer<>(consumerProperties());
        deleteConsumer.subscribe(Arrays.asList("xtest"));
        try {

            while (true) {
                ConsumerRecords<String, String> records = deleteConsumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {

                    System.out.println(record.value());
                }

                // 使用异步提交规避阻塞
                deleteConsumer.commitAsync();
            }

        } catch (Exception e) {
            // 处理异常

        } finally {
            try {
                // 最后一次提交使用同步阻塞式提交
                deleteConsumer.commitSync();
            } finally {
                deleteConsumer.close();
            }
        }

        System.out.println(consumerProperties());
    }

    public static Map<String, Object> consumerProperties() {
        Map<String, Object> props = new HashMap<>();

        /**
         * 定义kakfa 服务的地址，不需要将所有broker指定上
         */
        props.put("bootstrap.servers", "192.168.187.145:9092,192.168.187.146:9092,192.168.187.147:9092");
        // props.put("bootstrap.servers", "47.96.167.211:9092");

        /**
         * 指定consumer group
         */
        props.put("group.id", "hkmx");

        /**
         * 自动提交offset, 提交offset的时间间隔
         */
        props.put("enable.auto.commit", "false");
        // props.put("auto.commit.interval.ms", "1000");

        /**
         * 避免重启后消息重复消费
         */
        props.put("auto.offset.reset", "latest");

        /**
         * 消费者心跳超时时间, 以及发送心跳的频率
         */
        props.put("session.timeout.ms", "6000");
        props.put("heartbeat.interval.ms", "2000");

        /**
         * 每次 poll 的最大消息数, 可以获取的最大字节数, 最小字节数
         */
        props.put("max.poll.records", "500");
        props.put("fetch.max.bytes", "5242800");
        props.put("fetch.min.bytes", "2048");

        /**
         * 重平衡分区策略
         */
        props.put("partition.assignment.strategy", "org.apache.kafka.clients.consumer.StickyAssignor");


        /**
         * key 和 value 的序列化类, 可以自定义
         */
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        /**
         * 开启事务时，设置Consumer端参数 isolation.level 值。
         * read_uncommitted(默认值，能够读到kafka写入的任何消息)
         * read_committed（Consumer只会读取事务型Producer成功事务写入的消息。）
         */
        props.put("isolation.level", "read_committed");

        return props;
    }

    // @Override
    // public void run(ApplicationArguments args) throws Exception {
    //     startKafkaConsumer();
    // }

    // @Override
    // public void onApplicationEvent(ContextRefreshedEvent event) {
    //     System.out.println("线程a名称：" + Thread.currentThread().getName());
    //     pool.execute(() -> startKafkaConsumer());
    // }

}
