import java.util.Arrays;
import java.util.stream.IntStream;

public final class BehavioralParameters {
  public static int sum = 0;
  public static void main(String[] args) {

    // Statefull behavioral parameters.
    for (int j = 0; j <10; ++j) {
    sum = 0;
    int[] oddArray = IntStream
        .rangeClosed(10,20).parallel().filter(i -> i % 2 != 0)
        .peek(i -> { sum = sum + i; })                          // Side-effect
        .toArray();
    System.out.println(sum + ": " + Arrays.toString(oddArray));
    }
    System.out.println();

    // Stateless behavioral parameters.
    for (int j = 0; j < 10; ++j) {
      sum = 0;
      int[] oddArray2 = IntStream
          .rangeClosed(10, 20).parallel()
          .filter(i -> i % 2 != 0)
          .toArray();
      sum = Arrays.stream(oddArray2).parallel().sum();
      System.out.println(sum + ": " + Arrays.toString(oddArray2));
    }

    // Interfering behavioral parameters.
//    List<CD> miscCDs = List.of(CD.cd0, CD.cd1, CD.cd2));
//    miscCDs.stream()
//           .filter(CD::isPop)
//           .peek(cd -> miscCDs.add(cd))     // Modifying stream data source!!
//           .forEach(System.out::println);
   }
}