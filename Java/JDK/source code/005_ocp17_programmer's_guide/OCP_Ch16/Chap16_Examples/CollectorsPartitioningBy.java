import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class CollectorsPartitioningBy {
  public static void main(String[] args) {
    {
      // Query: Partition by whether it is a cd with pop music.
      Map<Boolean, List<CD>> map1 = CD.cdList.stream()
          .collect(Collectors.partitioningBy(CD::isPop));                      // (1)
      System.out.println(map1);
      List<CD> popCDs = map1.get(true);
      List<CD> nonPopCDs = map1.get(false);
      System.out.println(popCDs);
      System.out.println(nonPopCDs);
    }
    {
      Map<Boolean, List<CD>> map2 = CD.cdList.stream()
          .collect(Collectors.partitioningBy(CD::isPop, Collectors.toList())); // (2)
      System.out.println(map2);

    }

    {
      Map<Boolean, Long> map3 = CD.cdList.stream()
          .collect(Collectors.partitioningBy(CD::isPop, Collectors.counting()));
      //{false=3, true=2}
      System.out.println(map3);
    }

    {
      // Query: Partition by whether it is a cd with pop music, then group by year.
      Map<Boolean, Map<Year, List<CD>>> map1 = CD.cdList.stream()
          .collect(Collectors.partitioningBy(CD::isPop,
              Collectors.groupingBy(CD::year)));
      System.out.println(map1);
    }

    //_________________ Extra
    {
      // Query: Partition by whether it is a cd with pop music, then group by year, count the years.
      Map<Boolean, Map<Year, Long>> map1 = CD.cdList.stream()
          .collect(Collectors.partitioningBy(CD::isPop,
              Collectors.groupingBy(CD::year,
                  Collectors.counting())));
      System.out.println(map1);
    }

    {
      Map<Boolean, Optional<CD>> map2 = CD.cdList.stream()
          .collect(Collectors.partitioningBy(CD::isPop,                         // (3)
              Collectors.maxBy(Comparator.comparing(CD::year))      // (4)
              ));
      System.out.println(map2);
    }

    {
      Collector<CD,?,Optional<CD>> col =  Collectors.maxBy(Comparator.naturalOrder());
      Map<Boolean, Optional<CD>> map2 = CD.cdList.stream()
          .collect(Collectors.partitioningBy(CD::isPop,                         // (3)
              Collectors.<CD>maxBy(Comparator.naturalOrder())          // (4)
              ));
      System.out.println(map2);
    }
  }
}