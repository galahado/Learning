import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.LongStream;

class Accumulator<T> {

  T result;

  Accumulator(T initVal) {
    result = initVal;
  }

  public void func(BinaryOperator<T> op, T t) {
    result = op.apply(result, t);
    System.out.println(">" + result);
  }
}

public class RaceConditions {
  private static Accumulator<Long> accum1 = new Accumulator<>(0L);
  private static Accumulator<Long> accum2 = new Accumulator<>(0L);

  public static void main(String[] args) {
    RaceConditions.perfConsumer(RaceConditions::seqOp, 100L);
    RaceConditions.perfConsumer(RaceConditions::paraOp, 100L);
    System.out.printf("Result: %s%n", accum1.result);
    System.out.printf("Result: %s%n", accum2.result);
  }

  public static void seqOp(long n) {
    LongStream.rangeClosed(1, n)
        .forEach(i -> accum1.func((v1, v2) -> v1 + v2, i));
  }

  public static void paraOp(long n) {
    LongStream.rangeClosed(1, n).parallel()
        .forEach(i -> accum2.func((v1, v2) -> v1 + v2, i));
  }

  public static <T> void perfConsumer(Consumer<T> func, T t) {
    double start = System.nanoTime();
    func.accept(t);
    double duration = (System.nanoTime() - start) / 1_000_000;
    System.out.printf("Time: %.5f ms.%n", duration);
  }
}