import java.util.List;
import java.util.stream.Collectors;

public final class CollectorsToList {
  public static void main(String[] args) {

    List<String> titles = CD.cdList.stream()
        .map(CD::title).collect(Collectors.toList());
    // [Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
    titles.add("Java Jingles");        // OK
    System.out.println("Titles: " + titles);

  }
}