package com.hkmx.common.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Log4j2Test {

    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

    public static final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        test01();
    }

    public static void test01() throws InterruptedException {

        Long i = 1L;
        while (i < 100000000000L) {
            printLog();
            ++i;
        }

    }

    public static void printLog() {

        System.out.println("我的时间" + new Date());
        System.out.println("hahaha");

        LOGGER.error("error log");
        LOGGER.warn("warn log");
        LOGGER.info("我的 info log");
        LOGGER.debug("debug log");
        LOGGER.trace("trace log");

        LOGGER.info("用户:{}", "maoxingwen");

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            LOGGER.error("异常", e);
        }

        // executorService.submit(() -> {
        //     LOGGER.info("我的线程");
        // });

    }

}
