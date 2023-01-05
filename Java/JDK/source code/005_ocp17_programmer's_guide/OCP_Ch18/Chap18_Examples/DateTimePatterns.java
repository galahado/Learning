import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimePatterns {
  public static void main(String[] args) {
    // Date to format.
    Date today = new Date();    // Current time and date.

    Locale[] locales = {
        new Locale("no","NO"),  // Norway
        new Locale("de","DE"),  // Germany
        new Locale("en","US")   // United States
    };
    String[] patterns = {
        "d/M/y",
        "yyyy.MM.dd G @ hh:mm:ss z",
        "yyyy.MMMMM.dd GGG hh:mm aaa",
        "EEEE d MMM y G zzzz",
        "EEE, MMM d'th', ''yy",
        "h:m a",
        "H:mm",
        "HH:mm:ss:SSS zzz",
    };

    System.out.println(
        "Formatting date according to a given pattern (" + patterns[3] +
            ") for different locales:");
    for (Locale locale : locales) {
      SimpleDateFormat formatter = new SimpleDateFormat(patterns[3], locale);
      String result = formatter.format(today);
      System.out.printf("%s    %s%n", locale.toString(), result);
    }

    System.out.println(
        "\nFormatting date/time according to different patterns" +
            " for a given locale (" + locales[2].toString() + "):");
    for (String pattern : patterns) {
      SimpleDateFormat formatter = new SimpleDateFormat(pattern, locales[2]);
      String output = formatter.format(today);
      System.out.printf("%27s    %s%n", pattern, output);
    }
  }
}