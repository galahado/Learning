package jdk.java.lang.thread;

public class CreateExtendingThreadTest {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main --> " + i);
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread --> " + i);
        }
    }
}
