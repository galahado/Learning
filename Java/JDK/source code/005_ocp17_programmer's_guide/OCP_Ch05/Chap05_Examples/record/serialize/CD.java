package record.serialize;
import java.io.Serializable;
import java.time.Year;

/** A record class that represents a CD. */
public record CD(String artist, String title, int noOfTracks,          // (1)
    Year year, Genre genre) implements Serializable{

  // Some ready-made CDs:                                                 (2)
  public final static CD cd0
      = new CD("Jaav",      "Java Jive",       8, Year.of(2017), Genre.POP);
  public final static CD cd1
      = new CD("Jaav",      "Java Jam",        6, Year.of(2017), Genre.JAZZ);
  public final static CD cd2
      = new CD("Funkies",   "Lambda Dancing", 10, Year.of(2018), Genre.POP);
  public final static CD cd3
      = new CD("Genericos", "Keep on Erasing", 8, Year.of(2018), Genre.JAZZ);
  public final static CD cd4
      = new CD("Genericos", "Hot Generics",   10, Year.of(2018), Genre.JAZZ);

  // An array of CDs.
  public final static CD[] cdArray = {cd0, cd1, cd2, cd3, cd4};
}