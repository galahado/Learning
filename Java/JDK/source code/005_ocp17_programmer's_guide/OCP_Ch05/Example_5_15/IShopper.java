/** Interface with private methods. */
public interface IShopper {

  // Abstract method:
  double getItemPrice();                               // (1)

  // Default method:
  default double getSalePrice(double price) {          // (2)
    var salePrice = (80.0/100.0)*price;
    System.out.println("Default method: " + "Sale price is " + salePrice);
    wrapUp();                    // (3) Calls the private instance method at (4)
    return salePrice;
  }

  // Private instance method:
  private void wrapUp() {                               // 4)
    System.out.println("Private method: " + "Wrapping up!");
  }

  // Static method:
  static void startSale() {                             // (5)
    System.out.println("Static method: " + "Amazing savings!");
    showSaleItems();             // (6) Calls the private static method at (7)
  }

  // Private static method:
  private static void showSaleItems() {                 // (7)
    System.out.println("Private static method: " + "Sorry. No items on sale!");
  }
}