public class BitOperations {
  public static void main(String[] args) {
    char v1 = ')';                      // Unicode value 41
    byte v2 = 13;
    printIntToStr("v1:", v1);           // 41
    printIntToStr("v2:", v2);           // 13
    printIntToStr("~v1:", ~v1);         // -42
    printIntToStr("v1 & v2:", v1 & v2); // 9
    printIntToStr("v1 | v2:", v1 | v2); // 45
    printIntToStr("v1 ^ v2:", v1 ^ v2); // 36
  }

  public static void printIntToStr(String label, int result) {
    System.out.println(label);
    System.out.println("    Binary:  " + Integer.toBinaryString(result));
    System.out.println("    Hex:     " + Integer.toHexString(result));
    System.out.println("    Decimal: " + result);
  }
}