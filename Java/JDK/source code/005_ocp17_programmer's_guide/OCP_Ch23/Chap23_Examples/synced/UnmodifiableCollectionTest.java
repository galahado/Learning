package synced;

import java.util.*;

public class UnmodifiableCollectionTest {
  public static void main(String[] argv) throws Exception {
//  try {
      // Effectively immutable list view:
//    List<Integer> list = new ArrayList<>();
//    list.add(2021); list.add(2022);
//    List<Integer> immutableList = Collections.unmodifiableList(list);
//    System.out.println(immutableList.get(0));   // 2021
//    immutableList.add(2023);                    // UnsupportedOperationException
//    immutableList.set(0, 2023);                 // UnsupportedOperationException
//    immutableList.remove(2021);                 // UnsupportedOperationException
//  } catch (UnsupportedOperationException e) {
//    e.printStackTrace();
//  }

    // Thread-safe unmodifiable list:
    List<String> list = List.of("Tom", "Dick", "Harriet");
//  list.add("Harry");                         // UnsupportedOperationException
//  list.set(0, "Tommy");                      // UnsupportedOperationException
    list.remove("Dick");                       // UnsupportedOperationException
    System.out.println(list.get(0));           // "Tom"
  }
}