import java.util.Set;
import java.util.stream.Stream;

public class TakeItDropIt {
  public static void main(String[] args) {
    // Ordered stream:
    Stream.of(1, 3, 5, 7, 8, 9, 11)                 // Takes longest prefix: 1 3 5 7
          .takeWhile(n -> n % 2 != 0)               // 1 3 5 7
          .forEach(n -> System.out.print(n + " "));
    System.out.println();
    Stream.of(1, 3, 5, 7, 8, 9, 11)
          .dropWhile(n -> n % 2 != 0)               // Drops longest prefix:  1 3 5 7
          .forEach(n -> System.out.print(n + " ")); // 8 9 11
    System.out.println("\n-----------");

    // Unordered stream:
    Set<Integer> iSeq = Set.of(1, 9, 4, 3, 7);
    iSeq.stream()
        .takeWhile(n -> n % 2 != 0)                   // Takes any subset of elements.
        .forEach(n -> System.out.print(n + " "));     // Nondeterministic: 1 9 7
    System.out.println();

    iSeq.stream()
        .dropWhile(n -> n % 2 != 0)                   // Takes any subset of elements.
        .forEach(n -> System.out.print(n + " "));     // Nondeterministic: 4 3
    System.out.println("\n-----------");

    // All match in ordered stream:
    Stream.of(1, 3, 5, 7, 9, 11)
          .takeWhile(n -> n % 2 != 0)                 // Takes all elements.
          .forEach(n -> System.out.print(n + " "));   // Ordered: 1 3 5 7 9 11
    System.out.println();

    Stream.of(1, 3, 5, 7, 9, 11)
          .dropWhile(n -> n % 2 != 0)                 // Drops all elements.
          .forEach(n -> System.out.print(n + " "));   // Empty stream
    System.out.println("\n-----------");

    // All match in unordered stream:
    Set<Integer> iSeq2 = Set.of(1, 9, 3, 7, 11, 5);
    iSeq2.stream()
         .takeWhile(n -> n % 2 != 0)                  // Takes all elements.
         .forEach(n -> System.out.print(n + " "));    // Unordered: 9 11 1 3 5 7
    System.out.println();

    iSeq2.stream()
         .dropWhile(n -> n % 2 != 0)                  // Drops all elements.
         .forEach(n -> System.out.print(n + " "));    // Empty stream
    System.out.println("\n-----------");

    // No match in ordered stream:
    Stream.of(2, 4, 6, 8, 10, 12)
          .takeWhile(n -> n % 2 != 0)                 // Takes no elements.
          .forEach(n -> System.out.print(n + " "));   // Empty stream
    System.out.println();

    Stream.of(2, 4, 6, 8, 10, 12)
          .dropWhile(n -> n % 2 != 0)                 // Drops no elements.
          .forEach(n -> System.out.print(n + " "));   // Ordered: 2 4 6 8 10 12
    System.out.println("\n-----------");

    // No match in unordered stream:
    Set<Integer> iSeq3 = Set.of(2, 10, 8, 12, 4, 6);
    iSeq3.stream()
         .takeWhile(n -> n % 2 != 0)                   // Takes no elements.
         .forEach(n -> System.out.print(n + " "));     // Empty stream
    System.out.println();

    iSeq3.stream()
         .dropWhile(n -> n % 2 != 0)                   // Drops no elements.
         .forEach(n -> System.out.print(n + " "));     // Unordered: 8 10 12 2 4 6
    System.out.println();
  }
}