package record.generics;
import java.time.Year;
/** A record class that represents a generic container. */
record Container<T>(T item) { /* Empty body */ }

public class ContainerAdmin {
  public static void main(String[] args) {
    // Some ready-made containers:
    Container<String> p0 = new Container<>("Hi");
    Container<Integer> p1 = new Container<>(Integer.valueOf(10));
    Container<Year> p2 = new Container<>(Year.of(2022));

    // An array of containers.
    Container<?>[] cArray = {p0, p1, p2};

    for(int i = 0; i < cArray.length; ++i) {
      Container<?> container = cArray[i];
      System.out.println(container);
      if (container.item() instanceof String str) {
        System.out.println(str.toUpperCase());
      }
    }
  }
}