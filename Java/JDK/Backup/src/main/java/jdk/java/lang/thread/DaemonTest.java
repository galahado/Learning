package jdk.java.lang.thread;

public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread t = new DaemonThread();
        t.setName("Daemon Thread");
        t.setDaemon(true);
        t.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -----> " + i);
            Thread.sleep(1000);
        }

        // when the main thread is finished
        // the daemon thread will terminate automatically
    }
}

class DaemonThread extends Thread {

    @Override
    public void run() {
        int i = 0;

        while (true) {
            System.out.println(Thread.currentThread().getName() + " -----> " + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
