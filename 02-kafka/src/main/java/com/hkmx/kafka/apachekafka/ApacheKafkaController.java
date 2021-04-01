package com.hkmx.kafka.apachekafka;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ApacheKafkaController {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "mao");
        map.put("name", "xing");
        map.forEach((key, value) -> {
            if (StringUtils.endsWithIgnoreCase(value, "mao")) {
            }
        });
    }
}
