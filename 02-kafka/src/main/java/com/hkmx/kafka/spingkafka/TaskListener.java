package com.hkmx.kafka.spingkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 比如现在单机环境下，我们需要利用Kafka做数据持久化的功能，由于用户活跃的时间为早上10点至晚上12点，那在这个时间段做一个大数据量的持久化可能会影响
 * 数据库性能导致用户体验降低，我们可以选择在用户活跃度低的时间段去做持久化的操作，也就是晚上12点后到第二条的早上10点前。
 */

@Slf4j
@Component
@EnableScheduling
public class TaskListener {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @Autowired
    private ConsumerFactory consumerFactory;

    @Bean
    public ConcurrentKafkaListenerContainerFactory delayContainerFactory() {
        ConcurrentKafkaListenerContainerFactory container = new ConcurrentKafkaListenerContainerFactory();
        container.setConsumerFactory(consumerFactory);

        // 禁止自动启动
        container.setAutoStartup(false);
        return container;
    }

    @KafkaListener(id = "durable", topics = "wtest", containerFactory = "delayContainerFactory")
    public void durableListener(String data) {
        // 这里做数据持久化的操作
        log.info("topic.quick.durable receive : " + data);
    }


    /**
     * 项目启动的时候监听容器是未启动状态，而resume是恢复的意思不是启动的意思，所以我们需要判断容器是否运行，如果运行则调用resume方法，否则调用start方法
     * <p>
     * 定时器，每天凌晨0点开启监听
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void startListener() {
        log.info("开启监听");
        // 判断监听容器是否启动，未启动则将其启动
        if (!registry.getListenerContainer("durable").isRunning()) {
            registry.getListenerContainer("durable").start();
        }
        registry.getListenerContainer("durable").resume();
    }

    /**
     * 定时器，每天早上10点关闭监听
     */
    @Scheduled(cron = "0 0 10 * * ?")
    public void shutDownListener() {
        log.info("关闭监听");
        registry.getListenerContainer("durable").pause();
    }

    public static void main(String[] args) {
        String key = "superadmin:COMPANY_CREATE:5";
        String[] split = key.split(":");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
    }

}
