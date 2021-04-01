package com.hkmx.kafka.apachekafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@EnableAsync
public class StartWebConsumer {

    @Autowired
    private WebConsumer webConsumer;

    @PostConstruct
    public void start() {
        System.out.println("线程a名称：" + Thread.currentThread().getName());
        // webConsumer.startKafkaConsumer();
    }



}
