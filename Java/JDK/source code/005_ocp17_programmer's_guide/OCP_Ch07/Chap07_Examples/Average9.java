// File: Average9.java
public class Average9 {
  public static void main(String[] args) {
    try {                                                     // (1)
      int sum         = Integer.parseInt(args[0]);            // (2)
      int numOfValues = Integer.parseInt(args[1]);            // (3)
      printAverage(sum, numOfValues);                         // (4)
    } catch (ArrayIndexOutOfBoundsException aioob) {          // (5) uni-catch
      System.out.println(aioob);
      System.out.println("Usage: java Average9 <sum of values> <no. of values>");
    } catch (NumberFormatException nfe) {                     // (6) uni-catch
      System.out.println(nfe);
      System.out.println("Usage: java Average9 <sum of values> <no. of values>");
    } catch (IntegerDivisionByZero idbz) {                    // (7) uni-catch
      idbz.printStackTrace();
      System.out.println("Exception handled in main().");
    } finally {                                               // (8)
      System.out.println("Finally done in main().");
    }
    System.out.println("Exit main().");                       // (9)
  }

  public static void printAverage(int totalSum, int totalCount)
      throws IntegerDivisionByZero {
    int average = computeAverage(totalSum, totalCount);
    System.out.println("Average = " +
        totalSum + " / " + totalCount + " = " + average);
    System.out.println("Exit printAverage().");
  }

  public static int computeAverage(int sum, int count)
      throws IntegerDivisionByZero {
    System.out.println("Computing average.");
    if (count == 0)
      throw new IntegerDivisionByZero();
    return sum/count;
  }
}
