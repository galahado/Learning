import static java.lang.System.out;

import java.time.Year;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Matching {
  public static void main(String[] args) {

    boolean anyJazzCD = CD.cdList.stream().anyMatch(CD::isJazz);   // (1) true
    out.println("Any Jazz CD: " + anyJazzCD);

    boolean allJazzCds = CD.cdList.stream().allMatch(CD::isJazz);  // (2) false
    out.println("All CDs are only Jazz CDs: " + allJazzCds);

    boolean noJazzCds = CD.cdList.stream().noneMatch(CD::isJazz);  // (3) false
    out.println("There are no Jazz CDs: " + noJazzCds);

    // Predicates:
    Predicate<CD> eq2015 = cd -> cd.year().compareTo(Year.of(2015)) == 0;
    Predicate<CD> gt2015 = cd -> cd.year().compareTo(Year.of(2015)) > 0;

    boolean noneEQ2015 = CD.cdList.stream().noneMatch(eq2015);     // (4) true
    out.println("No CD released in 2015: " + noneEQ2015);

    boolean allGT2015 = CD.cdList.stream().allMatch(gt2015);       // (5) true
    out.println("All CDs released after 2015: " + allGT2015);

    boolean noneNotGT2015 = CD.cdList.stream().noneMatch(gt2015.negate()); //(6)
    out.println("No CDs released in or before 2015: " + noneNotGT2015);    // true

    IntStream yrStream = IntStream.of(2018, 2019, 2020);
    IntPredicate isLeapYear = yr -> Year.of(yr).isLeap();
    boolean anyLeapYear = yrStream.anyMatch(isLeapYear);
    out.println("Any leap year: " + anyLeapYear);   // true
  }
}