
public class Seasons {
  public static void main(String[] args) {
    int monthNumber = 11;
    switch(monthNumber) {                                     // (1) Outer
      case 12: case 1: case 2:                                // (2)
        System.out.println("Snow in the winter.");
        break;
      case 3, 4: case 5:                                      // (3)
        System.out.println("Green grass in the spring.");
        break;
      case 6, 7, 8:                                           // (4)
        System.out.println("Sunshine in the summer.");
        break;
      case 9, 10, 11:                                         // (5)
        switch(monthNumber) { // Nested switch                   (6) Inner
          case 10:
            System.out.println("Halloween.");
            break;
          case 11:
            System.out.println("Thanksgiving.");
            break;
        } // End nested switch
        // Always printed for case constant 9, 10, 11
        System.out.println("Yellow leaves in the fall.");     // (7)
        break;
      default:
        System.out.println(monthNumber + " is not a valid month.");
    }
  }
}