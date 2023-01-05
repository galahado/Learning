
public class Client {
  public static void main(String[] args) {
    String threadName = Thread.currentThread().getName();              // (4)
    System.out.println("Method main() runs in thread " + threadName);

    // Create two Counter objects that extend the Thread class:           (5)
    Counter counterA = new Counter();
    Counter counterB = new Counter();

    // Set the names for the two threads:                                 (6)
    counterA.setName("Counter A");
    counterB.setName("Counter B");

    // Mark the threads as daemon threads:                                (7)
//  counterA.setDaemon(true);
//  counterB.setDaemon(true);

    // Start the two threads:                                          // (8)
    System.out.println("Starting " + counterA.getName());
    counterA.start();
    System.out.println("Starting " + counterB.getName());
    counterB.start();

    System.out.println("Exiting " + threadName);
  }
}