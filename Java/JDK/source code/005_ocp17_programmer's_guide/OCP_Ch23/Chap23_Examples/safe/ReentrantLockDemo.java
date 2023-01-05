package safe;
import java.util.concurrent.*;

public class ReentrantLockDemo {                                      // (8)
  private static final int LIMIT = 5;
  private static final int POOL_SIZE = 2;

  public static void main(String[] args) {

    ReentrantLockCounter rlc = new ReentrantLockCounter();            // (9)
    Runnable incrementor = () -> {                                    // (10)
      for (int j = 0; j < LIMIT; j++) {
        rlc.increment();
      }
    };

    ExecutorService execService = Executors.newFixedThreadPool(POOL_SIZE);
    try {
      for (int i = 0; i < POOL_SIZE; i++) {
        execService.submit(incrementor);                              // (11)
      }
    } finally { execService.shutdown(); }
  }
}