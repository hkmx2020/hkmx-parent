package com.hkmx.kafka.apachekafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.HashMap;
import java.util.Map;

public class CallBackProducer {

	public static void main(String[] args) throws InterruptedException {
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
		 * 异步发送
		 */
		props.put("producer.type", "async");

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
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		/**
		 * 开启事务
		 */
		// props.put("enable.idempotence", true);
		// props.put("transactional.id", "mxw_transaction");


		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);

		for (int i = 100; i < 150; i++) {
			kafkaProducer.send(new ProducerRecord<String, String>("mtest", "笑傲江湖, 第" + i + "集"), new Callback() {
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if (metadata != null) {
						System.out.println(metadata.partition() + "---" + metadata.offset());
					}
				}
			});

			// Callback callback = (RecordMetadata metadata, Exception exception) -> System.out.println(metadata.offset());
			// kafkaProducer.send(new ProducerRecord<String, String>("mtest", "笑傲江湖, 第" + i + "集"), callback);
		}

		kafkaProducer.close();

	}

}
