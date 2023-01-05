package signatures;

import java.util.Collection;
import java.util.List;
//====== OVERRIDING AND OVERLOADING =================
class SupX {
  public void set(Collection<?> c) {/*...*/}
}
class SubX extends SupX {
  public void set(List<?> l) {/*...*/}      // (1) overloads
  @Override
  public void set(Collection c) {/*...*/}   // (2) overrides
}
//------------------------------------------
class SupY {
  public void set(Collection c) {/*...*/}
}

class SubY extends SupY {
  public void set(Collection<?> c) {/*...*/} // (3) Error: same erasure
}
//------------------------------------------
class SupC<T> {
  public void set(T t) {/*...*/}
  public T get() {return null;}
}

class SubC3<M,N> extends SupC<M> {
  public void set(N n) {/*...*/}  // Error: same erasure
  public N get() {return null;}   // Error: incompatible return type
}

class SubC4<M,N extends M> extends SupC<M> {
  public void set(N n) {/*...*/}  // Error: same erasure
  @Override
  public N get() {return null;}   // overrides
}
