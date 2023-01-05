import java.util.function.Predicate;

@Tag public class Symphony<@Tag M> {         // (1)

   private @Tag String  description;         // (2)

   @Tag public  void play(@Tag int i) {      // (3)
    @Tag int volume;                         // (4) Compile-time error
  }

  public @Tag int doIt(@Tag M element) {
     String str = new @Tag String("");
     return (@Tag int) 1;
  }

  @Tag Predicate<String> predicate = (@Tag String s) -> s.length() < 10;

}

@Tag class Box<@Tag T> {

}