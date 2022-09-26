package jdk.lambda;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class BuiltinTest {

    @Test
    void supplierTest() {
        Supplier<LocalDate> supplier1 = LocalDate::now;
        Supplier<LocalDate> supplier2 = () -> LocalDate.now();

        var s1 = supplier1.get();
        var s2 = supplier2.get();

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    void supplierTest2() {
        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();

        var v1 = s1.get();
        var v2 = s2.get();
    }

    @Test
    void consumerTest() {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = s -> System.out.println(s);

        c1.accept("Annie");
        c2.accept("Annie");
    }

    @Test
    void biConsumerTest() {
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> bc1 = map::put;
        BiConsumer<String, Integer> bc2 = (s, i) -> map.put(s, i);

        bc1.accept("chicken", 1);
        bc2.accept("chick", 2);

        System.out.println(map);
    }

    @Test
    void predicateTest() {
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = s -> s.isEmpty();

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));
    }

    @Test
    void biPredicate() {
        BiPredicate<String, String> bp1 = String::startsWith;
        BiPredicate<String, String> bp2 = (s, t) -> s.startsWith(t);

        System.out.println(bp1.test("Chicken", "Chick"));
        System.out.println(bp2.test("Chicken", "Chick"));
    }

    @Test
    void function() {
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = s -> s.length();

        System.out.println(f1.apply("cluck"));
        System.out.println(f2.apply("cluck"));
    }

    @Test
    void biFunction() {
        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (s, t) -> s.concat(t);

        System.out.println(bf1.apply("baby ", "chick")); // baby chick
        System.out.println(bf2.apply("baby ", "chick")); // baby chick
    }

    @Test
    void unary() {
        UnaryOperator<String> uo1 = String::toUpperCase;
        UnaryOperator<String> uo2 = s -> s.toUpperCase();

        System.out.println(uo1.apply("chirp")); // CHIRP
        System.out.println(uo2.apply("chirp")); // CHIRP
    }

    @Test
    void binaryOperator() {
        BinaryOperator<String> bo1 = String::concat;
        BinaryOperator<String> bo2 = (s, t) -> s.concat(t);

        System.out.println(bo1.apply("baby ", "chick")); // baby chick
        System.out.println(bo2.apply("baby ", "chick")); // baby chick
    }
}
