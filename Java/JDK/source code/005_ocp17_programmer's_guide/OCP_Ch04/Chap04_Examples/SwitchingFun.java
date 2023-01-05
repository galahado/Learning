enum SpiceGrade { MILD, MEDIUM, MEDIUM_HOT, HOT, SUICIDE; }   // (1)

public class SwitchingFun {
  public static void main(String[] args) {
    SpiceGrade spicing = SpiceGrade.HOT;
    switch (spicing) {                                // (2)
      case HOT ->  System.out.println("Have fun!");   // (3a) OK!
//    case SpiceGrade.HOT                             // (3b) Compile-time error!
//         -> System.out.println("Have fun!");
      case SUICIDE -> System.out.println("Good luck!");
      default -> System.out.println("Enjoy your meal!");
    }
  }
}