import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingCompactNumbers {
  public static void main(String[] args) {

    // Create an array of locales:
    Locale[] locales = { Locale.US, Locale.US };

    NumberFormat shortCompactFormat = NumberFormat.getCompactNumberInstance(
            Locale.US, NumberFormat.Style.SHORT);
    NumberFormat longCompactFormat = NumberFormat.getCompactNumberInstance(
            Locale.US, NumberFormat.Style.LONG);

    System.out.println(longCompactFormat instanceof CompactNumberFormat);


    // Create an array of compact formatters:
    NumberFormat[] compactFormatters = new NumberFormat[] {
        shortCompactFormat,         // US
        longCompactFormat           // DR
    };

    // Format a number by different compact formatters:                    (2)
    System.out.println("\nFormatting compact numbers:");
    runFormatters(20234567.89, compactFormatters, locales);
    runFormatters(223456.89, compactFormatters, locales);
    runFormatters(223.89, compactFormatters, locales);

    // Set the max decimal digits to 2 for number formatters:              (3)
    for (NumberFormat nf : compactFormatters) {
      nf.setMaximumFractionDigits(2);
    }
    System.out.println("\nFormatting a number " +
                       " (to max 2 dec. places):");
    runFormatters(1_234_567.567, compactFormatters, locales);
    runFormatters(123_456.567, compactFormatters, locales);
    runFormatters(123.567, compactFormatters, locales);

    // Parsing a number:                                                   (4)
    runParsers("2M", compactFormatters, locales);
    runParsers("223,56K", compactFormatters, locales);
    runParsers("1234@567", compactFormatters, locales);
  }

  /** Runs the formatters on the value. */
  static void runFormatters(double value, NumberFormat[] formatters,    // (6)
                            Locale... locales) {
    for (int i = 0; i < formatters.length; i++) {
      System.out.printf("%7s: %s%n", locales[i],
                                     formatters[i].format(value));      // (7)
    }
  }

  /** Runs the parsers on the input string. */
  static void runParsers(String inputString, NumberFormat[] formatters, // (8)
                         Locale... locales) {
    System.out.println("\nParsing: " + inputString);
    for (int i = 0; i < formatters.length; i++) {
      try {
        System.out.printf("%7s: ", locales[i]);
        System.out.printf("%s%n",  formatters[i].parse(inputString));   // (9)
      } catch (ParseException pe) {
        System.out.println(pe);
      }
    }
  }
}