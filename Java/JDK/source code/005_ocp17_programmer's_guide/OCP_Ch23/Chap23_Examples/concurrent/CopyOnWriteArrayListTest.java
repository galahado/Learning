package concurrent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CopyOnWriteArrayListTest {

  public static void main(String[] args) {
//  List<Integer> cowlist = new CopyOnWriteArrayList<Integer>();      // (1a)
    List<Integer> cowlist = new ArrayList<Integer>();                 // (1b)
    cowlist.addAll(Arrays.asList(10, 20, 30));
    Iterator<Integer> iter = cowlist.iterator();
    while (iter.hasNext()) {
      Integer i = iter.next();
      if (i == 20) {
//      iter.remove();                      // (2a) UnsupportedOperationException
        cowlist.remove(i);                  // (2b) OK
        continue;
      }
      System.out.print(i + " ");            // With (2b): 10 30
    }
  }
}

/*
                  (2a)                             (2b)
(1a)   UnsupportedOperationException               10 30
(1b)              10 30                            10
 */