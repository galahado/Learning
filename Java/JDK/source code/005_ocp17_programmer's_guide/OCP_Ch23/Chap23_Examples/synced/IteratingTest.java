package synced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import static java.lang.System.out;

public class IteratingTest  {

  public static void main(String[] args) throws InterruptedException {
    testx();
//    failFast();
//    failFastSynced2();
//    failSafe();

//    var foodData = new HashMap<String, Integer>();
//    foodData.put("penguin", 1);
//    foodData.put("flamingo", 2);
//    var synFoodData = Collections.synchronizedMap(foodData);
//
//    Set<String> keyView = synFoodData.keySet();
//    synchronized(synFoodData) {
//      Iterator<String> iteratorA = keyView.iterator();
//      while (iteratorA.hasNext()) {
//        if (iteratorA.next().equals("penguin")) {
//        iteratorA.remove();
//         }
//      }
//    }
//    System.out.println(synFoodData);
//
//
//    for(String key: synFoodData.keySet()) {
//      synchronized(synFoodData) {
//        synFoodData.remove(key);
//      }
//    }
  }

  public static void testx() {
    List<Integer> yrList3 = Arrays.asList(2020, 2021, 2022);
//  yrList3.add(2050);                        // UnsupportedOperationException
//  yrList3.set(2, 2023);                     // Potential race condition
    out.println(yrList3);                     // [2020, 2021, 2023]

    var view = Collections.synchronizedList(yrList3);
    view.set(1, 2050);
//    view.add(2100);                           // UnsupportedOperationException
    System.out.println(view);
  }


  // Fail-Fast--Non-sync
  public static void failFast() {
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(100); numbers.add(40); numbers.add(30); numbers.add(50);
//    Iterator<Integer> iteratorA = numbers.iterator();
//    while (iteratorA.hasNext()) {
//      if (iteratorA.next() == 30) {
//        iteratorA.remove(); // ok!
//      }
//    }
//    System.out.println(numbers);

    Iterator<Integer> iteratorB = numbers.iterator();
    while (iteratorB.hasNext()) {
      if (iteratorB.next() == 40) {
        numbers.remove(Integer.valueOf(40));     // Exception
      }
    }
    System.out.println(numbers);
  }

  // Fail-Fast Synced
  public static void failFastSynced() {
    List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
    numbers.add(100); numbers.add(40); numbers.add(30); numbers.add(50);
//    synchronized(numbers) {
//      Iterator<Integer> iteratorA = numbers.iterator();
//      while (iteratorA.hasNext()) {
//        if (iteratorA.next() == 30) {
//          iteratorA.remove(); // ok!
//        }
//      }
//      System.out.println(numbers);
//    }

//  synchronized(numbers) {
//    numbers.removeIf(i -> i == 30);
//    System.out.println(numbers);
//  }

    synchronized(numbers) {
      Iterator<Integer> iteratorB = numbers.iterator();
      while (iteratorB.hasNext()) {
        if (iteratorB.next() == 30) {
          numbers.remove(Integer.valueOf(30));  // ok.
        }
      }
      System.out.println(numbers);
    }
  }

  public static void failFastSynced2() {
    List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
    numbers.add(100); numbers.add(40); numbers.add(30); numbers.add(50);
    synchronized(numbers) {
      Iterator<Integer> iteratorB = numbers.iterator();
      while (iteratorB.hasNext()) {
        if (iteratorB.next() == 30) {
          numbers.remove(Integer.valueOf(30));  // ok.
        }
      }
      System.out.println(numbers);
    }
  }
  // Fail-safe/ Weakly Consistent
  public static void failSafe() {
    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    map.put("First", 10);
    map.put("Second", 20);
    map.put("Third", 30);
    map.put("Fourth", 40);

    Iterator<String> iterator = map.keySet().iterator();

    while (iterator.hasNext()) {
      String key = iterator.next();
      map.put("Fifth", 50);
      map.remove("First");
    }
    System.out.println(map);
  }
}