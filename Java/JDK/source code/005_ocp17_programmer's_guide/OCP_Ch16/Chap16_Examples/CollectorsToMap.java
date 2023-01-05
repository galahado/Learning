import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectorsToMap {
  public static void main(String[] args) {

    {
      //Query: Create a map of cd titles and their release year.
      Map<String, Year> mapTitleToYear = CD.cdList.stream()
          .collect(Collectors.toMap(CD::title, CD::year));
      System.out.println(mapTitleToYear);
    }

    {
      //Query: Create a map of cds and their release year.
      Map<CD, Year> mapCDToYear = CD.cdList.stream()
          .collect(Collectors.toMap(Function.identity(), CD::year));
      System.out.println(mapCDToYear);
    }

    {
      //Query: Create a map of CD titles and their release year (collisions).
      List<CD> dupList = List.of(CD.cd0, CD.cd1, CD.cd2, CD.cd0, CD.cd1);
      //Map<String, Year> mapTitleToYear1 = dupList.stream()
      //    .collect(Collectors.toMap(CD::getTitle, CD::getYear));
      //System.out.println(mapTitleToYear1);
      // java.lang.IllegalStateException: Duplicate key 2017

      Map<String, Year> mapTitleToYear2 = dupList.stream()
          .collect(Collectors.toMap(CD::title, CD::year, (y1, y2) -> y1));
      System.out.println(mapTitleToYear2);
    }

    {
      //Query: Create a map of release year and titles released each year.
      Map<Year, String> mapYearToTitles = CD.cdList.stream()
          .collect(Collectors.toMap(CD::year, CD::title,
              (tt, t) -> tt + ":" + t));
      System.out.println(mapYearToTitles);
      System.out.println(mapYearToTitles instanceof HashMap);
    }

    {
      //Query: Create a TreeMap of release year and longest title released each year.
      TreeMap<Year, String> mapYearToLongestTitle = CD.cdList.stream()
          .collect(Collectors.toMap(CD::year, CD::title,
              //                              BinaryOperator.maxBy(Comparator.naturalOrder()),
              (str1, str2) -> str1.compareTo(str2) > 0
              ? str1 : str2,
                  TreeMap::new));
      System.out.println(mapYearToLongestTitle);
    }

    {
      //Query: Create a concurrent map of CD titles released each year.
      ConcurrentMap<Year, String> concMapYearToTitles = CD.cdList
          .parallelStream()
          .collect(Collectors.toConcurrentMap(CD::year, CD::title,
              (tt, t) -> tt + ":" + t));
      System.out.println(concMapYearToTitles);
      //{2017=Java Jam:Java Jive, 2018=Lambda Dancing:Hot Generics:Keep on Erasing}
    }
  }
}