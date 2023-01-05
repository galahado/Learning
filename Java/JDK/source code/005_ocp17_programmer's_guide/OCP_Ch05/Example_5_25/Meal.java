// File: Meal.java
public enum Meal {
  BREAKFAST(7,30), LUNCH(12,15), DINNER(19,45);             // (1)

  // Non-zero argument constructor                             (2)
  Meal(int hh, int mm) {
    this.hh = hh;
    this.mm = mm;
  }

  // Fields for the meal time:                                 (3)
  private int hh;
  private int mm;

  // Instance methods:                                         (4)
  public int getHour() { return this.hh; }
  public int getMins() { return this.mm; }
  public String getTimeString() {                              // "hh:mm"
    return String.format("%02d:%02d", this.hh, this.mm);
  }
}