package jdk.java.lang.thread.safe.syncmethod;

public class WithdrawThread extends Thread {

    private Account account;

    public WithdrawThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

        double amount = 5000;

        account.withdraw(5000);

        System.out.println(Thread.currentThread().getName() + " withdraw completed! balance: " + this.account.getBalance());
    }
}
