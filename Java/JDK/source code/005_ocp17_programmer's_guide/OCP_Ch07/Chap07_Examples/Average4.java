
public class Average4 {

  public static void main(String[] args) {
    printAverage(100, 20);                                         // (1)
    System.out.println("Exit main().");
  }

  public static void printAverage(int totalSum, int totalCount) {
    try {                                                          // (2)
      int average = computeAverage(totalSum, totalCount);
      System.out.println("Average = " +
          totalSum + " / " + totalCount + " = " + average);
    } catch (ArithmeticException ae) {                             // (3)
      ae.printStackTrace();
      System.out.println("Exception handled in printAverage().");
    } finally {                                                    // (4)
      System.out.println("Finally done.");
    }
    System.out.println("Exit printAverage().");                    // (5)
  }

  public static int computeAverage(int sum, int count) {
    System.out.println("Computing average.");
    return sum/count;
  }
}