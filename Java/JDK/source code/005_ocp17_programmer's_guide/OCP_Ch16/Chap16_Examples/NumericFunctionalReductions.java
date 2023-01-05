import static java.lang.System.out;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public final class NumericFunctionalReductions {
  public static void main(String[] args) {
    out.println(CD.cdList);

    // Counting:
    long numOfCDS = CD.cdList.stream().count();                        // 5
    out.println("Number of CDs: " + numOfCDS);

    long numOfJazzCDs = CD.cdList.stream().filter(CD::isJazz).count(); // 3
    out.println("Number of Jazz CDs: " + numOfJazzCDs);

    IntStream numStream = IntStream.rangeClosed(1, 100);
    long divBy7 = numStream.filter(n -> n % 7 == 0).count();
    out.println("Numbers divisible by 7: " + divBy7);

    // Find min/max element:
    Optional<CD> minCD = CD.cdList.stream().min(Comparator.naturalOrder());
    minCD.ifPresent(out::println); // <Funkies, "Lambda Dancing", 10, 2018, POP>
    out.println(minCD.map(CD::artist).orElse("No min CD.")); // Funkies

    Optional<CD> maxCD = CD.cdList.stream().max(Comparator.naturalOrder());
    maxCD.ifPresent(out::println); // <Jaav, "Java Jam", 6, 2017, JAZZ>
    out.println(maxCD.map(CD::artist).orElse("No max CD.")); // Jaav

    IntStream iStream = IntStream.rangeClosed(1, 100);
    OptionalInt maxNum = iStream.filter(n -> n % 7 == 0).max();  // 98
    maxNum.ifPresent(System.out::println);
  }
}