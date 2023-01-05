import java.time.Year;
import java.util.List;

public final class SimpleExample {
  public static void main(String[] args) {
    List<String> values = List.of("2001", "1999", "2021");
    for (String s : values) {
      Year y = Year.parse(s);
      if (y.isAfter(Year.of(2000))) {
        System.out.print(s + " ");
      }
    }
    System.out.println();

    List<String> values2 = List.of("2001", "1999", "2021");
    values2.stream()                                    // (1)
    .map(s -> Year.parse(s))                     // (2)
    .filter(y -> y.isAfter(Year.of(2000)))       // (3)
    .forEach(y -> System.out.print(y + " "));  // (4)
  }
}