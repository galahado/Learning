package jdk.java.lang.thread.safe.syncblock;

public class Account {

    private String accountNumber;

    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amout) {
        // using the object that has data to share between thread
        synchronized (this) {
            double before = this.getBalance();
            double after = before - amout;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }
}
