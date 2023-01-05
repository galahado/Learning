import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class UsingFormatElements {

  public static void main(String[] args) {

    String pattern2 = "At {3,time,short} on {2,date,medium} Elvis landed at {0} "
        +  "and was greeted by {1,number,integer} fans.";

    MessageFormat mf2 = new MessageFormat(pattern2);

    Object[] messageArguments = {
        "Honolulu",
        3000,
        ConvertToLegacyDate.ldToDate(LocalDate.of(1961,3,25)),
        ConvertToLegacyDate.ltToDate(LocalTime.of(12,15))
    };
    String output2 = mf2.format(messageArguments);
    System.out.println(output2);
  }
}