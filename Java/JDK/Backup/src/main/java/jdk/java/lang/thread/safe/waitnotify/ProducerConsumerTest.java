package jdk.java.lang.thread.safe.waitnotify;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread t1 = new Thread(new Producer(list));
        t1.setName("Producer");
        Thread t2 = new Thread(new Consumer(list));
        t2.setName("Consumer");

        t1.start();
        t2.start();
    }
}

class Producer implements Runnable {

    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() > 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.add(new Object());
                System.out.println(Thread.currentThread().getName() + " -----> " + list.get(0));
                list.notify();
            }
        }
    }
}

class Consumer implements Runnable {

    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + " -----> " + obj);
                list.notify();
            }
        }
    }

}