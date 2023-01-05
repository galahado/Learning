import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class DateTimeFormattingPatterns {
  public static void main(String[] args) {
    // Temporals:
    LocalTime time = LocalTime.of(14, 45, 30);
    LocalDate date = LocalDate.of(1972, 12, 2);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    ZoneId zID = ZoneId.of("Europe/Paris");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zID);

    // Formatting patterns:
    String[] patterns = {
        "dd/MM/uu",
        "u/M/d",
        "d MMMM uuuu",
        "'Anniversary': d MMMM",
        "uuuu.MM.dd",
        "uuuu.MM.dd@hh:mm:ss",
        "uuuu.MMMM.dd hh:mm a",
        "EEEE, MMM d'th', ''uu",
        "EE d MM uu",
        "E d M u",
        "h:m a",
        "hh:mm",
        "HH:mm ZZZZ",
        "HH:mm:ssZZZZZ'['VV']'",
        "'Hour': HH",
        "EEE at hh:mm", // IllegalArgumentException - Unknown pattern letter: t
        "hh::mmm",      // IllegalArgumentException - Too many pattern letters: m
    };

    System.out.println("Formatting temporal (" + zonedDateTime + ")\n" +
                       "with different patterns:");
    for (String pattern : patterns) {
      String output;
      try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern); // (1)
        formatter = formatter.localizedBy(Locale.US);                       // (2)
        output = zonedDateTime.format(formatter);                           // (3)
      } catch (IllegalArgumentException | DateTimeException e) {
        output = String.format("%s - %s", e.getClass().getSimpleName(),
                               e.getMessage());
      }
      System.out.printf("%26s  %s%n", pattern, output);
    }
  }
}