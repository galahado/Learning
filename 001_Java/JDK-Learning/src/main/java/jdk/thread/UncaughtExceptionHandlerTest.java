package jdk.thread;

import org.junit.jupiter.api.Test;

public class UncaughtExceptionHandlerTest {

    public static void main(String[] args) throws Exception {
        Thread.currentThread().setUncaughtExceptionHandler((thread, ex) -> {
            System.out.println("This is the default handler " +  ex);
        });

        throw new Exception("testing");
    }

}
