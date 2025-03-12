package com.hkmx.kafka.spingkafka;

import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;


public class MessageDeserializer implements Deserializer<CustomeMessage> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public CustomeMessage deserialize(String topic, byte[] data) {
        return GsonUtil.fromJson(new String(data), CustomeMessage.class);
    }

    @Override
    public void close() {

    }
}
