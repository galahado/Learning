
public class Average2 {

  public static void main(String[] args) {
    printAverage(100, 20);                                         // (1)
    System.out.println("Exit main().");                            // (2)
  }

  public static void printAverage(int totalSum, int totalCount) {
    try {                                                          // (3)
      int average = computeAverage(totalSum, totalCount);          // (4)
      System.out.println("Average = " +                            // (5)
          totalSum + " / " + totalCount + " = " + average);
    } catch (ArithmeticException ae) {                             // (6)
      ae.printStackTrace();                                        // (7)
      System.out.println("Exception handled in printAverage().");  // (8)
    }
    System.out.println("Exit printAverage().");                    // (9)
  }

  public static int computeAverage(int sum, int count) {
    System.out.println("Computing average.");                      // (10)
    return sum/count;                                              // (11)
  }
}