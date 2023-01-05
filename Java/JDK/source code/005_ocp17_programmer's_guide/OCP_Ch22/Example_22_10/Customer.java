
public class Customer {                                                  // (1)
  private boolean paymentMade = false;                                   // (2)

  public void makePaymentTo(Seller seller) {                             // (3)
    while (!seller.hasShipped()) {
      System.out.println("Customer: waiting for shipment from seller");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("Customer: payment made");
    this.paymentMade = true;                                             // (4)
  }

  public boolean hasPaid() {
    return this.paymentMade;
  }
}