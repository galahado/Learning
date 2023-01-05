import java.util.Arrays;
import java.util.stream.IntStream;

public final class CollectingToArray {
  public static void main(String[] args) {

    Object[] objArray = CD.cdList.stream().map(CD::title)
        .toArray();                     // (1)
        //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
    System.out.println(Arrays.toString(objArray));

    String[] cdTitles = CD.cdList.stream().map(CD::title)
        .toArray(String[]::new);         // (2)
        //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
    System.out.println(Arrays.toString(cdTitles));

    int[] intArray1 = IntStream.iterate(1, i -> i + 1).limit(5).toArray();// (3)
    // [1, 2, 3, 4, 5]
    System.out.println(Arrays.toString(intArray1));

    int[] intArray2 = IntStream.range(-5, 5).toArray();                   // (4)
    // [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4]
    System.out.println(Arrays.toString(intArray2));

    //  int[] intArray3 = IntStream.iterate(1, i -> i + 1)                // (5)
    //                             .toArray();  // OutOfMemoryError!
    //  System.out.println(Arrays.toString(intArray3));

    CD[] cdArray1 = CD.cdList.stream().toArray(CD[]::new);    // (6)  Not efficient.
    CD[] cdArray2 = CD.cdList.toArray(new CD[CD.cdList.size()]);   // (7) Preferred.
  }
}