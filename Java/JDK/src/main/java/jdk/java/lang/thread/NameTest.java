package jdk.java.lang.thread;

public class NameTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("thread 1"));
        Thread t2 = new Thread(() -> System.out.println("thread 2"));

        t1.setName("This is Thread 1");
        t2.setName("This is Thread 2");

        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }
}
