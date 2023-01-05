import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class IterationOverCollections {
  public static void main(String[] args) {

    // Create a collection of names.                                    (1)
    Collection<String> collectionOfNames = new ArrayList<>();
    Collections.addAll(collectionOfNames, "Alice", "Bob", "Tom","Dick","Harriet");
    System.out.println(collectionOfNames);

    // Using an explicit iterator.
    Iterator<String> iterator = collectionOfNames.iterator();        // (2)
    while (iterator.hasNext()) {                                     // (3)
      String name = iterator.next();                                 // (4)
      System.out.print(name.toUpperCase() + " ");
    }
    System.out.println();

    // Using the forEachRemaining() method of the Iterator interface.
    iterator = collectionOfNames.iterator();                         // (5)
    iterator.forEachRemaining(name ->                                // (6)
        System.out.print(name.toUpperCase() + " "));
    System.out.println();

    // Using the for(:) loop on an Iterable.
    for (String name : collectionOfNames) {                          // (7)
      System.out.print(name.toUpperCase() + " ");
    }
    System.out.println();

    // Using the forEach() method of the Collection interface.
    collectionOfNames.forEach(name ->                                // (8)
        System.out.print(name.toUpperCase() + " "));
    System.out.println();

    // Filtering using an explicit iterator.
    iterator = collectionOfNames.iterator();                         // (9)
    while (iterator.hasNext()) {                                     // (10)
      String name = iterator.next();                                 // (11)
      if (name.length() == 3)
        iterator.remove();                                           // (12)
    }
    System.out.println(collectionOfNames);

    // Filtering using the removeIf() method of the Collection interface.
    collectionOfNames.removeIf(name -> name.startsWith("A"));        // (13)
        System.out.println(collectionOfNames);

    // Using the stream() method of the Collection interface.
    collectionOfNames.stream()                                       // (14)
                     .forEach(name -> System.out.print(name.toUpperCase() + " "));
    System.out.println();
  }
}