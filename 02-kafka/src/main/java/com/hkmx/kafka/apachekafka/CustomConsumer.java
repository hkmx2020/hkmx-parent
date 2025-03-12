package com.hkmx.kafka.apachekafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomConsumer {
    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<>();

        /**
         * 定义 kakfa 服务的地址，不需要将所有broker指定上
         */
        props.put("bootstrap.servers", "192.168.216.128:9092");

        /**
         * 指定 consumer group
         */
        props.put("group.id", "hkmx");

        /**
         * 自动提交offset, 提交 offset 的时间间隔
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
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        /**
         * 开启事务时，设置Consumer端参数 isolation.level 值。
         * read_uncommitted(默认值，能够读到kafka写入的任何消息)
         * read_committed（Consumer只会读取事务型Producer成功事务写入的消息。）
         */
        // props.put("isolation.level", "read_committed");

        // 定义consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 消费者订阅的topic, 可同时订阅多个
        consumer.subscribe(Arrays.asList("mtest"));

        try {

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                int count = records.count();
                if (count > 0) {
                    System.out.println("消息数:" + count);
                    throw new RuntimeException("手动异常");
                }

                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }

                // 使用异步提交规避阻塞
                if (count > 0) {
                    consumer.commitAsync();
                    System.out.println("异步提交, 消息数:" + count);
                }
            }
        } finally {
            try {
                // 最后一次提交使用同步阻塞式提交
                consumer.commitSync();
                System.out.println("最终提交");
            } catch (Exception e) {
                System.out.println("关闭消费者提交异常");
            } finally {
                consumer.close();
            }
        }
    }


    /**
     * 同步和异步相结合，建议使用此方式提交
     *
     * @param consumer
     */
    public static void syncAndAsync(Consumer consumer) {
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
                // todo 处理消息

                // 使用异步提交规避阻塞
                consumer.commitAsync();
            }
        } catch (Exception e) {
            // 处理异常
        } finally {
            try {
                // 最后一次提交使用同步阻塞式提交
                consumer.commitSync();
            } finally {
                consumer.close();
            }
        }

    }

}
