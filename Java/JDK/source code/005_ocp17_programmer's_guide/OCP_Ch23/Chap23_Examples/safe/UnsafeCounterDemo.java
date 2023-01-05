package safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeCounterDemo {
  private static final int LIMIT = 5;
  private static final int THREAD_POOL_SIZE = 5;

  public static void main(String[] args) {
    UnsafeCounter counter = new UnsafeCounter();                        // (2)
    Runnable incrementor = () -> {                                      // (3)
      for (int i = 0; i < LIMIT; i++) {
        counter.increment();
      }
      System.out.println("Exiting " + Thread.currentThread().getName());
    };

    ExecutorService execService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    try {
      for (int i = 0; i < THREAD_POOL_SIZE; i++) {
        execService.submit(incrementor);
      }
    } finally {
      execService.shutdown();
    }
  }
}