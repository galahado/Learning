import java.time.Year;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class CollectorsMapping {
  public static void main(String[] args) {
    /*
 For example, given a stream of Person, to accumulate the set of last names in each city:
     Map<City, Set<String>> lastNamesByCity
         = people.stream().collect(groupingBy(Person::getCity,
                                              mapping(Person::getLastName, toSet())));
     */
    // Query: Accumulate the set of CD titles in each year to a set.
    // T == CD
    // U == String
    // A
    // R == Set<Sring>
    /*
   static <T,U,A,R> Collector<T,?,R> mapping(
       Function<? super T,? extends U> mapper,
       Collector<? super U,A,R> downstream)
     */

    // Query: accumulate a set of CD titles in each year.
    Map<Year, Set<String>> titlesByYearInSet = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::year,
            Collectors.mapping(CD::title, Collectors.toSet()))); // (1)
    System.out.println(titlesByYearInSet);
    // {2017=[Java Jive, Java Jam],
    //  2018=[Hot Generics, Lambda Dancing, Keep on Erasing]}

    //Query: join CD titles in each year.
    Map<Year, String> joinTitlesByYear = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::year,
            Collectors.mapping(                                      // (2)
                CD::title,
                Collectors.joining(":"))));
    System.out.println(joinTitlesByYear);
    // {2017=Java Jive:Java Jam,
    //  2018=Lambda Dancing:Keep on Erasing:Hot Generics}

    // Query: count the number of tracks in each year.
    Map<Year, Long> numOfTracksByYear4 = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::year,
            Collectors.mapping(                                      // (3)
                CD::noOfTracks,
                Collectors.counting())));
    System.out.println(numOfTracksByYear4); // {2017=2, 2018=3}
  }
}