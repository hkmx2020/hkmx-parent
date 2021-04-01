package com.hkmx.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/2/26 11:05
 */
@RestController
@Slf4j
public class MyController {

    public static final Logger LOGGER =  LogManager.getLogger(MyController.class);

    @PostMapping("/mytest")
    public Map mytest(@RequestHeader String token) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "111");

        byte[] logs = new byte[]{2, 3, 7};
        map.put("logs", logs);
        return map;
    }

    @PostMapping("/post")
    public String post(@RequestBody String request) {
        System.out.println(request);
        return request;
    }

    public static void main(String[] args) {
        final byte[] agMHS = Base64.getDecoder().decode("AgMH");
        System.out.println(agMHS);
    }

}
