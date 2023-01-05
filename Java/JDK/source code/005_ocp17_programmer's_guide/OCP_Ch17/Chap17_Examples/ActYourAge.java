import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class ActYourAge {

  public static void main(String[] args) {
    birthdayInfo(LocalDate.of(1981, Month.AUGUST, 19));
    birthdayInfo(LocalDate.of(1935, Month.JANUARY, 8));
  }

  public static void birthdayInfo(LocalDate dateOfBirth) {           // (1)
    LocalDate today = LocalDate.now();
    System.out.println("Today:         " + today);

    System.out.println("Date of Birth: " + dateOfBirth);
    Period p1 = Period.between(dateOfBirth, today);                  // (2)
    System.out.println("Age:           " + 
                                 p1.getYears()  + " years, " +
                                 p1.getMonths() + " months, and " +
                                 p1.getDays()   + " days");

    LocalDate nextBirthday =  dateOfBirth.withYear(today.getYear()); // (3)
    if (nextBirthday.isBefore(today) ||                              // (4)
        nextBirthday.isEqual(today)) {
      nextBirthday = nextBirthday.plusYears(1);                      // (5)
    }
    Period p2 = today.until(nextBirthday);                           // (6)
    System.out.println("Birthday in " + p2.getMonths() + " months and " +
                                        p2.getDays()   + " days");
  }
}