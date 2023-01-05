import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class MappingMulti {
  public static void main(String[] args) {

    Stream<Number> numbers = Stream.of(4, 3.14, 6, 1L, 8, 0.0, 10);
    BiConsumer<Number, Consumer<Integer>> bc = (number, consumer) -> {
      if (number instanceof Integer i) {
        consumer.accept(i);
      }
    };
    List<Integer> integers = numbers.mapMulti(bc).toList();
    System.out.println(integers);                           // [4, 6, 8, 10]
    System.out.println("_______________");

    numbers = Stream.of(4, 3.14, 6, 1L, 8, 0.0, 10);
    BiConsumer<Number, Consumer<String>> bc2 = (number, consumer) -> {
      if (number instanceof Integer i) {
        consumer.accept(i + ":" + "*".repeat(i));
      }
    };
    numbers.mapMulti(bc2).forEach(System.out::println);
    /*
     ****
     ******
     ********
     **********
     */
    System.out.println("_______________");
    List<?> nestedList = List.of(1, List.of(2, List.of(3, 4)), 5);
    Stream<?> expandedStream = nestedList.stream().mapMulti(MappingMulti::expandIterable);
    System.out.println(expandedStream.toList());

    System.out.println("_______________");
    // One-to-one
    BiConsumer<CD, Consumer<String>> bcA = (cd, consumer) -> {
      if (cd.genre() == Genre.POP) {
        consumer.accept(String.format("%-15s: %s", cd.title(),
            "*".repeat(cd.noOfTracks())));
      }
    };
    CD.cdList.stream()
    .mapMulti(bcA)
    .forEach(System.out::println);
    System.out.println("_______________");
    // One-to-many
    List<CD> cdList1 = List.of(CD.cd0, CD.cd1, CD.cd1);
    List<CD> cdList2 = List.of(CD.cd0, CD.cd1);
    BiConsumer<List<CD>, Consumer<String>> bcB = (lst, consumer) -> {
      for (CD cd : lst) {
        consumer.accept(cd.title());
      }
    };
    List<String> listOfCDTitles = Stream.of(cdList1, cdList2)  // Stream<List<CD>>
        .mapMulti(bcB)
        .distinct()
        .toList();
    System.out.println(listOfCDTitles);
    System.out.println("_______________");
    // Type witness
    List<?> listOfCDTitles2 = Stream.of(cdList1, cdList2) // Stream<List<CD>>
        .mapMulti((lst, consumer) -> {                     // (1a)
          //      .<String>mapMulti((lst, consumer) -> {                     // (1a)
          //    .mapMulti((List<CD> lst, Consumer<String> consumer) -> {   // (1b)
          for (CD cd : lst) {
            consumer.accept(cd.title());
          }
        })
        .distinct()
        .toList();
    System.out.println(listOfCDTitles2);
    System.out.println("_______________");
  }

  static void expandIterable(Object e, Consumer<Object> c) {
    if (e instanceof Iterable<?> elements) {
      for (Object ie : elements) {
        expandIterable(ie, c);
      }
    } else if (e != null) {
      c.accept(e);
    }
  }
}