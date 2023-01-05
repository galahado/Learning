interface IStack {
  void push(Object item);
  Object pop();
}

class Stack implements IStack {
  protected Object[] elements;
  protected int tos;

  public Stack(int capacity) {
    elements = new Object[capacity];
    tos = -1;
  }

  @Override
  public void push(Object item)
  { elements[++tos] = item; }

  @Override
  public Object pop() {
    Object objRef = elements[tos];
    elements[tos] = null;
    tos--;
    return objRef;
  }

  public Object peek() { return elements[tos]; }
}

interface ISafeStack extends IStack {
  boolean isEmpty();
  boolean isFull();
}

class SafeStack extends Stack implements ISafeStack {

  public SafeStack(int capacity) { super(capacity); }
  @Override public boolean isEmpty() { return tos < 0; }
  @Override public boolean isFull() { return tos >= elements.length - 1; }
}