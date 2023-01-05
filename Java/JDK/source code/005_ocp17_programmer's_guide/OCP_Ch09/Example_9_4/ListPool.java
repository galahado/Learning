// File: ListPool.java
public class ListPool {                                 // Top-level class

  public void messageInListPool() {                     // Instance method
    System.out.println("This is a ListPool object.");
  }

  private static class MyLinkedList {                   // (1) Static member class
    private static int maxNumOfLists = 100;             // Static field
    private int currentNumOfLists;                      // Instance field

    public static void messageInLinkedList() {          // Static method
      System.out.println("This is MyLinkedList class.");
    }

    interface ILink { int MAX_NUM_OF_NODES = 2000; }// (2) Static member interface

    protected static class Node implements ILink {  // (3) Static member class

      private int max = MAX_NUM_OF_NODES;           // (4) Instance field

      public void messageInNode() {                 // Instance method
//      int currentLists = currentNumOfLists;// (5) Not OK. Access instance field
                                             //             in outer class
        int maxLists = maxNumOfLists;     // Access static field in outer class
        int maxNodes = max;               // Access instance field in member class

//      messageInListPool();    // (6) Not OK. Call instance method in outer class
        messageInLinkedList();  // (7) Call static method in outer class
      }

      public static void main(String[] args) {
        int maxLists = maxNumOfLists;    // (8) Access static field in outer class
//      int maxNodes = max;   // (9) Not OK. Access instance field in member class
        messageInLinkedList();// (10) Call static method in outer class
      }
    }  // Node
  }  // MyLinkedList
} // ListPool