import static java.lang.System.out;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class TerminalAction {
  public static void main(String[] args) {
    Consumer<String> printStr = str -> out.print(str + "|");

    out.println("(1a) Ordered Sequential Stream: forEach()");
    CD.cdList.stream().map(CD::title).forEach(printStr);            // (1a)
    //Java Jive|Java Jam|Lambda Dancing|Keep on Erasing|Hot Generics|
    out.println();

    out.println("(1b) Ordered Parallel Stream: forEach()");
    CD.cdList.stream().parallel().map(CD::title).forEach(printStr); // (1b)
    //Lambda Dancing|Hot Generics|Keep on Erasing|Java Jam|Java Jive|
    out.println();

    out.println("(2a) Ordered Sequential Stream: forEachOrdered()");
    CD.cdList.stream().map(CD::title).forEachOrdered(printStr);     // (2a)
    //Java Jive|Java Jam|Lambda Dancing|Keep on Erasing|Hot Generics|
    out.println();

    out.println("(2b) Ordered Parallel stream: forEachOrdered()");
    CD.cdList.stream().parallel().map(CD::title)
                                 .forEachOrdered(printStr);// (2b)
    //Java Jive|Java Jam|Lambda Dancing|Keep on Erasing|Hot Generics|
    out.println();

    IntConsumer printInt = n -> out.print(n + "|");

    IntStream.of(2018, 2019, 2020, 2021, 2022).forEach(printInt);        // (3a)
    //2018|2019|2020|2021|2022|

    IntStream.of(2018, 2019, 2020, 2021, 2022).parallel()
                                              .forEach(printInt);        // (3b)
    //2020|2019|2018|2021|2022|
  }
}