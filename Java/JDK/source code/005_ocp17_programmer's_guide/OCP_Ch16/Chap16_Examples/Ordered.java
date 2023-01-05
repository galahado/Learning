import java.time.Year;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class Ordered {

  public static Consumer<Object> NOOP = any -> {};

  public static void main(String[] args) {
    {
      //      long startTime = System.currentTimeMillis();
      //      long finishTime = System.currentTimeMillis();
      //      System.out.println("Execution time: " + (finishTime - startTime) + " ms");
    }

    //    for (int i = 0; i <= 1000; ++i) xqtOrdered();
    //    for (int i = 0; i <= 1000; ++i) xqtUnordered();
    //  for (int i = 0; i <= 1000; ++i) xqtParallel();

    //
    // Ordered/Unordered.
    {
      //Query: Create a list with the first 2 Jazz CD titles.
      //List<String> first2JazzCDTitles = CD.cdList
      //   .stream()
      //   .unordered()                                  // Don't care for ordering.
      //   .filter(CD::isJazz)
      //   .limit(2)
      //   .map(CD::getTitle)
      //   .toList();                // [Java Jam, Keep on Erasing]
      //System.out.println(first2JazzCDTitles);
      //System.out.println();
    }

    // Sequential & Parallel
    {
      Stream<CD> seqStream1
      = CD.cdList.stream().filter(CD::isPop);                         // Sequential
      Stream<CD> seqStream2
      = CD.cdList.stream().sequential().filter(CD::isPop);            // Sequential
      Stream<CD> seqStream3
      = CD.cdList.stream().parallel().filter(CD::isPop).sequential(); // Sequential
      Stream<CD> paraStream1
      = CD.cdList.stream().parallel().filter(CD::isPop);              // Parallel
      Stream<CD> paraStream2
      = CD.cdList.stream().filter(CD::isPop).parallel();              // Parallel

      System.out.println(seqStream3.isParallel());                      // false

      System.out.println("seqStream1 is "
          + (seqStream1.isParallel() ? "parallel." : "not parallel."));
      System.out.println("seqStream2 is "
          + (seqStream2.isParallel() ? "parallel." : "not parallel."));
      System.out.println("seqStream3 is "
          + (seqStream3.isParallel() ? "parallel." : "not parallel."));
      System.out.println("paraStream1 is "
          + (paraStream1.isParallel() ? "parallel." : "not parallel."));
      System.out.println("paraStream2 is "
          + (paraStream2.isParallel() ? "parallel." : "not parallel."));
    }
    {
      CD.cdList.stream()
      .sequential()
      .map(CD::title)
      .forEach(System.out::println);
      System.out.println();

      CD.cdList.stream()
      .parallel()
      .map(CD::title)
      .forEach(System.out::println);
      System.out.println();
    }
  }

  private static void xqtOrdered() {
    // Query: Create a list with the first 2 CDs that were released in 2018.
    long startTime = System.currentTimeMillis();
    List<CD> cds2018 = List.of(CD.cd0, CD.cd1, CD.cd2, CD.cd3, CD.cd4)
        .stream()
        .filter(cd -> cd.year().equals(Year.of(2018)))
        .limit(2)
        .toList();
    long finishTime = System.currentTimeMillis();
    System.out.println("Execution time (ordered): " + (finishTime - startTime) + " ms");
    // System.out.println(cds2018);
  }

  private static void xqtUnordered() {
    //Query: Create a list with the first 2 CDs that were released in 2018.
    long startTime = System.currentTimeMillis();
    List<CD> cds2018 = List.of(CD.cd0, CD.cd1, CD.cd2, CD.cd3, CD.cd4)
        .stream()
        //   .parallel()
        .unordered()      // Don't care for ordering: don't care how it is executed.
        .filter(cd -> cd.year().equals(Year.of(2018)))
        .limit(2)
        .toList();
    long finishTime = System.currentTimeMillis();
    System.out.println("Execution time (unordered): " + (finishTime - startTime) + " ms");
    //System.out.println(cds2018);
    //System.out.println();
  }

  static private void xqtParallel() {
    Stream<CD> paraStream = CD.cdList.stream().parallel();
    System.out.println("paraStream is parallel: " + paraStream.isParallel());
    List<String> result =
        paraStream.unordered()
        .skip(2)
        .map(CD::title)
        .toList();
    System.out.println(result);
  }

}