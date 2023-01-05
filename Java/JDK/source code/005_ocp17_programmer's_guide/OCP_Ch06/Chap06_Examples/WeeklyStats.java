import java.util.Arrays;

public final class WeeklyStats {              // (1) Class is final.

  private final String description;           // (2) Immutable string
  private final int weekNumber;               // (3) Immutable primitive value
  private final int[] stats;                  // (4) Mutable int array

  public WeeklyStats(String description, int weekNumber, int[] stats) {   // (5)
    if (weekNumber <= 0 || weekNumber > 52) {
      throw new IllegalArgumentException("Invalid week number: " + weekNumber);
    }
    if (stats.length != 7) {
      throw new IllegalArgumentException("Stats not for whole week: " +
                                          Arrays.toString(stats));
    }
    this.description = description;
    this.weekNumber = weekNumber;
    this.stats = Arrays.copyOf(stats, stats.length);   // Create a private copy.
  }

  public int getWeekNumber() {                // (6) Returns immutable primitive.
    return weekNumber;
  }

  public String getDescription() {            // (7) Returns immutable string.
    return description;
  }

  public int getDayStats(int dayNumber) {     // (8) Returns stats for given day.
    return (0 <= dayNumber && dayNumber < 7) ? stats[dayNumber] : -1;
  }

  public int[] getStats() {                   // (9) Returns a copy of the stats.
    return Arrays.copyOf(this.stats, this.stats.length);
  }

  @Override
  public String toString() {
    return description + "(week " + weekNumber + "):" + Arrays.toString(stats);
  }
}