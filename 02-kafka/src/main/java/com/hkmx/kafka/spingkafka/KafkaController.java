package com.hkmx.kafka.spingkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    /**
     * ie浏览器标志
     */
    public static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};

    @Autowired
    KafkaTemplate kafkaTemplate;

    @PostMapping(path = "/push", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public CustomeMessage kafka(@RequestBody CustomeMessage message) throws InterruptedException, ExecutionException, TimeoutException {
        log.info("welcome to my kafka world");

        ProducerRecord<String, CustomeMessage> record = new ProducerRecord<>("mtest", message);
        // ProducerRecord<String, CustomeMessage> record = new ProducerRecord<>("im", message);
        // 异步发送
        kafkaTemplate.send(record);

        // 同步发送
        Object o = kafkaTemplate.send(record).get(2, TimeUnit.SECONDS);
        System.out.println(GsonUtil.toJson(o));



        // 使用事务
        // kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
        //     @Override
        //     public Object doInOperations(KafkaOperations kafkaOperations) {
        //         kafkaOperations.send("wtest", message);
        //         int a = 10;
        //         if (a != 10) {
        //             throw new RuntimeException("fail");
        //         }
        //         return true;
        //     }
        // });

        // KafkaOperations.OperationsCallback operationsCallback = (KafkaOperations kafkaOperations) -> {
        //     // todo 执行发送逻辑
        //     ListenableFuture result = kafkaOperations.send("wtest", message);
        //     int a = 10;
        //     if (a != 10) {
        //         throw new RuntimeException("fail");
        //     }
        //     return result;
        // };
        // kafkaTemplate.executeInTransaction(operationsCallback);

        return message;
    }

}
