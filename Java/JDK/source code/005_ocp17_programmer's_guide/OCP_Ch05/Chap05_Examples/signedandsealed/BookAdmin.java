package signedandsealed;

public class BookAdmin {
  public static void main(String[] args) {
    // Create some books:                                                  // (1)
    PrintedBook pBook = new PrintedBook("888-222", 340);
    Ebook eBook = new Ebook("999-777", "epub");
    Audiobook aBook = new Audiobook("333-555", "Fry", 300.0);

    // Create a book array:                                                // (2)
    Book[] books = {pBook, eBook, aBook};

    // Process the books:                                                  // (3)
    for (Book book : books) {
      if (book instanceof PrintedBook pb) {                                // (4)
        System.out.printf("Printed book: %s, %d%n",
                           pb.getIsbn(), pb.getPageCount());
      } else if (book instanceof Ebook eb) {
        System.out.printf("Ebook: %s, %s%n", eb.getIsbn(), eb.getFormat());
      } else if (book instanceof Audiobook ab) {
        System.out.printf("Audiobook: %s, %s, %.1f%n",
                           ab.getIsbn(), ab.getNarrator(), ab.getLength());
      }
    }
  }
}