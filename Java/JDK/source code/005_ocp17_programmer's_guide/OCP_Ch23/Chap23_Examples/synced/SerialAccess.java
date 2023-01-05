package synced;
import java.util.*;

public class SerialAccess  {

  public static void main(String[] args) throws InterruptedException {
    List<Integer> years = Collections.synchronizedList(new ArrayList<>());
    years.add(2024); years.add(2023); years.add(2021); years.add(2022);
    synchronized(years) {                                                // (1)
      Iterator<Integer> iteratorA = years.iterator();                    // (2)
      while (iteratorA.hasNext()) {
        if (iteratorA.next().equals(2021)) {                             // (3)
          iteratorA.remove();                                            // (4)
        }
      }
    }
    System.out.println("Synchronized list: " + years);
  }
}