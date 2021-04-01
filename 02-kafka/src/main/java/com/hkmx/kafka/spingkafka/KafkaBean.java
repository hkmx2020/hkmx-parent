package com.hkmx.kafka.spingkafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;

@EnableAsync
@EnableKafka
@Configuration
public class KafkaBean {

    // --------------------------------------------------   生产者配置  --------------------------------------------------

    @Bean
    public Map<String, Object> producerProperties() {
        Map<String, Object> props = new HashMap<>();

        /**
         * Kafka服务端的主机名和端口号
         */
        props.put("bootstrap.servers", "192.168.216.128:9092");

        /**
         *  是否等待副本节点的应答, 异步发送时此只能设置为0不确认
         *  0:不确认
         * 	1:一个副本确认，即 leader 副本确认
         *  all: leader的所有副本都收到这条消息，并发回确认
         */
        props.put("acks", "0");

        /**
         * 消息发送尝试次数。 重试机制对性能有影响
         */
        props.put("retries", 0);

        /**
         * 批量发送时, 可发送的消息最大字节数 5M
         */
        props.put("batch.size", 5242880);

        /**
         * 批量发送时, 延时发送时间, 达到该时间会执行发送
         */
        props.put("linger.ms", 50);

        /**
         * 发送缓存区内存大小
         */
        props.put("buffer.memory", 33554432);

        /**
         * key 和 value 的序列化类， 可以自定义
         */
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "com.hkmx.kafka.spingkafka.MessageSerializer");

        /**
         * 开启事务
         */
        // props.put("enable.idempotence", true);
        // props.put("transactional.id", "mxw_transaction");

        return props;
    }

    @Bean
    public ProducerFactory<String, CustomeMessage> customProducerFactory() {
        DefaultKafkaProducerFactory factory = new DefaultKafkaProducerFactory(producerProperties());

        // 开启事务。(同时配置事务管理器 KafkaTransactionManager 事务才会生效)
        // factory.setTransactionIdPrefix("kafka-tran-");
        // factory.transactionCapable();

        return factory;
    }

    // @Bean
    // public KafkaTransactionManager kafkaTransactionManager() {
    //     KafkaTransactionManager manager = new KafkaTransactionManager(producerFactory());
    //     return manager;
    // }

    public KafkaProducerResultHandler KafkaProducerResultHandler() {
        return new KafkaProducerResultHandler();
    }

    /**
     * kafkaTemplate 实现了 Kafka 发送接收等功能
     *
     * @return
     */
    @Bean
    public KafkaTemplate<String, CustomeMessage> kafkaTemplate() {
        KafkaTemplate<String, CustomeMessage> kafkaTemplate = new KafkaTemplate<String, CustomeMessage>(customProducerFactory(), false);
        kafkaTemplate.setProducerListener(KafkaProducerResultHandler());

        // 设置默认的topic(此处可做一些具体设置)
        kafkaTemplate.setDefaultTopic("default");
        return kafkaTemplate;
    }


    // --------------------------------------------------   消费者配置  --------------------------------------------------

    public Map<String, Object> consumerProperties() {
        Map<String, Object> props = new HashMap<>();

        /**
         * 定义 kakfa 服务的地址，不需要将所有broker指定上
         */
        props.put("bootstrap.servers", "192.168.216.128:9092");

        /**
         * 指定 consumer group
         */
        props.put("group.id", "lhlt");

        /**
         * 自动提交offset, 提交 offset 的时间间隔
         */
        props.put("enable.auto.commit", "true");
        // props.put("auto.commit.interval.ms", "1000");

        /**
         * latest earliest none
         */
        props.put("auto.offset.reset", "earliest");

        /**
         * 消费者心跳超时时间, 以及发送心跳的频率
         */
        props.put("session.timeout.ms", 12000);
        props.put("heartbeat.interval.ms", 3000);

        /**
         * 每次 poll 的最大消息数, 可以获取的最大字节数, 最小字节数, 下一次拉取消息的最大时间间隔
         */
        props.put("max.poll.records", 1);
        props.put("fetch.max.bytes", 5242880);
        props.put("fetch.min.bytes", 2048);
        // props.put("max.poll.interval.ms", 4000);

        /**
         * 重平衡分区策略
         */
        props.put("partition.assignment.strategy", "org.apache.kafka.clients.consumer.StickyAssignor");

        /**
         * key 和 value 的序列化类, 可以自定义
         */
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "com.hkmx.kafka.spingkafka.MessageDeserializer");

        /**
         * 开启事务时，设置Consumer端参数 isolation.level 值。
         * read_uncommitted(默认值，能够读到kafka写入的任何消息)
         * read_committed（Consumer只会读取事务型Producer成功事务写入的消息。）
         */
        // props.put("isolation.level", "read_committed");

        return props;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<String, String>(consumerProperties());
    }

    /**
     * 单个监听
     *
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());

        // 设置拉取消息时的轮询时间
        factory.getContainerProperties().setPollTimeout(50);

        // 设置手动提交 ackMode
        // factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);

        return factory;
    }

    /**
     * 批量监听
     *
     * @return
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory batchContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory(consumerProperties()));

        // // 设置为批量监听
        // factory.setBatchListener(true);
        //
        // // 设置并发量, 小于或等于Topic的分区数
        // factory.setConcurrency(2);

        return factory;
    }

    @Bean
    public KafkaConsumerListener kafkaConsumerListener() {
        return new KafkaConsumerListener();
    }

    public static void main(String[] args) {
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < 50; i++) {
            builder.append("备");
        }
        System.out.println(builder.toString());

    }

}
