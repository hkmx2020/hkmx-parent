package com.hkmx.kafka.apachekafka;

import com.hkmx.kafka.utils.DateUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomProducer {
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

		KafkaProducer<String, String> producer = new KafkaProducer<>(props);

		// ========================================== 非事务 ============================================================
		int i = 0;
		while (i < 1) {
			String value = "当前时间：" +  DateUtil.getDateTime(new Date());
			System.out.println(value);
			producer.send(new ProducerRecord<String, String>("mtest", Integer.toString(i), value));
			++i;
			Thread.sleep(1000);
		}
		// ========================================== 非事务 ============================================================


		// ========================================== 事务 ==============================================================
		// producer.initTransactions();
		// try {
		// 	producer.beginTransaction();
		//
		// 	int i = 100;
		// 	while (i < 150) {
		// 		producer.send(new ProducerRecord<String, String>("mtest", Integer.toString(i), "天龙八部, 第" + i + "集"));
		// 		++i;
		// 		// Thread.sleep();
		// 	}
		//
		// 	// if (i >=150) {
		// 	// 	throw new RuntimeException("手动提交异常");
		// 	// }
		//
		//
		// 	producer.commitTransaction();
		// } catch (KafkaException e) {
		// 	producer.abortTransaction();
		// }
		// =========================================== 事务 =============================================================


		producer.close();
		System.out.println("发送结束");
	}
}

