// File: ExceptionErrors.java

// (1) A generic class cannot extend Exception:
class MyGenericException<T> extends Exception { }        // Compile-time error!

public class ExceptionErrors {

  // (2) Cannot specify parameterized types in throws clause:
  public static void main(String[] args)
                     throws MyGenericException<String> { // Compile-time error!
    try {
      throw new MyGenericException<String>();
    } // (3) Cannot use parameterized type in catch block:
      catch (MyGenericException<String> e) {             // Compile-time error!
      e.printStackTrace();
    }
  }
}