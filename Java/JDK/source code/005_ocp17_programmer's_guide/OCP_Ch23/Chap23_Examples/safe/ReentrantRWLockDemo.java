package safe;
import java.util.concurrent.*;

public class ReentrantRWLockDemo {
  private static final int LIMIT = 5;
  private static final int POOL_SIZE = 2;

  public static void main(String[] args) {

    ReentrantRWLockCounter rwlc = new ReentrantRWLockCounter();
    Runnable incrementor = () -> {
      for (int j = 0; j < LIMIT; j++) {
        rwlc.increment();
      }
    };

    ExecutorService execService = Executors.newFixedThreadPool(POOL_SIZE);
    try {
      for (int i = 0; i < POOL_SIZE; i++) {
        execService.submit(incrementor);
      }
    } finally { execService.shutdown(); }
  }
}