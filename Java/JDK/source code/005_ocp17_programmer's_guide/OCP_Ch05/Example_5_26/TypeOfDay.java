
public class TypeOfDay {

  public static void main(String[] args) {
    Day day = Day.MONDAY;
    //    String typeOfDay = switch (day) {
    //      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
    //      case SATURDAY, SUNDAY -> "Weekend";
    //      default -> "No such day!";
    //    };

    String typeOfDay = switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday"; // (1)
      case SATURDAY, SUNDAY -> "Weekend";                             // (2)
    };

    typeOfDay = switch (day) {
      case SATURDAY, SUNDAY -> "Weekend";                             // (3)
      default -> "Weekday";                                           // (4)
    };

    typeOfDay = switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday"; // (5)
      default -> "Weekend";                                           // (6)
    };
    System.out.println(typeOfDay);
  }
}