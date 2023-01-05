package executors;
import java.util.concurrent.Executor;

class SimpleExecutor implements Executor {
  @Override
  public void execute(Runnable task) {
    task.run();                                   // (2a) Synchronous call
//  new Thread(task).start();                     // (2b) Asynchronous call
  }
}