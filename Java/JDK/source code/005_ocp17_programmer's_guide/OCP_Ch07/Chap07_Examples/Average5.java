
public class Average5 {

  public static void main(String[] args) {
    printAverage(100, 0);                                          // (1)
    System.out.println("Exit main().");
  }

  public static void printAverage(int totalSum, int totalCount) {
    try {                                                          // (2)
      int average = computeAverage(totalSum, totalCount);
      System.out.println("Average = " +
          totalSum + " / " + totalCount + " = " + average);
    } finally {                                                    // (3)
      System.out.println("Finally done.");
    }
    System.out.println("Exit printAverage().");
  }

  public static int computeAverage(int sum, int count) {
    System.out.println("Computing average.");
    return sum/count;                                              // (4)
  }
}