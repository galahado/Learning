package synced;
import java.util.stream.IntStream;

public class Client {                                                     // (9)
  public static void main(String[] args) {
    DoubleAct da = new DoubleAct();
    da.add("Laurel"); da.add("Hardy");                                    // (10)
    Runnable remover = () -> {                                            // (11)
      String name = da.removeFirst();                                     // (12)
      System.out.println(name);
    };
    IntStream.rangeClosed(1, 3).forEach(i -> new Thread(remover).start());// (13)
  }
}