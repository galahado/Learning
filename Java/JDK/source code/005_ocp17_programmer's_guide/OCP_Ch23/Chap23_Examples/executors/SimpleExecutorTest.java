package executors;

public class SimpleExecutorTest {
  public static void main(String[] args) {
    SimpleExecutor executor = new SimpleExecutor();
    Runnable task = () -> {;};
    executor.execute(task);
    System.out.println("main done.");
  }
}