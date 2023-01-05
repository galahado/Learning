package safe;
import java.util.OptionalInt;
import java.util.concurrent.locks.*;

public class ReentrantRWLockCounter implements ICounter {

  private ReadWriteLock rwl = new ReentrantReadWriteLock();           // (1)
  private Lock readLock = rwl.readLock();                             // (2)
  private Lock writeLock = rwl.writeLock();                           // (3)
  private int counter = 0;

  @Override
  public int getValue() {                                             // (4)
    readLock.lock();
    try {
//      System.out.println(Thread.currentThread().getName() + ": " + counter);
      return counter;
    } finally { readLock.unlock(); }
  }

  @Override
  public void increment() {                                           // (5)
    writeLock.lock();
    try {
      counter++;
    } finally { writeLock.unlock(); }
  }

  public int incrementAndGet() {                                      // (6)
    writeLock.lock();                 // Acquire write lock.
    try {
      return ++counter;                                               // (7)
//    ++counter;                      // Increment.                   // (8)
//    return getValue();              // Get the new value.           // (9)
    } finally { writeLock.unlock(); } // Release write lock.
  }

  public int getAndIncrement() {                                      // (10)
    writeLock.lock();                 // Acquire write lock.
    try {
      return counter++;               // Get and increment.           // (11)
    } finally { writeLock.unlock(); } // Release write lock.
  }

  public boolean incrIfPossible() {                                   // (12)
    if (writeLock.tryLock()) {          // Attempts to acquire the write lock.
      try {                             // Write lock acquired.
        counter++;
        return true;
      } finally { writeLock.unlock(); } // Write lock released.
    } else {                            // Write lock not acquired.
      return false;
    }
  }

  public OptionalInt getIfPossible() {                                // (13)
    if (readLock.tryLock()) {           // Attempts to acquire the read lock.
      try { return OptionalInt.of(counter); }
      finally { readLock.unlock(); }    // Read lock released.
    } else {                            // Read lock not acquired.
      return OptionalInt.empty();
    }
  }
}