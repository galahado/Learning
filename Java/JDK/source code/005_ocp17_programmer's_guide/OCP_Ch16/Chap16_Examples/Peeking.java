import java.util.List;

public final class Peeking {
  public static void main(String[] args) {

    List<CD> cdList = CD.cdList;
    List<CD> jazzCDs = cdList.stream()           // (1)
        .peek(cd -> System.out.println("Before filter: " + cd.title()))
        .filter(CD::isJazz)                      // (2)
        .peek(cd -> System.out.println("After filter: " + cd.title()))
        .toList();
    System.out.println(jazzCDs);
  }
}