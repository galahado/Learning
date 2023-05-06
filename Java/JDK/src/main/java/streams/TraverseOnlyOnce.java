package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TraverseOnlyOnce {

    @Test
    void traverseOnceTest() {
        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        // each stream can only be visited once
//        s.forEach(System.out::println);
    }
}
