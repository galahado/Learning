// File: StackUser.java
interface IStack {                                                        // (1)
  void   push(Object item);
  Object pop();
}
//______________________________________________________________________________
class Stack implements IStack {                                           // (2)
  protected Object[] elements;
  protected int      tos;  // top of stack

  public Stack(int capacity) {
    elements = new Object[capacity];
    tos        = -1;
  }

  @Override
  public void push(Object item) { elements[++tos] = item; }               // (3)

  @Override
  public Object pop() {                                                   // (4)
    Object objRef = elements[tos];
    elements[tos] = null;
    tos--;
    return objRef;
  }

  public Object peek() { return elements[tos]; }
}
//______________________________________________________________________________
interface ISafeStack extends IStack {                                     // (5)
  boolean isEmpty();
  boolean isFull();
}
//______________________________________________________________________________
class SafeStack extends Stack implements ISafeStack {                     // (6)

  public SafeStack(int capacity) { super(capacity); }
  @Override public boolean isEmpty() { return tos < 0; }                  // (7)
  @Override public boolean isFull()  { return tos >= elements.length-1; } // (8)
}
//______________________________________________________________________________
public class StackUser {

  public static void main(String[] args) {                                // (9)
    SafeStack  safeStackRef  = new SafeStack(10);
    Stack      stackRef      = safeStackRef;
    ISafeStack isafeStackRef = safeStackRef;
    IStack     istackRef     = safeStackRef;
    Object     objRef        = safeStackRef;

    safeStackRef.push("Dollars");                                         // (10)
    stackRef.push("Kroner");
    System.out.println(isafeStackRef.pop());
    System.out.println(istackRef.pop());
    System.out.println(objRef.getClass());
  }
}