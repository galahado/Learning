package jdk.java.lang.thread;

public class SleepTest {

    public static void main(String[] args) throws InterruptedException {
        // sleep is a static method
        // it will cause the current thread to sleep
        Thread.sleep(1000 * 3);

        System.out.println("After Sleep");
    }
}
