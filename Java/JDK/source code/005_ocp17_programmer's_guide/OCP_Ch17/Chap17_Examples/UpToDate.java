import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class UpToDate {

  public static void main(String[] args) {

    // Today's date:
    LocalDate today = LocalDate.now();
    System.out.println("Today's Date: " + today);

    // Creating a specific date from constituent parts:
    LocalDate birthday = LocalDate.of(2014, Month.JANUARY, 11);
    System.out.println("Date of Birth: "+ birthday);

    // Querying for specific dates:
    LocalDate engagementDate = LocalDate.ofEpochDay(1021);
    System.out.println("Engagment date: " + engagementDate);

    LocalDate aprilFirst = LocalDate.ofYearDay(2021, 91);
    System.out.println("April Fool's Day: " + aprilFirst);
  }
}