class GenericTLC<A> {             // (1) Top-level class

  static class SMC<B> {/*...*/}   // (2) Static member class

  interface SMI<C> {/*...*/}      // (3) Static member interface

  class NSMC<D> {/*...*/}         // (4) Non-static member (inner) class

  void nsm() {
    class NSLC<E> {/*...*/}       // (5) Local (inner) class in non-static context
  }

  static void sm() {
    class SLC<F> {/*...*/}        // (6) Local (inner) class in static context
  }

  // Anonymous classes as parameterized types:
  SMC<A> xsf = new SMC<A>() {     // (7) In non-static context.
    /*...*/                       //     A is type parameter in top-level class.
  };
  SMC<Integer> nsf = new SMC<Integer>() {           // (8) In non-static context
    /*...*/
  };
  static SMI<String> sf = new SMI<String>() {       // (9) In static context
    /*...*/
  };
  SMC<String> nsf1 = new SMC<>() {                  // (10) Using diamond operator
    /*...*/
  };
}