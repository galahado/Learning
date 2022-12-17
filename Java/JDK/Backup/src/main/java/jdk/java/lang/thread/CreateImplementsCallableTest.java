package jdk.java.lang.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateImplementsCallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(() -> {
            int a = 100;
            int b = 200;

            System.out.println(Thread.currentThread().getName() + " -----> start!");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " -----> end!");

            return a + b;
        });

        Thread t = new Thread(task);
        t.setName("FutureTask");

        t.start();

        System.out.println("The result: " + task.get());
        System.out.println("Main end!");
    }
}
