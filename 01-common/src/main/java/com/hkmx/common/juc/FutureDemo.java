package com.hkmx.common.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Predicate;

/**
 * @author maoxwa
 * @version 1.0
 * @date 2021/4/2 20:49
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "1";
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("result:" + e);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return e.getMessage();
        });

        System.out.println(completableFuture.get());

        Predicate<Integer> p = (e -> e > 5);


    }
}
