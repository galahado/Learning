
public class Controller {
  public static void main(String[] args) {                      // (7)
    Worker worker = new Worker();                               // (8)
    System.out.println("Start the worker.");
    worker.kickStart();                                         // (9)
    try {
      Thread.sleep(2);                                          // (10)
    } catch(InterruptedException ie) {
      ie.printStackTrace();
    }
    System.out.println("Stop the worker.");
    worker.terminate();                                         // (11)
  }
}