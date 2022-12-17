package jdk.java.lang.thread;

public class InterruptTest {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000 * 60 * 60 * 365);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "------> end");
        });

        t.start();

        System.out.println(Thread.currentThread().getName() + "-----> start");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();

    }
}