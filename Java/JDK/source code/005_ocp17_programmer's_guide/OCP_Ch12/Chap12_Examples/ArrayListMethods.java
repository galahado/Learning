import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ArrayListMethods {

  public static void main(String[] args) {

    String[] wordArray = { "level", "Ada", "kayak", "Bob", "Rotator", "Bob" };

    out.println("(1) Create an empty list of strings:");
    List<String> strList = new ArrayList<>();
    printListWithIndex(strList);

    out.println("\n(2) Add elements to list:");
    for (String str : wordArray) {
      strList.add(str);
      printListWithIndex(strList);
    }
    out.println("Insert an element at index 2 in the list:");
    strList.add(2, "Java");
    printListWithIndex(strList);

    out.println("\n(3) Replace the element at index 1:");
    String oldElement = strList.set(1, "Naan");
    out.println("Element that was replaced: " + oldElement);
    printListWithIndex(strList);

    out.println("\n(4) Remove the element at index 0:");
    out.println("Element removed: " + strList.remove(0));
    printListWithIndex(strList);

    out.println("\n(5) Remove the first occurrence of \"Java\":");
    out.println("Element removed: " + strList.remove("Java"));
    printListWithIndex(strList);

    out.println("\n(6) Determine the size of the list:");
    out.println("The size of the list is " + strList.size());

    out.println("\n(7) Determine if the list is empty:");
    boolean result = strList.isEmpty();
    out.println("The list " + (result ? "is" : "is not") + " empty.");

    out.println("\n(8) Get the element at specific index:");
    out.println("First element: " + strList.get(0));
    out.println("Last element: " + strList.get(strList.size() - 1));

    out.println("\n(9) Compare two lists:");
    List<String> strList2 = new ArrayList<>(strList);
    boolean trueOrFalse = strList.equals(strList2);
    out.println("The lists strList and strList2 are"
        + (trueOrFalse ? "" : " not") + " equal.");
    strList2.add(null);
    printListWithIndex(strList2);
    trueOrFalse = strList.equals(strList2);
    out.println("The lists strList and strList2 are"
        + (trueOrFalse ? "" : " not") + " equal.");

    out.println("\n(10) Sublists as views:");
    out.println("Underlying list: " + strList); // [Naan, kayak, Bob, Rotator, Bob]
    List<String> strList3 = strList.subList(1, 4);
    out.println("Sublist before remove: " + strList3);    // [kayak, Bob, Rotator]
    out.println("Remove: " + strList3.get(0));  // "kayak"
    strList3.remove(0);                         // Remove element at index 0
    out.println("Sublist after remove: " + strList3);     // [Bob, Rotator]
    out.println("Underlying list: " + strList); // [Naan, Bob, Rotator, Bob]

    out.println("\n(11) Membership test:");
    boolean found = strList.contains("Naan");
    String msg = found ? "contains" : "does not contain";
    out.println("The list " + msg + " the string \"Naan\".");

    out.println("\n(12) Find the index of an element:");
    int pos = strList.indexOf("Bob");
    out.println("The index of string \"Bob\" is: " + pos);
    pos = strList.indexOf("BOB");
    out.println("The index of string \"BOB\" is: " + pos);
    pos = strList.lastIndexOf("Bob");
    out.println("The last index of string \"Bob\" is: " + pos);
    printListWithIndex(strList);

    out.println("\n(13) Iterating over the list using the for(;;) loop:");
    for (int i = 0; i < strList.size(); i++) {
      out.print(i + ":" + strList.get(i) + " ");
    }
    out.println();

    out.println("\n(14) Iterating over the list using the for(:) loop:");
    for (String str : strList) {
      out.print(str +  " ");
      // strList.remove(str);        // Throws ConcurrentModificationException.
    }
    out.println();

    out.println("\n(15) Convert list to array:");
    Object[] objArray = strList.toArray();
    out.println("Object[] length: " + objArray.length);
    out.print("Length of each string in the Object array: ");
    for (Object obj : objArray) {
      String str = (String) obj; // Cast required.
      out.print(str.length() + " ");
    }
    out.println();
    String[] strArray = strList.toArray(new String[0]);
    out.println("String[] length: " + strArray.length);
    out.print("Length of each string in the String array: ");
    for (String str : strArray) {
      out.print(str.length() + " ");
    }
  }

  /**
   * Print the elements of a list, together with their index:
   * [0:value0, 1:value1, ...]
   * @param list   List to print with index
   */
  public static <E> void printListWithIndex(List<E> list) {            // (16)
    List<String> newList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      newList.add(i + ":" + list.get(i));
    }
    out.println(newList);
  }
}