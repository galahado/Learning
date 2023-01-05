
public class SynchronizedMethodDemo {
  public static void main(String[] args) {
    CounterX counter = new CounterX();                              // (2)
    Runnable r = () -> {                                            // (3)
      for (int i = 0; i < 5; i++) {
        counter.increment();
      }
      System.out.println("Exiting " + Thread.currentThread().getName());
    };
    new Thread(r).start();                                          // (4)
    new Thread(r).start();                                          // (5)
    System.out.println("Exiting thread " + Thread.currentThread().getName());
  }
}