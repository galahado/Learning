import static java.lang.System.out;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public final class Finding {
  public static void main(String[] args) {

    Optional<CD> firstCD1 = CD.cdList.stream().findFirst();     // (1)
    out.println(firstCD1.map(CD::title)
                        .orElse("No first CD."));               // (2) Java Jive

    Optional<CD> anyCD2 = CD.cdList.stream().parallel().findAny();  // (3)
    out.println(anyCD2.map(CD::title).orElse("No CD."));// (4) Lambda Dancing

    // filter() with findAny() contrasted with anyMatch().
    boolean anyJazzCD = CD.cdList.stream().anyMatch(CD::isJazz);    // (5)
    out.println("Any Jazz CD: " + anyJazzCD);               // Any Jazz CD: true
    Optional<CD> optJazzCD = CD.cdList.stream().filter(CD::isJazz)
                                               .findAny();          // (6)
    optJazzCD.ifPresent(out::println);      // <Jaav, "Java Jam", 6, 2017, JAZZ>

    //Stream.generate(() -> 1).filter(n -> n == 0).findAny(); // Never terminates.

    IntStream numStream = IntStream.of(50, 55, 65, 70, 75, 77);
    OptionalInt intOpt = numStream.filter(n -> n % 7 == 0).findAny();
    intOpt.ifPresent(System.out::println);
  }
}