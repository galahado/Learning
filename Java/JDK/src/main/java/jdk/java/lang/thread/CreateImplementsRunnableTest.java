package jdk.java.lang.thread;

public class CreateImplementsRunnableTest {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Sub Thread -> " + i);
            }
        });

        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread -> " + i);
        }
    }
}
