package jdk.java.lang.thread;

public class SleepTest {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000 * 3);

        System.out.println("After Sleep");
    }
}
