import java.util.ArrayList;
import java.util.List;

public class SuppressWarningsTest {

 //  @SuppressWarnings({"unchecked", "deprecation", "removal"})
  public static void main(String[] args) {

    List<String> ref1 = new ArrayList<>(); // (1)
    ref1.add("A");
    String x1 = ref1.get(0);               // (2)
    List ref2 = ref1;                      // (3)
    ref2.add(Integer.valueOf(42));         // (4)
    Object x2 = ref2.get(1);               // (5)
    String x3 = ref1.get(1);               // (6)
    List<String> ref3 = ref2;              // (7)
  }
}