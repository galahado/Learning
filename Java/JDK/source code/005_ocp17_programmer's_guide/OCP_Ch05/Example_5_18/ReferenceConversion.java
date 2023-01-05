
public class ReferenceConversion {

  public static void main(String[] args) {
    // Reference declarations:
    Object     objRef;
    Stack      stackRef;
    SafeStack  safeStackRef;
    IStack     iStackRef;
    ISafeStack iSafeStackRef;

    // SourceType is a class type:
    safeStackRef  = new SafeStack(10);
    objRef        = safeStackRef;    // (1) Always possible
    stackRef      = safeStackRef;    // (2) Subclass to superclass assignment
    iStackRef     = stackRef;        // (3) Stack implements IStack
    iSafeStackRef = safeStackRef;    // (4) SafeStack implements ISafeStack

    // SourceType is an interface type:
    objRef    = iStackRef;           // (5) Always possible
    iStackRef = iSafeStackRef;       // (6) Sub- to superinterface assignment

    // SourceType is an array type:
    Object[]     objArray          = new Object[3];
    Stack[]      arrayOfStack      = new Stack[3];
    SafeStack[]  arrayOfSafeStack  = new SafeStack[5];
    ISafeStack[] arrayOfISafeStack = new ISafeStack[5];
    int[]        intArray          = new int[10];

    // Reference value assignments:
    objRef     = objArray;           // (7) Always possible
    objRef     = arrayOfStack;       // (8) Always possible
    objArray   = arrayOfStack;       // (9) Always possible
    objArray   = arrayOfISafeStack;  // (10) Always possible
    objRef     = intArray;           // (11) Always possible
    //  objArray   = intArray;       // (12) Compile-time error:
                                     //      int[] not subtype of Object[]
    arrayOfStack = arrayOfSafeStack; // (13) Subclass array to superclass array
    arrayOfISafeStack = arrayOfSafeStack; // (14) SafeStack implements
                                          //      ISafeStack

    // Method invocation conversions:
    System.out.println("First call:");
    sendParams(stackRef, safeStackRef, iStackRef,
               arrayOfSafeStack, arrayOfISafeStack);                   // (15)
    //  Call Signature: sendParams(Stack, SafeStack, IStack,
    //                             SafeStack[], ISafeStack[]);

    System.out.println("Second call:");
    sendParams(arrayOfISafeStack, stackRef, iSafeStackRef,
               arrayOfStack, arrayOfSafeStack);                        // (16)
    //  Call Signature: sendParams(ISafeStack[], Stack, ISafeStack,
    //                             Stack[], SafeStack[]);
  }

  public static void sendParams(Object objRefParam, Stack stackRefParam,
      IStack iStackRefParam, Stack[] arrayOfStackParam,
      IStack[] arrayOfIStackParam) {                                    // (17)
    //  Signature: sendParams(Object, Stack, IStack, Stack[], IStack[])
    //  Print class name of object denoted by the reference at runtime.
    System.out.println(objRefParam.getClass());
    System.out.println(stackRefParam.getClass());
    System.out.println(iStackRefParam.getClass());
    System.out.println(arrayOfStackParam.getClass());
    System.out.println(arrayOfIStackParam.getClass());
  }
}
