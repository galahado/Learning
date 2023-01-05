package synchronizers;
import static java.lang.System.out;
import java.util.concurrent.*;

public class CountDownLatchTest {
  public static final int N = 3;

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch startLine = new CountDownLatch(1);              // (1)
    CountDownLatch finishLine = new CountDownLatch(N);             // (2)

    ExecutorService es = Executors.newFixedThreadPool(N);          // (3)
    String threadName = Thread.currentThread().getName();
    try {
      for (int i = 0; i < N; ++i) {    // (4) Submit tasks.
        es.submit(new Task(startLine, finishLine));
      }
      out.println(threadName + ": Let all tasks proceed.");
      startLine.countDown();           // (5) Count down to let all tasks proceed.
      finishLine.await();              // (6) Wait for all tasks to finish.
      out.println(threadName + ": All tasks done.");
    } finally {
      es.shutdown();
    }
  }
}

class Task implements Runnable {                                   // (7)
  private final CountDownLatch startLine;
  private final CountDownLatch finishLine;

  public Task(CountDownLatch start, CountDownLatch finish) {
    this.startLine = start;
    this.finishLine = finish;
  }

  @Override
  public void run() {                                               // (8)
    String threadName = Thread.currentThread().getName();
    try {
      out.println(threadName + ": Waiting to proceed.");
      startLine.await();               // (9) Wait to proceed.
      out.println(threadName + ": Running ... ");
      finishLine.countDown();          // (10) Count down the latch & continue.
      out.println(threadName + ": Latch count decremented.");
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}