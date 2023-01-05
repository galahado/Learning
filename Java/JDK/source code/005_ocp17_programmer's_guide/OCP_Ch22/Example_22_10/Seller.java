
public class Seller {                                                    // (5)
  private boolean itemShipped = false;                                   // (6)

  public void shipTo(Customer customer) {                                // (7)
    while (!customer.hasPaid()) {
      System.out.println("Seller: waiting for payment from customer");
      try {
        Thread.sleep(500);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("Seller: item shipped");
    this.itemShipped = true;                                             // (8)
  }

  public boolean hasShipped() {
    return this.itemShipped;
  }
}