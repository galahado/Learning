import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOperations {
  public static void main(String[] args) {
    Deque<String> deque = new ArrayDeque<String>();
    System.out.println("After creating the deque: " + deque);

    // Insert elements:
    deque.offerFirst("A (H)");               // Insert at the head
    System.out.println("After inserting at the head: " + deque);
    deque.offerLast("B (T)");                // Insert at the tail
    System.out.println("After inserting at the tail: " + deque);
    deque.push("C (H)");                     // Insert at the head
    System.out.println("After inserting at the head: " + deque);
    deque.addFirst("D (H)");                 // Insert at the head
    System.out.println("After inserting at the head: " + deque);
    deque.addLast("E (T)");                  // Insert at the tail
    System.out.println("After inserting at the tail: " + deque);

    // Examine element:
    System.out.println("Examine at the head: " + deque.getFirst());
    System.out.println("Examine at the tail: " + deque.getLast());
    System.out.println("Examine at the head: " + deque.peekFirst());
    System.out.println("Examine at the tail: " + deque.peekLast());

    // Remove elements:
    deque.removeFirst();                     // Remove from the head
    System.out.println("After removing from the head: " + deque);
    deque.removeLast();                      // Remove from the tail
    System.out.println("After removing from the tail: " + deque);
    deque.pollFirst();                       // Remove from the head
    System.out.println("After removing from the head: " + deque);
    deque.pollLast();                        // Remove from the tail
    System.out.println("After removing from the tail: " + deque);
    deque.pop();                             // Remove from the head
    System.out.println("After removing from the head: " + deque);
  }
}