package safe;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedCounterDemo {
  private static final int LIMIT = 100;
  private static final int THREAD_POOL_SIZE = 5;

  public static void main(String[] args) {

    SynchronizedCounter vsc = new SynchronizedCounter();
    Runnable incrementor = () -> {
        for (int j = 0; j < LIMIT; j++) {
          vsc.increment();
        }
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