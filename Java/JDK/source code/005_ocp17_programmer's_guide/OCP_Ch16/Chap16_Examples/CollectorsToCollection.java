import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class CollectorsToCollection {
  public static void main(String[] args) {

    {
      // Collection
      ArrayList<String> cdTitles1 = CD.cdList.stream()
          .map(CD::title)
          .collect(Collectors.toCollection(ArrayList::new));
      System.out.println("ArrayList:" + cdTitles1);
    }

    {
      //List
      List<String> cdTitles3 = CD.cdList.stream()
          .map(CD::title)
          .toList();
      System.out.println("List:" + cdTitles3);
    }

    {
      // Set
      Set<String> cdTitles2 = CD.cdList.stream()
          .map(CD::title)
          .collect(Collectors.toSet());
      System.out.println("Set:" + cdTitles2);
    }



    {
      // BETTER WAYS OF DOING THIS: list.toArray().
      List<CD> cdList = Arrays.stream(CD.cdArray)   // Array to List
          .toList();
      System.out.println("List:" + cdList);
    }

  }
}