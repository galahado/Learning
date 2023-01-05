import java.util.List;
import java.util.stream.Stream;

public final class StreamMode {
  public static void main(String[] args) {
    List<CD> cdList = CD.cdList;
    {
      Stream<String> iterStrream = Stream.iterate("ba", b -> b + "na");
      StringBuilder goBananas =
          iterStrream
          .limit(5)
          .parallel()
          .peek(e -> System.out.println("Before: " + iterStrream.isParallel()))
          .map(e -> e + "x")
//          .parallel()
//          .sequential()
          .peek(e -> System.out.println("After: " + iterStrream.isParallel()))
          .collect(StringBuilder::new,
                   StringBuilder::append,
                   (accum, b) -> accum.append("-").append(b));
      System.out.println(goBananas);
    }
  }
}
