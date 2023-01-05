package executors;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class TaskExecution {

  public static void main(String[] args) {
    // Runnable:
    Runnable printDiceValue = () ->                                        // (1)
      System.out.println("Execution of Runnable: "
                        + ThreadLocalRandom.current().nextInt(1,7));

    // Callable<V>:
    Callable<Integer> diceRoll =                                           // (2)
        () -> ThreadLocalRandom.current().nextInt(1,7);

    // Executor service:
    ExecutorService exs = Executors.newFixedThreadPool(3);                 // (3)
    try {
      // Executing Runnable in a thread:
      Future<?> rfuture = exs.submit(printDiceValue);                      // (4)
      Object result = rfuture.get();                                       // (5)
      System.out.println("Result of Runnable: " + result);

      // Executing Callable<V> in a thread:
      Future<Integer> cfuture = exs.submit(diceRoll);                      // (6)
      Integer diceValue = cfuture.get();                                   // (7)
      System.out.println("Result of Callable: " + diceValue);

      // Executing bulk tasks:
      List<Callable<Integer>> callables                                    // (8)
          = List.of(diceRoll, diceRoll, diceRoll);
      List<Future<Integer>> allFutures = exs.invokeAll(callables);         // (9)
      List<Integer> resultList = allFutures.stream()                       // (10)
          .map(future -> {
            try {
              return future.get();
            } catch(InterruptedException | ExecutionException ie) {
              throw new IllegalStateException(ie);
            }
          })
          .toList();
      System.out.println("Result of invokeAll(): " + resultList);

      Integer anyResult = exs.invokeAny(callables);                        // (11)
      System.out.println("Result of invokeAny(): " + anyResult);
    } catch(InterruptedException | ExecutionException ie) {
      ie.printStackTrace();
    } finally {
      exs.shutdown();
    }
  }
}