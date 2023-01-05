import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class UsingVanillaFormatElements {

  public static void main(String[] args) {
    String pattern = "At {3} on {2} Elvis landed at {0} " +
                     "and was greeted by {1} fans.";

    String output = MessageFormat.format(pattern, "Honolulu", 3000,
                                 LocalDate.of(1961,3,25), LocalTime.of(12,15));
    System.out.println(output);

    Object[] messageArguments = {
        "Honolulu",
        3000,
        LocalDate.of(1961,3,25),         // Date
        LocalTime.of(12,15)              // Time
    };

    String output2 = MessageFormat.format(pattern, messageArguments);
    System.out.println(output2);

    MessageFormat formatter = new MessageFormat(pattern);
    String output3 = formatter.format(messageArguments);
    System.out.println(output3);  }
}