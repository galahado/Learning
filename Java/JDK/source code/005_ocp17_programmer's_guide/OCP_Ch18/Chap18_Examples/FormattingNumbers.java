import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbers {
  public static void main(String[] args) {

    // Create an array of locales:
    Locale[] locales = { Locale.US, Locale.GERMANY };

    // Create an array of number formatters:
    NumberFormat[] numFormatters = new NumberFormat[] {
        NumberFormat.getNumberInstance(locales[0]),         // US
        NumberFormat.getNumberInstance(locales[1])          // Germany
    };

    // Create an array of currency formatters:
    NumberFormat[] currFormatters = new NumberFormat[] {
        NumberFormat.getCurrencyInstance(locales[0]),       // US
        NumberFormat.getCurrencyInstance(locales[1]),       // Germany
    };

    // Number to format:
    double number = 1234.567;

    // Format a number by different number formatters:                     (1)
    System.out.println("Formatting the number: " + number);
    runFormatters(number, numFormatters, locales);

    // Set the max decimal digits to 2 for number formatters:              (2)
    for (NumberFormat nf : numFormatters) {
      nf.setMaximumFractionDigits(2);
    }
    System.out.println("\nFormatting the number " +
                       number + " (to max 2 dec. places):");
    runFormatters(number, numFormatters, locales);

    // Format a currency amount by different currency formatters:          (3)
    System.out.println("\nFormatting the currency amount: " + number);
    runFormatters(number, currFormatters, locales);

    // Parsing a number:                                                   (4)
    runParsers("1234.567", numFormatters, locales);
    runParsers("1234,567", numFormatters, locales);
    runParsers("1234@567", numFormatters, locales);

    // Parsing a currency amount:                                          (5)
    runParsers("$1234.56", currFormatters, locales);
    runParsers("1234,56\u00a0€", currFormatters, locales);             // nbsp
  }

  /** Runs the formatters on the value. */
  static void runFormatters(double value, NumberFormat[] formatters,    // (6)
                            Locale[] locales) {
    for (int i = 0; i < formatters.length; i++) {
      System.out.printf("%7s: %s%n", locales[i],
                                     formatters[i].format(value));      // (7)
    }
  }

  /** Runs the parsers on the input string. */
  static void runParsers(String inputString, NumberFormat[] formatters, // (8)
                         Locale[] locales) {
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