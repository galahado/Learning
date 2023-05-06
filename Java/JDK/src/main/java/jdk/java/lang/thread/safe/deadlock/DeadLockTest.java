package jdk.java.lang.thread.safe.deadlock;

public class DeadLockTest {
    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        MyThread1 t1 = new MyThread1(o1, o2);
        MyThread2 t2 = new MyThread2(o1, o2);

        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread {

    private Object object1;
    private Object object2;

    public MyThread1(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object1) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (object2) {

            }
        }
    }
}

class MyThread2 extends Thread {

    private Object object1;
    private Object object2;

    public MyThread2(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object2) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (object1) {

            }
        }
    }
}
