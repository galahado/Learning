import java.util.Arrays;
public class MusicMetaAP {
  public static void main(String[] args) {
    printMusicMetaAnnotaions(Composition.class);
  }

  public static void printMusicMetaAnnotaions(Class<?> classobj) {      // (1)
    MusicMeta[] mmas = classobj.getAnnotationsByType(MusicMeta.class);  // (2)
    if (mmas.length == 0) {
      System.out.printf("No %s annotation for %s%n", MusicMeta.class.getName(), classobj);
      return;
    }
    System.out.printf("%s annotation for %s%n", MusicMeta.class.getName(), classobj);
    MusicMeta mma = mmas[0];
    String value = mma.value();
    String[] countries = mma.countries();
    int maxDuration = mma.maxDuration();
    System.out.println("Policy: " + value);
    System.out.println("Countries: " + Arrays.toString(countries));
    System.out.println("Max duration: " + maxDuration);
  }
}