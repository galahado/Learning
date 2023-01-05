import java.io.Serializable;

// Original version of the Item class.
public class Item implements Serializable {                            // (1)
//static final long serialVersionUID = 1000L;                          // (1a)

  private double price;

  public Item(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format("Price: %.2f%n", this.price);
  }
}