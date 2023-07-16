package com.heima;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Creating a thread using FutureTask
 */
@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            log.debug("running...");
            Thread.sleep(2000);
            return 100;
        });

        new Thread(task3, "t3").start();

        Integer result = task3.get();
        log.debug("结果是:{}", result);
    }
}
