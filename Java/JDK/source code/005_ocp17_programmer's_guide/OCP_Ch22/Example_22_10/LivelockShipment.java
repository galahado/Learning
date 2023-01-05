
public class LivelockShipment {
  public static void main(String[] args) {
    Customer customer = new Customer();
    Seller seller = new Seller();

    new Thread(() -> customer.makePaymentTo(seller)).start();            // (9)
    new Thread(() -> seller.shipTo(customer)).start();                   // (10)
  }
}