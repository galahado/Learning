// File: MyBiLinkedList.java
package smc;

public class MyBiLinkedList implements ListPool.IBiLink {       // (12)

  public static void main(String[] args) {
    ListPool.MyLinkedList.BiNode.printSimpleName();             // (13)
    ListPool.MyLinkedList.BiNode node1
             = new ListPool.MyLinkedList.BiNode();              // (14)
    node1.printName();                                          // (15)

//  ListPool.MyLinkedList.ILink ref;                 // (16) Compile-time error!
  }
}