class SupZ<T> {
  public void set(T t) {/*...*/}            // (1)
}

class SubZ<E> extends SupZ {                // Superclass not parameterized
  @Override public void set(E e) {/*...*/}  // (1a) Error: same erasure
}