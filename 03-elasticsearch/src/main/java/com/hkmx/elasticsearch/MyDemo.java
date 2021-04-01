package com.hkmx.elasticsearch;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyDemo {

    private static final Logger LOGGER = LogManager.getLogger(ElasticsearchDemo.class);

    public static void main(String[] args) {
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
    }
}
