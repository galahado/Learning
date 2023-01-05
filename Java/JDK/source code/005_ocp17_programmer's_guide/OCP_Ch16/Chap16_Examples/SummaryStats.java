import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public final class SummaryStats {
  public static void main(String[] args) {

    /* Functional reduction for Numeric Streams*/
    { // Summation
      int totNumOfTracks = CD.cdList.stream()           // Stream<CD>
          .mapToInt(CD::noOfTracks)                  // IntStream
          .sum();                                       // 42
      System.out.println(totNumOfTracks);

      int sumEven = IntStream.rangeClosed(1, 100)
          .filter(i -> i % 2 == 0)
          .sum();                                        // 2550
      System.out.println(sumEven);

      double total = DoubleStream.empty().sum();         // 0.0
      System.out.println(total);
    }

    { // Counting
      int numOfCDs = CD.cdList.stream()
          .mapToInt(cd -> 1)
          .sum();                                      // 5
      System.out.println(numOfCDs);
    }

    { // Average number of tracks on a CD.
      OptionalDouble optAvg = OptionalDouble.empty();
      if (CD.cdList.size() != 0) {
        int sumTracks = 0;
        for (CD cd: CD.cdList) {
          int numOfTracks = cd.noOfTracks();
          sumTracks += numOfTracks;
        }
        optAvg = OptionalDouble.of((double) sumTracks / CD.cdList.size());
      }
      System.out.println((int)optAvg.orElse(0.0));
    }

    {
      OptionalDouble optAverage = CD.cdList.stream()
          .mapToInt(CD::noOfTracks)
          .average();
      System.out.println(optAverage.orElse(0.0));
    }

    {
      //Summary statistics
      IntSummaryStatistics stats1 = List.of(CD.cd0, CD.cd1).stream()
          .mapToInt(CD::noOfTracks)
          .summaryStatistics();
      System.out.println("Count="   + stats1.getCount());        // Count=2
      System.out.println("Sum="     + stats1.getSum());          // Sum=14
      System.out.println("Min="     + stats1.getMin());          // Min=6
      System.out.println("Max="     + stats1.getMax());          // Max=8
      System.out.println("Average=" + stats1.getAverage());      // Average=7.0

      System.out.println(stats1);
      //IntSummaryStatistics{count=2, sum=14, min=6, average=7.000000, max=8}

      stats1.accept(CD.cd2.noOfTracks());  // Add the value 8.
      System.out.println(stats1);
      //IntSummaryStatistics{count=3, sum=24, min=6, average=8.000000, max=10}

      IntSummaryStatistics stats2 = List.of(CD.cd3, CD.cd4).stream()
          .mapToInt(CD::noOfTracks)
          .summaryStatistics();
      System.out.println(stats2);
      //IntSummaryStatistics{count=2, sum=18, min=8, average=9.000000, max=10}

      stats1.combine(stats2);                 // Combine stats2 with stats1.
      System.out.println(stats1);
      //IntSummaryStatistics{count=5, sum=42, min=6, average=8.400000, max=10}

      //Initial statistics
      IntSummaryStatistics emptyStats = IntStream.empty().summaryStatistics();
      System.out.println(emptyStats);
      //IntSummaryStatistics{count=0, sum=0, min=2147483647, average=0.000000, max=-2147483648}
    }
  }
}