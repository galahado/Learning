package jdk.java.lang.thread.safe.syncmethod;

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

    // the lock of synchronized methods is "this"
    // 用synchronized方法可能扩大同步范围，没有synchronized代码块灵活
    // static synchronized方法的锁是类锁，每个类只有一个
    public synchronized void withdraw(double amount) {
        double before = this.getBalance();
        double after = before - amount;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setBalance(after);
    }
}
