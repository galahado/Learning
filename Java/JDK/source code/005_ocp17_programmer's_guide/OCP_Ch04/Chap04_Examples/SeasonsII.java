
public class SeasonsII {
  public static void main(String[] args) {
    int monthNumber = 11;
    switch(monthNumber) {                                             // (1) Outer
      case 12, 1,  2 -> System.out.println("Snow in the winter.");    // (2)
      case 3,  4,  5 -> System.out.println("Green grass in the spring.");   // (3)
      case 6,  7,  8 -> System.out.println("Sunshine in the summer.");      // (4)
      case 9, 10, 11 -> {                                             // (5)
        switch(monthNumber) { // Nested switch                           (6) Inner
          case 10 -> System.out.println("Halloween.");
          case 11 -> System.out.println("Thanksgiving.");
        }
        // Always printed for case constants 9, 10, 11:
        System.out.println("Yellow leaves in the fall.");             // (7)
      }
      default -> throw new IllegalArgumentException(monthNumber +
                                            " is not a valid month.");// (8)
    }
  }
}