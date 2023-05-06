package jdk.java.lang.thread.safe.without;

public class WithdrawTest {
    public static void main(String[] args) {
        Account account =  new Account();
        account.setBalance(10000);
        account.setAccountNumber("A-001");

        WithdrawThread t1 = new WithdrawThread(account);
        t1.setName("t1");

        WithdrawThread t2 = new WithdrawThread(account);
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}


