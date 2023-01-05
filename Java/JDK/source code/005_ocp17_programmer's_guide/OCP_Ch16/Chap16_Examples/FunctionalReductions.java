import static java.lang.System.out;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;

public final class FunctionalReductions {
  public static void main(String[] args) {

// Two-argument reduce() method:
  {
    out.println("(1) Find total number of tracks (loop-based version):");
    int sum = 0;                           // (1) Initialize the partial result.
    for (CD cd : CD.cdList) {              // (2) Iterate over the list.
      int numOfTracks = cd.noOfTracks();   // (3) Get the next value.
      sum = sum + numOfTracks;             // (4) Calculate new partial result.
    }
    out.println("Total number of tracks: " + sum);
  }

    out.println("(2) Find total number of tracks (stream-based version):");
    int totNumOfTracks = CD.cdList                         // (5)
        .stream()                                          // (6)
        .mapToInt(CD::noOfTracks)                          // (7)
        .reduce(0,                                         // (8)
                (sum, numOfTracks) -> sum + numOfTracks);  // (9)
    //  .reduce(0, (sum, noOfTracks) -> Integer.sum(sum, noOfTracks));
    //  .reduce(0, Integer::sum);
    //  .sum();
    out.println("Total number of tracks: " + totNumOfTracks);
    out.println();

    out.println("(3) Find total number of tracks (accumulator logging): ");
    int totNumOfTracks1 = CD.cdList                        // (10)
        .stream()
        .mapToInt(CD::noOfTracks)
        .reduce(0,                                         // (11)
            (sum, noOfTracks) -> {                         // (12)
                int newSum = sum + noOfTracks;
                out.printf("Accumulator: sum=%2d, noOfTracks=%2d, newSum=%2d%n",
                            sum, noOfTracks, newSum);
                return newSum;
            }
         );
    out.println("Total number of tracks: " + totNumOfTracks1);
    out.println();

// One-argument reduce() method:

    out.println("(4) Find total number of tracks (stream-based version):");
    OptionalInt optSumTracks0 = CD.cdList                  // (13)
        .stream()
        .mapToInt(CD::noOfTracks)
        .reduce(Integer::sum);                             // (14)
    out.println("Total number of tracks: " + optSumTracks0.orElse(0));
    out.println();

    out.println("(5) Find total number of tracks (accumulator logging): ");
    OptionalInt optSumTracks1 = CD.cdList                  // (15)
        .stream()
        .mapToInt(CD::noOfTracks)
        .reduce((sum, noOfTracks) -> {                     // (16)
           int newSum = sum + noOfTracks;
           out.printf("Accumulator: sum=%2d, noOfTracks=%2d, newSum=%2d%n",
                       sum, noOfTracks, newSum);
           return newSum;
         });
    out.println("Total number of tracks: " + optSumTracks1.orElse(0));
    out.println();

// Three-argument reduce() method:

    out.println("(6) Find total number of tracks (accumulator + combiner): ");
    Integer sumTracks5 = CD.cdList                         // (17)
    //  .stream()                                          // (18a)
        .parallelStream()                                  // (18b)
        .reduce(Integer.valueOf(0),                        // (19) Initial value
                (sum, cd) -> sum + cd.noOfTracks(),        // (20) Accumulator
                (sum1, sum2) -> sum1 + sum2);              // (21) Combiner
    out.println("Total number of tracks: " + sumTracks5);
    out.println();

    out.println("(7) Find total number of tracks (accumulator + combiner): ");
    Integer sumTracks6 = CD.cdList                         // (22)
//      .stream()                                          // (23a)
        .parallelStream()                                  // (23b)
        .reduce(0,
               (sum, cd) -> {                              // (24) Accumulator
                 Integer noOfTracks = cd.noOfTracks();
                 Integer newSum = sum + noOfTracks;
                 out.printf("Accumulator: sum=%2d, noOfTracks=%2d, "
                            + "newSum=%2d%n", sum, noOfTracks, newSum);
                 return newSum;
               },
               (sum1, sum2) -> {                           // (25) Combiner
                 Integer newSum = sum1 + sum2;
                 out.printf("Combiner: sum1=%2d, sum2=%2d, newSum=%2d%n",
                            sum1, sum2, newSum);
                 return newSum;
               }
         );
    out.println("Total number of tracks: " + sumTracks6);
    out.println();

    // Compare by CD title.
    Comparator<CD> cmpByTitle = Comparator.comparing(CD::title);    // (26)
    BinaryOperator<CD> maxByTitle =
        (cd1, cd2) -> cmpByTitle.compare(cd1, cd2) > 0 ? cd1 : cd2; // (27)

    // Query: Find maximum Jazz CD by title:
    Optional<CD> optMaxJazzCD = CD.cdList                  // (28)
        .stream()
        .filter(CD::isJazz)
        .reduce(BinaryOperator.maxBy(cmpByTitle));         // (29a)
    //  .reduce(maxByTitle);                               // (29b)
    //  .max(cmpByTitle);                                  // (29c)
    optMaxJazzCD.map(CD::title).ifPresent(out::println);// Keep on Erasing
  }
}