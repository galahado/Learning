package synced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class SyncedCollectionDemo  {

  public static void main(String[] args) throws InterruptedException {
    List<StringBuilder> wList = List.of(
        new StringBuilder("Java"), new StringBuilder("case"),
        new StringBuilder("do"), new StringBuilder("null"),
        new StringBuilder("synchronized"), new StringBuilder("while")
        );

    List<StringBuilder> unmodList = Collections.unmodifiableList(wList);   // (1)
    Set<StringBuilder> set = new HashSet<>();                              // (2)
    Set<StringBuilder> syncedSet = Collections.synchronizedSet(set);       // (3)

    Predicate<StringBuilder> fourLetterWord = s -> s.length() == 4;
    Runnable wordFinder = () -> {
      synchronized(syncedSet) {
        for (StringBuilder word: unmodList) {
          if(fourLetterWord.test(word)) {
            syncedSet.add(word); // (3)
          }
        }
      }
    };
    Thread t1 = new Thread(wordFinder);
    Thread t2 = new Thread(wordFinder);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(unmodList);
    System.out.println(syncedSet);
  }
}