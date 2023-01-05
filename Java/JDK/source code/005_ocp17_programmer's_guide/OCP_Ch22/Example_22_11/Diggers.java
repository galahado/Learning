
public class Diggers {
  public static void main(String[] args) {
    Hole hole = new Hole();                                          // (4)
    for (int i = 0; i < 5; i++) {                                    // (5)
      new Thread(() -> hole.dig()).start();
    }
  }
}