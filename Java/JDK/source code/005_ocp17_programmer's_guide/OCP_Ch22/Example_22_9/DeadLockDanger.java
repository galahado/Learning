
public class DeadLockDanger {
  public static void main(String[] args) {
    String o1 = "o1 " ;                                         // (1)
    String o2 = "o2 ";                                          // (2)

    Thread t1 = (new Thread("t1") {                             // (3)
      @Override
      public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
          synchronized(o1) {                                    // (4)
            System.out.println(threadName + " acquired " + o1);
            synchronized(o2) {                                  // (5)
              System.out.println(threadName + ": " + o1 + o2);
      }}}}});

    Thread t2 = (new Thread("t2") {                             // (6)
      @Override
      public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
          synchronized(o2) {                                    // (7)
            System.out.println(threadName + " acquired " + o2);
            synchronized(o1) {                                  // (8)
              System.out.println(threadName + ": " + o2 + o1);
      }}}}});

    t1.start();                                                 // (9)
    t2.start();                                                 // (10)
    System.out.println("Exiting main.");                        // (11)
  }
}