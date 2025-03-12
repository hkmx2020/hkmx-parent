package com.hkmx.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/4/26 21:31
 */
public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        String s = Integer.toBinaryString(-3 & 0b11111111);
        System.out.println(s);
        double pow = Math.pow(2, 7);
        System.out.println(pow);
    }


}
