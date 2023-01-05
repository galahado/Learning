import java.util.List;

public final class CollectingToList {
  public static void main(String[] args) {

    List<String> titles = CD.cdList.stream().map(CD::title).toList();
    //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
    titles.add("Java Jingles");
    System.out.println(titles);
  }
}