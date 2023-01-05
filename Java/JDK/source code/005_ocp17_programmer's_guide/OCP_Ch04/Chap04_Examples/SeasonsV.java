
public class SeasonsV {
  enum Season { WINTER, SPRING, SUMMER, FALL }                    // (1)

  public static void main(String[] args) {
    int monthNumber = 11;
    Season season = switch(monthNumber) {                         // (2)
      case 12,  1,  2 -> Season.WINTER;                           // (3)
      case  3,  4,  5 -> Season.SPRING;                           // (4)
      case  6,  7,  8 -> Season.SUMMER;                           // (5)
      case  9, 10, 11 -> Season.FALL;                             // (6)
      default         -> throw new IllegalArgumentException(monthNumber +
                                                           " not a valid month.");
    };
    System.out.println(season);
  }
}