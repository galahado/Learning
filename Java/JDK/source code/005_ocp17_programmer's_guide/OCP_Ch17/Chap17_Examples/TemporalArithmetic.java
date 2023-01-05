import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TemporalArithmetic {

  public static void main(String[] args) {

    LocalDate date = LocalDate.of(2021, 10, 23);           // (1)
    System.out.println("Date:             " + date);       // 2021-10-23
    date = date.plusMonths(10);                            // (2)
    System.out.println("10 months after:  " + date);       // 2022-08-23
    date = date.plusWeeks(3);                              // (3)
    System.out.println("3 weeks after:    " + date);       // 2022-09-13
    date = date.plusDays(40);                              // (4)
    System.out.println("40 days after:    " + date);       // 2022-10-23

    date = date.minus(2, ChronoUnit.DAYS);                 // (5)
    System.out.println("2 days before:    " + date);       // 2022-10-21
    date = date.minus(4, ChronoUnit.WEEKS);                // (6)
    System.out.println("4 weeks before:   " + date);       // 2022-09-23
    date = date.minus(11, ChronoUnit.MONTHS);              // (7)
    System.out.println("11 months before: " + date);       // 2021-10-23
  }
}