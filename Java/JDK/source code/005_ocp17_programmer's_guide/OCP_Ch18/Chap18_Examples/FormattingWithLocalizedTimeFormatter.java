import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class FormattingWithLocalizedTimeFormatter {
  public static void main(String[] args) {
    // Create some time formatters:
    DateTimeFormatter[] timeFormatters =  {                               // (1)
        DateTimeFormatter.ISO_LOCAL_TIME,
        DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT),
        DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM),
    };
    String[] formatStyles = {"ISO", "SHORT", "MEDIUM"};

    // Temporal objects:
    LocalTime time = LocalTime.of(14, 15, 30);
    LocalDate date = LocalDate.of(2021, 12, 1);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime,
                                                   ZoneId.of("US/Central"));

    System.out.println("Locale: " + Locale.getDefault());
    System.out.println("Style   Formatting of time, date-time, zoned date-time");
    int i = 0;
    for (DateTimeFormatter tf : timeFormatters) {
      try {
        String strTime1 = time.format(tf);                                // (2)
        String strTime2 = dateTime.format(tf);                            // (3)
        String strTime3 = zonedDateTime.format(tf);                       // (4)

        System.out.printf("%-7s", formatStyles[i++]);
        System.out.printf("%15s| %14s| %14s%n", strTime1, strTime2, strTime3);
      } catch (DateTimeException dte) {
        dte.printStackTrace();
        return;
      }
    }
    System.out.println();

    System.out.println("Style   Parsing of time string to time");
    i = 0;
    for (DateTimeFormatter tf : timeFormatters) {
      try {
        String strTime = time.format(tf);               // Date string to parse.
        LocalTime parsedTime = LocalTime.parse(strTime, tf);              // (5)
        System.out.printf("%-7s", formatStyles[i++]);
        System.out.printf("%15s%n", parsedTime.format(tf));
      } catch (DateTimeParseException pe) {
        pe.printStackTrace();
        return;
      } catch (DateTimeException dte) {
        dte.printStackTrace();
        return;
      }
    }
  }
}