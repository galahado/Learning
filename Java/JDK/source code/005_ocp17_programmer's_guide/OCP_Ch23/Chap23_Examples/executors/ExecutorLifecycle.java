package executors;
import java.util.concurrent.*;

public class ExecutorLifecycle {

  // Task: dice roll.
  private static final Runnable diceRoll = () -> {                         // (1)
    int diceValue = ThreadLocalRandom.current().nextInt(1, 7);          // [1, 6]

    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + " => dice value: " + diceValue);
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      System.out.println(threadName + ": " + e);
    }
  };

  public static void main(String[] args) {
    System.out.printf("%50s   %s%n", "isShutdown()", "isTerminated()");
    // Create the executor service:
    ExecutorService es = Executors.newFixedThreadPool(3);                  // (2)
    try {                                                                  // (3)
      checkStates(es, "Before execute() at (4): ");
      // Submit tasks:
      es.execute(diceRoll);                                                // (4)
      es.execute(diceRoll);
      es.execute(diceRoll);
      checkStates(es, "After execute() at (4): ");
    } finally {                                                            // (5)
      // Shut down the executor service:
      checkStates(es, "Before shutdown() at (6a): ");
      es.shutdown();                                                       // (6a)
      checkStates(es, "After shutdown() at (6a): ");

//    checkStates(es, "Before shutdownNow() at (6b): ");
//    es.shutdownNow();                                                    // (6b)
//    checkStates(es, "After shutdownNow() at (6b): ");
    }
    // Second phase of shutdown:
//  awaitAndShutdownNow(es, 2, TimeUnit.SECONDS);                          // (7a)
//  awaitAndShutdownNow(es, 1, TimeUnit.MILLISECONDS);                     // (7b)
  }

  private static void checkStates(ExecutorService es, String msg) {        // (8)
    System.out.printf("%-40s %-5s           %-5s%n",
        msg, es.isShutdown(), es.isTerminated());
  }

  private static void awaitAndShutdownNow(                                 // (9)
      ExecutorService es, int timeout, TimeUnit timeunit) {
    try {
      // Timed wait for tasks to complete execution:
      if (!es.awaitTermination(timeout, timeunit)) {                       // (10)
        // Attempt to cancel any uncompleted and waiting tasks:
        checkStates(es, "Before shutdownNow() at (11): " );
        es.shutdownNow();                                                  // (11)
        checkStates(es, "After shutdownNow() at (11): " );
        // Timed wait for tasks to be cancelled:
        while (!es.awaitTermination(timeout, timeunit)) {                  // (12)
          System.out.println("All tasks not yet completed at (12).");
        }
      }
      checkStates(es, "After awaitTermination() at (10): " );
    } catch (InterruptedException ie) {                                    // (13)
      // Attempt to cancel any uncompleted and waiting tasks:
      es.shutdownNow();                                                    // (14)
      // Reinstate the interrupt status.
      Thread.currentThread().interrupt();
      checkStates(es, "After interruption: ");
    }
  }
}