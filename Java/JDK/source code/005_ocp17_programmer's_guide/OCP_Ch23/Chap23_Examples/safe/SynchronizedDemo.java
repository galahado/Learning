package safe;
/** Using synchronized methods for visibility of shared data. */
public class SynchronizedDemo {

  private static boolean stopThread = false;

  private static synchronized void stopNow() {         // (1)
    stopThread = true;
  }
  private static synchronized boolean stopRunning() {  // (2)
    return stopThread;
  }

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 2; i++) {                      // (3)
      new Thread(() -> {
        while (!stopThread) {                          // (4)
          System.out.println(Thread.currentThread().getName()
                             + ": Get me out of here!");
        }
      }, "T" + i).start();
    }
    Thread.sleep(1);                                   // (5)
    stopNow();                                         // (6)
  }
}