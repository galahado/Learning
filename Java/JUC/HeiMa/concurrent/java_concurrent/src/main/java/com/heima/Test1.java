package com.heima;

import lombok.extern.slf4j.Slf4j;

/**
 * Creating a thread using Thread and Runnable
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void test1() {
        Thread t = new Thread(() -> log.debug("running"), "t1");
        t.start();
    }


    public static void test2() {
        Runnable r = () -> log.debug("running");
        Thread t = new Thread(r, "t2");
        t.start();
    }

    public static void main(String[] args) {
        test1();
        test2();
        log.debug("running in main");
    }

}
