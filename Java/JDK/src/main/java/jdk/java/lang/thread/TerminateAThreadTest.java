package jdk.java.lang.thread;

public class TerminateAThreadTest {

    public static void main(String[] args) {
        TerminateThread r = new TerminateThread();
        Thread t = new Thread(r);
        t.setName("t");
        t.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        r.running = false;
    }
}

class TerminateThread implements Runnable {

    boolean running = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (running) {
                System.out.println(Thread.currentThread().getName() + " -----> " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // do the jobs before the thread is terminated
                // like saving the data
                System.out.println("The thread is terminated!");
                return;
            }
        }
    }
}
