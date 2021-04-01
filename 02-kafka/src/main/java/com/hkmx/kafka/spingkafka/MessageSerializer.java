package com.hkmx.kafka.spingkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Slf4j
public class MessageSerializer implements Serializer<CustomeMessage> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, CustomeMessage data) {
        return GsonUtil.toJson(data).getBytes();
    }

    @Override
    public void close() {

    }
}
