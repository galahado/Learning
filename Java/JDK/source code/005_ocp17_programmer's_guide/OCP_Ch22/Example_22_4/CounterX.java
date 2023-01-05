
class CounterX {
  private int counter = 0;

  public synchronized void increment() {                            // (1a)
//public void increment() {                                         // (1b)
    System.out.println(Thread.currentThread().getName()
                     + ": old:" + counter + " new:" + ++counter);
  }
}