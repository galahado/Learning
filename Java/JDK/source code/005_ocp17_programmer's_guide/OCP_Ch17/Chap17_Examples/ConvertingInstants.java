import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConvertingInstants {

  public static void main(String[] args) {

    Instant instant = Instant.parse("2021-04-28T03:15:00Z");
    ZoneId zid = ZoneId.of("America/New_York");
    LocalTime lt = LocalTime.ofInstant(instant, zid);           // 10:18:30
    LocalDate ld = LocalDate.ofInstant(instant, zid);           // 2021-04-27
    LocalDateTime ldt = LocalDateTime.ofInstant(instant, zid);  // 2021-04-27T23:15
    ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);  // 2021-04-27T23:15-04:00
    //  [America/New_York]
    System.out.println("instant: " + instant);
    System.out.println("Time zone: " + zid);
    System.out.println("lt: " + lt);
    System.out.println("ld: " + ld);
    System.out.println("ldt: " + ldt);
    System.out.println("zdt: " + zdt);
  }

}