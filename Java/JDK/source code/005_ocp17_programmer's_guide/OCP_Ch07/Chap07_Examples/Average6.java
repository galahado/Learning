
public class Average6 {

  public static void main(String[] args) {
    System.out.println("Value: " + printAverage(100, 20));         // (1)
    System.out.println("Exit main().");
  }

  public static int printAverage(int totalSum, int totalCount) {
    int average = 0;
    try {
      average = computeAverage(totalSum, totalCount);
      System.out.println("Average = " +
          totalSum + " / " + totalCount + " = " + average);
      return average;                                              // (2)
    } finally {
      System.out.println("Finally done.");
      return average*2;                                            // (3)
    }
  }

  public static int computeAverage(int sum, int count) {
    System.out.println("Computing average.");
    return sum/count;
  }
}