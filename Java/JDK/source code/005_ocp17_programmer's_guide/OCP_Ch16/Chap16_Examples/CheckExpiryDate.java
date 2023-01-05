import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Item {
  private String itemName;
  private Optional<LocalDate> optExpiryDate;

  public Item(String itemName, LocalDate date) {
    this.itemName = itemName;
    this.optExpiryDate = Optional.ofNullable(date);
  }

  public static Item makeItem(String itemName, String dateStr) {
    Item item = new Item(itemName, null);
    item.optExpiryDate = createOptionalDate(dateStr);
    return item;
  }

  public String getItemName() { return itemName; }
  public Optional<LocalDate> getOptExpDate() {
    return optExpiryDate;
  }

  private static Optional<LocalDate> createOptionalDate(String dateStr) {
    Optional<LocalDate> optDate;
    try {
      optDate = Optional.of(LocalDate.parse(dateStr));
    } catch(NullPointerException | DateTimeParseException exception) {
      System.out.println("Logging date string (" + dateStr + "),"
                         + " no date registered.");
      optDate = Optional.empty();
    }
    return optDate;
  }

  public boolean isExpired() {
    return this.getOptExpDate()
               .filter(d -> d.isBefore(LocalDate.now()))
               .isPresent();
  }

  public String isExpiredToStr() {
    return this.getOptExpDate()
               .filter(d -> d.isBefore(LocalDate.now()))
               .map(d -> "expired")
               .orElse("not expired");
  }

  public String optDateToStr() {
    return this.getOptExpDate()
               .map(LocalDate::toString)
               .orElse("No expiry date");
  }

  @Override
  public String toString() {
    return itemName + "(" + optDateToStr() + ")";
  }
}

public class CheckExpiryDate {
  public static void main(String[] args) {
    Item item0 = new Item("item0", LocalDate.of(2018, 04, 28));
    Item item1 = new Item("item1", null);
    Item item2 = Item.makeItem("item2", "2017-11-10");
    Item item3 = Item.makeItem("item3", "2017-09-10");
    Item item4 = Item.makeItem("item4", "XXXX");
    Item item5 = Item.makeItem("item5", null);
    System.out.println();

    System.out.println(item0 + ": " + item0.isExpiredToStr());   // Not expired
    System.out.println(item1 + ": " + item1.isExpiredToStr());   // Not expired
    System.out.println(item2 + ": " + item2.isExpiredToStr());   // Not expired
    System.out.println(item3 + ": " + item3.isExpiredToStr());   // Expired
    System.out.println(item4 + ": " + item4.isExpiredToStr());   // Not expired
    System.out.println(item5 + ": " + item5.isExpiredToStr());   // Not expired
    System.out.println();

    System.out.println(item0 + ": " + item0.isExpired());   // Not expired
    System.out.println(item1 + ": " + item1.isExpired());   // Not expired
    System.out.println(item2 + ": " + item2.isExpired());   // Not expired
    System.out.println(item3 + ": " + item3.isExpired());   // Expired
    System.out.println(item4 + ": " + item4.isExpired());   // Not expired
    System.out.println(item5 + ": " + item5.isExpired());   // Not expired
    System.out.println();

    // Querying an Optional
    item0.getOptExpDate()
         .ifPresent(s -> System.out.println(item0.getItemName()
                             + " has an expiry date: " + s));

    // Operations on an Optional
    System.out.println(item1.getItemName() + " - " + item1.optDateToStr());
    System.out.println();

    System.out.println(item2.getItemName() + ": "
                     + (item2.isExpired() ? "Expired." : "Not expired."));
    System.out.println();

    // Using stream:
    List<Item> itemList = List.of(item0, item1, item2, item3, item4, item5);
    System.out.println(itemList);

    itemList.stream()
            .map(Item::getOptExpDate)
            .map(opts -> opts.map(LocalDate::toString).orElse("No expiry date"))
            .forEach(s -> System.out.println(s));
    System.out.println();

    itemList.stream()
         .forEach(d -> System.out.println(d.optDateToStr()));

    itemList.stream()
    .map(Item::getOptExpDate)
    .filter(Optional::isPresent)
    .map(optd -> optd.map(LocalDate::getYear))
    .mapToInt(Optional::get)
    .filter(y -> y == 2017)
    .forEach(y -> System.out.println("Expires in " + y));

    itemList.stream()
    .map(Item::getOptExpDate)
    .map(optd -> optd.map(LocalDate::getYear))
//  .filter(opty -> opty.isPresent() && opty.get() == 2017)
    .filter(opty -> opty.filter(y -> y == 2017).isPresent())
    .forEach(opty -> System.out.println("Expires in: " + opty.get()));

    // Include
    List<Item> expItem2017 = itemList.stream()
    .filter(i -> i.getOptExpDate().isPresent())   // See next idiom.
    .filter(i -> i.getOptExpDate().get().getYear() == 2017)
    .toList();
    System.out.println(expItem2017);

    // Include
    Predicate<Item> iPred2017 = item ->
        item.getOptExpDate().filter(d -> d.getYear() == 2017).isPresent();
    List<Item> expItem2017a =
        itemList.stream()
                .filter(iPred2017)
                .toList();
    System.out.println(expItem2017a);

    Map<String, Optional<LocalDate>> map = itemList.stream()
        .collect(Collectors.toMap(Item::getItemName, Item::getOptExpDate));
     System.out.println(map);
  }
}

