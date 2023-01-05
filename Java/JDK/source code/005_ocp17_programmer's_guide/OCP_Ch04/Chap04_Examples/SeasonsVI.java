
public class SeasonsVI {

  enum Season { WINTER, SPRING, SUMMER, FALL }                              // (1)
  record SeasonInfo(int month, Season season) {}                            // (2)

  public static void main(String[] args) {
    int monthNumber = 11;
    SeasonInfo seasonInfo = switch(monthNumber) {                           // (3)
      case 12,  1,  2 -> new SeasonInfo(monthNumber, Season.WINTER);        // (4)
      case  3,  4,  5 -> new SeasonInfo(monthNumber, Season.SPRING);        // (5)
      case  6,  7,  8 -> new SeasonInfo(monthNumber, Season.SUMMER);        // (6)
      case  9, 10, 11 -> new SeasonInfo(monthNumber, Season.FALL);          // (7)
      default         -> throw new IllegalArgumentException(monthNumber +
                                                           " not a valid month.");
    };
    System.out.println(seasonInfo);
  }
}