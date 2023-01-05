package record.basics;
import java.time.Year;
import java.util.Objects;

/** A class that represents a CD. */
public class CD_v1 {

  // Instance fields:
  private final String artist;      // Name of the artist.
  private final String title;       // Title of the CD.
  private final int    noOfTracks;  // Number of tracks on the CD.
  private final Year   year;        // Year the CD was released.
  private final Genre  genre;       // Music genre of the CD.

  // Non-zero argument constructor:
  public CD_v1(String artist, String title, int noOfTracks,
               Year year, Genre genre) {
    this.artist     = artist;
    this.title      = title;
    this.noOfTracks = noOfTracks;
    this.year       = year;
    this.genre      = genre;
  }

  // Get methods:
  public String getArtist()     { return this.artist; }
  public String getTitle()      { return this.title; }
  public int    getNoOfTracks() { return this.noOfTracks; }
  public Year   getYear()       { return this.year; }
  public Genre  getGenre()      { return this.genre; }

  // Overridden methods from the Object class:
  @Override public String toString() {
    return String.format("<%s, \"%s\", %d, %s, %s>",
        this.artist, this.title, this.noOfTracks, this.year, this.genre);
  }

  @Override public boolean equals(Object obj) {
    return (this == obj)
        || (obj instanceof CD_v1 other
            && this.artist.equals(other.artist)
            && this.title.equals(other.title)
            && this.noOfTracks == other.noOfTracks
            && this.year == other.year
            && this.genre == other.genre);
  }

  @Override public int hashCode() {
    return Objects.hash(this.artist, this.title, this.noOfTracks,
                        this.year, this.genre);
  }
}