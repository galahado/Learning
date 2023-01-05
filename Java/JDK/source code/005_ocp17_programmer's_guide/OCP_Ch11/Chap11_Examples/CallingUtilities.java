
public class CallingUtilities {
  public static void main(String[] args) {
    Integer[] intArray = {10, 20, 30};

 boolean f1 = Utilities.<Integer>containsV2(20, intArray);           // (1) true
 // E is Integer.
 // Method signature:      containsV2(Integer, Integer[])
 // Method call signature: containsV2(Integer, Integer[])

 boolean f2 = Utilities.<Number>containsV2(30.5, intArray);          // (2) false
 // E is Number.
 // Method signature:      containsV2(Number, Number[])
 // Method call signature: containsV2(Double, Integer[])

 boolean f3 = Utilities.<Comparable<Integer>> containsV2(20, intArray); // (3) true
 // E is Comparable<Integer>.
 // Method signature:      containsV2(Comparable<Integer>, Comparable<Integer>[])
 // Method call signature: containsV2(Integer,             Integer[])

 boolean f4 = Utilities.<Integer>containsV2(30.5, intArray);         // (4) Error!
 // E is Integer.
 // Method signature:      containsV2(Integer, Integer[])
 // Method call signature: containsV2(Double,  Integer[])

 // Requires explicit reference or raw type.
 boolean f5 = <Integer>containsV2(20, intArray);              // (5) Syntax error!

 boolean f6 = Utilities.containsV2(20, intArray);                    // (6) true
 // E is inferred to be Integer.
 // Method signature:      containsV2(Integer, Integer[])
 // Method call signature: containsV2(Integer, Integer[])

 boolean f7 = Utilities.containsV2(30.5, intArray);                  // (7) false;
 // E is inferred to be Number.
 // Method signature:      containsV2(Number, Number[])
 // Method call signature: containsV2(Double, Integer[])

 boolean f8 = Utilities.containsV2("Hi", intArray);                  // (8) false;
 // E is inferred to be Serializable.
 // Method signature:      containsV2(Serializable, Serializable[])
 // Method call signature: containsV2(String, Integer[])

 boolean f9 = Utilities.<Integer>containsV2("Hi", intArray);         // (9) Error!
 // E is Integer.
 // Method signature:      containsV2(Integer, Integer[])
 // Method call signature: containsV2(String, Integer[])

 boolean f10 = Utilities.containsV3(30.5, intArray);                 // (10) false
 // K is inferred to be Double. E is inferred to be Number.
 // The constraint (K extends E) is satisfied.
 // Method signature:      containsV3(Double, Number[])
 // Method call signature: containsV2(Double, Integer[])

 boolean f11 = Utilities.containsV3("Hi", intArray);                 // (11) false
 // K is inferred to be String. E is inferred to be Serializable.
 // The constraint (K extends E) is satisfied.
 // Method signature:      containsV3(String, Serializable[])
 // Method call signature: containsV2(String, Integer[])

 boolean f12 = Utilities.<Number, Number>containsV3(30.0, intArray); // (12) false
 // K is Number. E is Number.
 // The constraint (K extends E) is satisfied.
 // Method signature:      containsV3(Number, Number[])
 // Method call signature: containsV3(Double, Integer[])

 boolean f13 = Utilities.<Number, Integer>
                         containsV3(30.5, intArray);                 // (13) Error!
 // K is Number. E is Integer.
 // The constraint (K extends E) is not satisfied.

 boolean f14 = Utilities.<Integer, Number>
                         containsV3(30.5, intArray);                 // (14) Error!
 // K is Integer. E is Number.
 // The constraint (K extends E) is satisfied.
 // Method signature:      containsV3(Integer, Number[])
 // Method call signature: containsV3(Double, Integer[])

 boolean f15 = Utilities.<Number>containsV3(30.5, intArray);         // (15) Error!
 // Incorrect no. of type parameters.

    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f3);
    //System.out.println(f4);
    //System.out.println(f5);
    System.out.println(f6);
    System.out.println(f7);
    System.out.println(f8);
    //System.out.println(f9);
    System.out.println(f10);
    System.out.println(f11);
    System.out.println(f12);
    //System.out.println(f13);
    //System.out.println(f14);
    //System.out.println(f15);
  }
}