
public class Counter implements Runnable {
  private int currentValue = 0;

  @Override
  public void run() {                         // (1) Thread entry point
    String threadName = Thread.currentThread().getName(); // (2)
    while (currentValue < 5) {
      System.out.printf("%s: old:%s new:%s%n",
                        threadName,           // (3) Print thread name,
                        this.currentValue,    //     old value,
                      ++this.currentValue);   //     new incremented value.
      try {
        Thread.sleep(500);                    // (4) Current thread sleeps.
      } catch (InterruptedException e) {
        System.out.println(threadName + " interrupted.");
      }
    }
    System.out.println("Exiting " + threadName);
  }
}