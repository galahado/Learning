class MessageDisplay {
  private String message;

  public synchronized void displayMessage() {
    String threadName = Thread.currentThread().getName();
    while (this.message == null) {                           // No message?
      try {
        wait();                                              // (1)
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(threadName + ": " + this.message);    // Display message.
    this.message = null;                                     // Remove message.
    notifyAll();                                             // (2)
  }

  public synchronized void setMessage(String message) {
    String threadName = Thread.currentThread().getName();
    while (this.message != null) {                           // Message present?
      try {
        wait();                                              // (3)
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.message = message;                                  // Set new message.
    System.out.println(threadName + ": Message set is " + this.message);
    notifyAll();                                             // (4)
  }
}