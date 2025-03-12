package com.hkmx.kafka.spingkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class KafkaConsumerListener {

    @KafkaListener(topics = {"mtest",}, groupId = "hkmx")
    // @KafkaListener(topics ="wtest", groupId = "hkmx")
    public void singleListen(ConsumerRecord<String, CustomeMessage> record) {
        System.out.println("监听消息:" + record.value());
        log.info("监听消息:" + GsonUtil.toJson(record.value()));
    }

    // /**
    //  * 可以读取消息头等各种参数
    //  *
    //  * @param record
    //  * @param data
    //  * @param key
    //  * @param partition
    //  * @param topic
    //  * @param timestamp
    //  */
    // @KafkaListener(topics = "wtest", groupId = "hkmx")
    // public void singleListen1(ConsumerRecord<String, CustomeMessage> record,
    //                           @Payload String data,
    //                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
    //                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
    //                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
    //                           @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
    //     System.out.println("监听消息:" + record.value());
    //     log.info("receive wtest : \n" +
    //             "data : " + data + "\n" +
    //             "key : " + key + "\n" +
    //             "partitionId : " + partition + "\n" +
    //             "topic : " + topic + "\n" +
    //             "timestamp : " + timestamp + "\n"
    //     );
    //     log.info("监听消息:" + GsonUtil.toJson(record.value()));
    // }
    //

    // /**
    //  * 批量消费
    //  *
    //  * @param messages
    //  */
    // @KafkaListener(id = "batch", clientIdPrefix = "batch", topics ="wtest", groupId = "hkmx", containerFactory = "batchContainerFactory")
    // public void batchListen(List<CustomeMessage> messages, Acknowledgment ack) {
    //     System.out.println("批量监听消息:" + messages.size());
    //     log.info("批量监听消息:" + GsonUtil.toJson(messages));
    //
    //     // 手动提交。 手动提交需要先设置提交模式 AckMode 为 MANUAL_IMMEDIATE
    //     ack.acknowledge();
    // }

}
