package synced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IteratingSynchronized  {

  public static void main(String[] args) throws InterruptedException {
    iterate1();
//    iterate2();
//    iterate3();
//    iterate4();
//    iterate5();
  }

  // Synchronized to avoid modification by another thread during iteration.
  // Example to use in the book.
  public static void iterate1() {
    List<Integer> years = Collections.synchronizedList(new ArrayList<>());
    years.add(2024); years.add(2023); years.add(2021); years.add(2022);
    synchronized(years) {
      Iterator<Integer> iteratorA = years.iterator();
      while (iteratorA.hasNext()) {
        if (iteratorA.next().equals(2021)) {
          iteratorA.remove();
        }
      }
    }
    System.out.println("Synchronized list view: " + years);
  }

  public static void iterate2() {
    List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
    numbers.add(21); numbers.add(24); numbers.add(22); numbers.add(23);

    synchronized(numbers) {
      Iterator<Integer> iteratorB = numbers.iterator();
      while (iteratorB.hasNext()) {
        Integer ii = iteratorB.next();
        if (ii == 22) {
          numbers.remove(ii); // ok
        }
      }
      System.out.println(numbers);
    }
  }

  public static void iterate3() {
    List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
    numbers.add(21); numbers.add(24); numbers.add(22); numbers.add(23);
    synchronized(numbers) {
      for (Integer i : numbers) {
        if (i == 22) {
          numbers.remove(i);              // ok
        }
      }
    }
    System.out.println("3: " + numbers);
  }

  public static void iterate4() {
    List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
    numbers.add(21); numbers.add(24); numbers.add(22); numbers.add(23);
    synchronized(numbers) {
      numbers.removeIf(i -> i == 22);     // ok.
    }
    System.out.println("4: " + numbers);
  }

  public static void iterate5() {
    List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
    numbers.add(21); numbers.add(24); numbers.add(22); numbers.add(23);
    List<Integer> resultList = null;
    synchronized(numbers) {
      resultList = numbers.stream().filter(i -> i != 22).toList(); //
    }
    System.out.println("5: " + resultList);
  }
}