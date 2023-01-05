
public class Average1 {

  public static void main(String[] args) {
    printAverage(100, 20);                                         // (1)
    System.out.println("Exit main().");                            // (2)
  }

  public static void printAverage(int totalSum, int totalCount) {
    int average = computeAverage(totalSum, totalCount);            // (3)
    System.out.println("Average = " +                              // (4)
        totalSum + " / " + totalCount + " = " + average);
    System.out.println("Exit printAverage().");                    // (5)
  }

  public static int computeAverage(int sum, int count) {
    System.out.println("Computing average.");                      // (6)
    return sum/count;                                              // (7)
  }
}