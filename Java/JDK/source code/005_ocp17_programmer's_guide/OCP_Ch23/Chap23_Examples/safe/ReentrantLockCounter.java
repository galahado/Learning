package safe;
import java.util.concurrent.locks.*;

public class ReentrantLockCounter implements ICounter {               // (1)

  private Lock rl = new ReentrantLock();                              // (2)
  private int counter = 0;                                            // (3)

  @Override
  public int getValue() {                                             // (4)
    rl.lock();
    try {
      return counter;
    } finally { rl.unlock(); }
  }

  @Override
  public void increment() {                                           // (5)
    rl.lock();
    try {
      counter++;                                                      // (6)
      getValue();                                                     // (7)
    } finally { rl.unlock(); }
  }
}