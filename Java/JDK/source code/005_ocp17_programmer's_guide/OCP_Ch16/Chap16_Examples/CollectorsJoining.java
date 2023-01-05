import java.util.stream.Collectors;

public final class CollectorsJoining {
  public static void main(String[] args) {
    String concatTitles1 = CD.cdList.stream()
        .map(CD::title)
        .collect(Collectors.joining());                 // (1)
    //Java JiveJava JamLambda DancingKeep on ErasingHot Generics
    System.out.println(concatTitles1);

    String concatTitles2 = CD.cdList.stream()
        .map(CD::title)
        .collect(Collectors.joining(", "));             // (2)
    //Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics
    System.out.println(concatTitles2);

    String concatTitles3 = CD.cdList.stream()
        .map(CD::title)
        .collect(Collectors.joining(", ", "[", "]"));   // (3)
    //[Java Jive, Java Jam, Lambda Dancing, Keep on Erasing, Hot Generics]
    System.out.println(concatTitles3);
  }
}