package synced;
import java.util.*;

public class DoubleAct {
  // Synchronized list:                                                      (1)
  private List<String> names = Collections.synchronizedList(new ArrayList<>());

  public void add(String name) { names.add(name); }                       // (2)

  public String removeFirst() {                                           // (3)
    synchronized(names) {                                                 // (4)
      if (names.size() > 0) {                                             // (5)
        try { Thread.sleep(1); }                                          // (6)
        catch(InterruptedException e) { e.printStackTrace(); }
        return names.remove(0);                                           // (7)
      } else { return null; }                                             // (8)
    }                                                                     // (9)
  }
}