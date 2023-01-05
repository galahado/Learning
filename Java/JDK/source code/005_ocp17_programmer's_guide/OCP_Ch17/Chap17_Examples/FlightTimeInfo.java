import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class FlightTimeInfo {
  public static void main(String[] args) {
    try {
      // Departure from New York at 8:30pm on July 4, 2021.                  (1)
      LocalDateTime departure = LocalDateTime.of(2021, Month.JULY, 4, 20, 30);
      ZoneId departureZone = ZoneId.of("America/New_York");
      ZonedDateTime departureZDT = ZonedDateTime.of(departure, departureZone);

      // Flight time is 7 hours and 30 minutes.
      // Calculate local arrival time at London:                             (2)
      ZoneId arrivalZone = ZoneId.of("Europe/London");
      ZonedDateTime arrivalZDT
          = departureZDT.withZoneSameInstant(arrivalZone)
                        .plusMinutes(7*60 + 30);
      System.out.printf("DEPARTURE:  %s%n", departureZDT);
      System.out.printf("ARRIVAL:    %s%n", arrivalZDT);

      // Flight time as a Duration:                                          (3)
      Duration flightduration = Duration.between(departureZDT, arrivalZDT);
      System.out.println("Flight duration:     " + flightduration);

      // Flight time in minutes:                                             (4)
      long flightTime = departureZDT.until(arrivalZDT, ChronoUnit.MINUTES);
      System.out.println("Flight time (mins.): " + flightTime);

      System.out.printf(                                                  // (5)
          "Time at departure airport on arrival: %s%n",
          departureZDT.plusMinutes(7*60 + 30));

      System.out.printf(                                                  // (6)
          "Time at departure airport on arrival: %s%n",
          arrivalZDT.withZoneSameInstant(departureZone));

    } catch (DateTimeException e) {
      e.printStackTrace();
    }
  }
}