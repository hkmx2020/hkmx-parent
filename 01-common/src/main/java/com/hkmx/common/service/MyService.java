package com.hkmx.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/4/19 22:25
 */
@Slf4j
@Component
public class MyService {


    @PreDestroy
    public void destroy() {
        log.info("销毁");
        System.out.println("销毁");
    }

    @PostConstruct
    public void init() {
        log.info("初始化");
        System.out.println("初始化");
    }


}
