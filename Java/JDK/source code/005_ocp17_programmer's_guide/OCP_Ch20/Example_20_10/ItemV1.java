import java.io.Serializable;

// New version of the Item class.
public class ItemV1 implements Serializable {                          // (2)
//static final long serialVersionUID = 1000L;                          // (2a)
//static final long serialVersionUID = 1001L;                          // (2b)

  private double price;
  private double weight;                                   // Additional field

  public ItemV1(double price, double weigth) {
    this.price = price;
    this.weight = weigth;
  }

  @Override
  public String toString() {
    return String.format("Price: %.2f, Weight: %.2f", this.price, this.weight);
  }
}