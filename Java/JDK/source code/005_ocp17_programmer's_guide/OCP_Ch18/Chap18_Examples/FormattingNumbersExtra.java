import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbersExtra {

  public static void main(String[] args) {

    // Numbers to format:
    double num1 = 12345.6789;
    double num2 = 1234.426;

    // Formatting numbers:
    NumberFormat nfmtUS = NumberFormat.getNumberInstance(Locale.US);
    NumberFormat nfmtDE = NumberFormat.getNumberInstance(Locale.GERMANY);

    System.out.printf("Format number: %9s %9s%n", num1, num2);
    System.out.printf("%13s: ", Locale.US);
    System.out.printf("%8s ", nfmtUS.format(num1));
    System.out.printf("%8s%n", nfmtUS.format(num2));

    System.out.printf("%13s: ", Locale.GERMANY);
    System.out.printf("%8s ", nfmtDE.format(num1));
    System.out.printf("%8s%n", nfmtDE.format(num2));
    System.out.println();

    // Formatting currency:
    NumberFormat cfmtUS = NumberFormat.getCurrencyInstance(Locale.US);
    NumberFormat cfmtDE = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    System.out.printf("Format currency: %11s %13s%n", num1, num2);
    System.out.printf("%15s: ", Locale.US);
    System.out.printf("%10s ", cfmtUS.format(num1));
    System.out.printf("%13s%n", cfmtUS.format(num2));

    System.out.printf("%15s: ", Locale.GERMANY);
    System.out.printf("%12s ", cfmtDE.format(num1));
    System.out.printf("%13s%n", cfmtDE.format(num2));
    System.out.println();

    // Formatting percentage
    NumberFormat pfmtUS = NumberFormat.getPercentInstance(Locale.US);
    NumberFormat pfmtDE = NumberFormat.getPercentInstance(Locale.GERMANY);

    // Set maximum decimal places.
    pfmtUS.setMaximumFractionDigits(1);
    pfmtDE.setMaximumFractionDigits(1);

    num1 = 0.1246;
    num2 = 0.1355;
    System.out.printf("Format percentage: %9s %11s%n", num1, num2);
    System.out.printf("%17s: ", Locale.US);
    System.out.printf("%9s ", pfmtUS.format(num1));
    System.out.printf("%11s%n", pfmtUS.format(num2));

    System.out.printf("%17s: ", Locale.GERMANY);
    System.out.printf("%10s ", pfmtDE.format(num1));
    System.out.printf("%11s%n", pfmtDE.format(num2));
    System.out.println();

    // Rounding
    System.out.println("Rounding:");
    // Set the max decimal digits and rounding mode for number formatters:
    int maxFractionDigits = 0;
    nfmtUS.setMaximumFractionDigits(maxFractionDigits);

    nfmtUS.setRoundingMode(RoundingMode.CEILING);
    System.out.printf("%9s: ", RoundingMode.CEILING);
    System.out.printf("%5s -> %s ", 1.1, nfmtUS.format(1.1));
    System.out.printf("%5s -> %s%n", -1.8, nfmtUS.format(-1.8));

    nfmtUS.setRoundingMode(RoundingMode.FLOOR);
    System.out.printf("%9s: ", RoundingMode.FLOOR);
    System.out.printf("%5s -> %s ", 1.8, nfmtUS.format(1.8));
    System.out.printf("%5s -> %s%n", -1.1, nfmtUS.format(-1.1));

    nfmtUS.setRoundingMode(RoundingMode.UP);
    System.out.printf("%9s: ", RoundingMode.UP);
    System.out.printf("%5s -> %s ", 1.1, nfmtUS.format(1.1));
    System.out.printf("%5s -> %s%n", -1.1, nfmtUS.format(-1.1));

    nfmtUS.setRoundingMode(RoundingMode.DOWN);
    System.out.printf("%9s: ", RoundingMode.DOWN);
    System.out.printf("%5s -> %s ", 1.8, nfmtUS.format(1.8));
    System.out.printf("%5s -> %s%n", -1.8, nfmtUS.format(-1.8));

    nfmtUS.setRoundingMode(RoundingMode.HALF_UP);
    System.out.printf("%9s: ", RoundingMode.HALF_UP);
    System.out.printf("%5s -> %s ", 1.5, nfmtUS.format(1.5));
    System.out.printf("%5s -> %s%n", 1.4, nfmtUS.format(1.4));

    nfmtUS.setRoundingMode(RoundingMode.HALF_DOWN);
    System.out.printf("%9s: ", RoundingMode.HALF_DOWN);
    System.out.printf("%5s -> %s ", 1.6, nfmtUS.format(1.6));
    System.out.printf("%5s -> %s%n", 1.5, nfmtUS.format(1.5));

    nfmtUS.setRoundingMode(RoundingMode.HALF_EVEN);
    System.out.printf("%9s: ", RoundingMode.HALF_EVEN);
    System.out.printf("%5s -> %s ", 1.6, nfmtUS.format(1.6));
    System.out.printf("%5s -> %s%n", 1.5, nfmtUS.format(1.5));

    // Parsing
    try {
      System.out.println("-------------------------------");

      // Number parsing
      String str1 = "1234.567";
      String str2 = "1234,567";
      String str3 = "1234@567";

      System.out.printf("Parse: %10s%11s%11s%n", str1, str2, str3);
      System.out.printf("%5s: ", Locale.US);
      System.out.printf("%10s ", nfmtUS.parse(str1));
      System.out.printf("%10s ", nfmtUS.parse(str2));
      System.out.printf("%10s%n", nfmtUS.parse(str3));

      System.out.printf("%5s: ", Locale.GERMANY);
      System.out.printf("%10s ", nfmtDE.parse(str1));
      System.out.printf("%10s ", nfmtDE.parse(str2));
      System.out.printf("%10s%n", nfmtDE.parse(str3));
      System.out.println("-------------------------------");

      // Currency parsing
      String str4 = "$1234.56";
      String str5 = "1234,56\u00a0€";

      System.out.println("Parse: " + str4);
      System.out.printf("%5s: ", Locale.US);
      System.out.printf("%8s%n", cfmtUS.parse(str4));

      System.out.println("Parse: " + str5);
      System.out.printf("%5s: ", Locale.GERMANY);
      System.out.printf("%8s%n", cfmtDE.parse(str5));
      System.out.println("-------------------------------");

      // Percentage parsing
      String str6 = "12.5%";
      String str7 = "12,5\u00a0%";
//      String str7 = "12,5%";
      System.out.println("Parse: " + str6);
      System.out.printf("%5s: ", Locale.US);
      System.out.printf("%8s%n", pfmtUS.parse(str6));

      System.out.println("Parse: " + str7);
      System.out.printf("%5s: ", Locale.GERMANY);
      System.out.printf("%8s%n", pfmtDE.parse(str7));
      System.out.println();

      System.out.println("----------BigDecimal--------------------");

//      double num = 12345.6789;
      BigDecimal num = new BigDecimal("12345.6789");
      Locale locNOR = new Locale("no", "NO");                 // Norway
      NumberFormat nfNOR = NumberFormat.getNumberInstance(locNOR);
      System.out.println(nfNOR.format(num));                  // 12 345,679

      NumberFormat nfUS = NumberFormat.getNumberInstance(Locale.US);
      System.out.println(nfUS.format(num));                   // 12,345.679

      System.out.println(nfNOR.parse("9876.598"));     // (1) 9876
      System.out.println(nfNOR.parse("9876,598"));     // (2) 9876.598

      System.out.println(nfUS.parse("9876.598"));     // (1) 9876
      System.out.println(nfUS.parse("9876,598"));     // (2) 9876.598

      DecimalFormat dfUS = (DecimalFormat) nfUS;
      dfUS.setParseBigDecimal(true);
      Number number = dfUS.parse("9876,598");
      System.out.println(number instanceof BigDecimal); // true

    } catch (ParseException pe) {
      System.out.println(pe.getMessage());
//    System.out.println(pe);
    }


  }
}