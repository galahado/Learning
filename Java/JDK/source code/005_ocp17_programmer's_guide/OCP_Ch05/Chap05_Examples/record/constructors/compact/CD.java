package record.constructors.compact;
import java.time.Year;

/** A record class that represents a CD. */
public record CD(String artist, String title, int noOfTracks,             // (1)
                 Year year, Genre genre) {

  // Compact canonical record constructor                                    (2)
  public CD {
    // Sanitize the values passed to the constructor:                        (3)
    artist = artist.strip();
    title = title.strip();
    noOfTracks = noOfTracks < 0 ? 0 : noOfTracks;
    year =  year.compareTo(Year.of(2022)) > 0? Year.of(2022) : year;
    genre = genre == null ? Genre.OTHER : genre;

    // Cannot explicitly assign to component fields:                         (4)
    // this.artist = artist;                    // Compile-time error!
  }

  // A non-canonical record constructor                                      (5)
  public CD() {
    this(" Anonymous  ", "  No title  ", 0, Year.of(2022), Genre.OTHER);  // (6)
  }
}