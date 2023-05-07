package jdk.java.lang.string;

import org.junit.jupiter.api.Test;

public class IndexOfTest {

    @Test
    void findingIndex() {
        var name = "animals";
        System.out.println(name.indexOf('a'));       // 0
        System.out.println(name.indexOf("al"));      // 4
        System.out.println(name.indexOf('a', 4));    // 4

        // returns -1 if it cannot find an index
        System.out.println(name.indexOf("al", 5));   // -1
    }
}
