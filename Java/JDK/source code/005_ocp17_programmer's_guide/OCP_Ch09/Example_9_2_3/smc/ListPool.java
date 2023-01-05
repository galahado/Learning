// File: ListPool.java
package smc;

public class ListPool {                          // (1) Top-level class

  public static class MyLinkedList {             // (2) Static member class

    private interface ILink { }                  // (3) Static member interface

    public static class BiNode                   // (4) Static member class
                  implements IBiLink {

      public static void printSimpleName() {     // (5) Static method
        System.out.println(BiNode.class.getSimpleName());
      }

      public void printName() {                  // (6) Instance method
        System.out.println(this.getClass().getName());
      }
    } // end BiNode
  } // end MyLinkedList

  interface IBiLink
            extends MyLinkedList.ILink {         // (7) Static member interface
//  private static class Traversal { }           // (8) Compile-time error!
                                                 //     Can only be public.
    class BiTraversal { }                        // (9) Class is public and static
  } // end IBiLink

  public class SortedList {                      // (10) Non-static member class
    private static class SortCriteria {}         // (11) Static member class
  }
}