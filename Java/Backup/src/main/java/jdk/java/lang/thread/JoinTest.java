package jdk.java.lang.thread;

import org.junit.jupiter.api.Test;

public class JoinTest {

    @Test
    void withoutJoin() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " -----> " + i);
            }
        });
        t.setName("t");
        t.start();

        System.out.println("Main end");
    }


    @Test
    void withJoin() throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " -----> " + i);
            }
        });
        t.setName("t");
        t.start();
        t.join(); // main thread is blocked until t stops
        System.out.println("Main end");
    }
}
