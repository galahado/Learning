import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public final class Collecting {
  public static void main(String[] args) {

    // Query: Create a list with the number of tracks on each CD.
    System.out.println("Sequential Mutable Reduction:");
    List<Integer> tracks = CD.cdList                          // (1)
        .stream()                                             // (2a)
//      .parallelStream()                                     // (2b)
        .map(CD::noOfTracks)                                  // (3)
        .collect(() -> new ArrayList<>(),                     // (4) Supplier
                 (cont, noOfTracks) -> cont.add(noOfTracks),  // (5) Accumulator
                 (cont1, cont2) -> cont1.addAll(cont2));      // (6) Combiner
//      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // (6a)
//      .toList();
    System.out.println("Number of tracks on each CD (sequential): " + tracks);
    System.out.println();

    System.out.println("Parallel Mutable Reduction:");
    List<Integer> tracks1 = CD.cdList                         // (7)
//      .stream()                                             // (8a)
        .parallelStream()                                     // (8b)
        .map(CD::noOfTracks)                                  // (9)
        .collect(                                             // (10)
            () -> {                                           // (11) Supplier
              System.out.println("Supplier: Creating an ArrayList");
              return new ArrayList<>();
            },
            (cont, noOfTracks) -> {                           // (12) Accumulator
              System.out.printf("Accumulator: cont:%s, noOfTracks:%s",
                                 cont, noOfTracks);
              cont.add(noOfTracks);
              System.out.printf(", mutCont:%s%n", cont);
            },
            (cont1, cont2) -> {                               // (13) Combiner
              System.out.printf("Combiner: con1:%s, cont2:%s", cont1, cont2);
              cont1.addAll(cont2);
              System.out.printf(", mutCont:%s%n", cont1);
            });
    System.out.println("Number of tracks on each CD (parallel): " + tracks1);
    System.out.println();

    // Query: Create an ordered set with CD titles, according to natural order.
    Set<String> cdTitles = CD.cdList                          // (14)
        .stream()
        .map(CD::title)
        .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);// (15)
    System.out.println("CD titles: " + cdTitles);
    System.out.println();

    // Query: Go bananas.
    StringBuilder goneBananas = Stream                        // (16)
        .iterate("ba", b -> b + "na")                         // (17)
        .limit(5)
        .peek(System.out::println)
        .collect(StringBuilder::new,                          // (18)
                 StringBuilder::append,
                 StringBuilder::append);
    System.out.println("Go bananas: " + goneBananas);
  }
}