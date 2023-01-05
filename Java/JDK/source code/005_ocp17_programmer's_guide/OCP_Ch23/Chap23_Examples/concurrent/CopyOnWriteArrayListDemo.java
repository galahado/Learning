package concurrent;
import java.util.*;
import java.util.concurrent.*;

public class CopyOnWriteArrayListDemo {

  public static void main(String[] args) {
    List<Integer> cowlist = new CopyOnWriteArrayList<Integer>();          // (1)
    cowlist.addAll(Arrays.asList(1, 2, 3));

    Runnable iter = () -> {                                               // (2)
      String threadName = Thread.currentThread().getName();
      for (Integer i : cowlist) {
        System.out.println(threadName + ": " + i);
        ConcUtil.snooze(1, TimeUnit.SECONDS);
      }
    };

    // First iterator:
    new Thread(iter, "Iterator A").start();                               // (4)

    // Snooze, add, and remove in main thread.                            // (5)
    ConcUtil.snooze(1, TimeUnit.SECONDS);
    Integer newValue = 4;
    cowlist.add(newValue);
    System.out.println("New value added: " + newValue);
    Integer first = cowlist.remove(0);
    System.out.println("Value removed:   " + first);

    // Second iterator:
    new Thread(iter, "Iterator B").start();                               // (6)
  }
}