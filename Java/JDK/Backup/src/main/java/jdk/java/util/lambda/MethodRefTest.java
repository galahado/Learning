package jdk.java.util.lambda;

import org.junit.jupiter.api.Test;

public class MethodRefTest {

    @Test
    void staticMethod() {

        interface Converter {
            long round(double num);
        }

        Converter methodRef = Math::round;
        Converter lambda = s -> Math.round(s);

        System.out.println(methodRef.round(100.1));
    }

    @Test
    void instanceMethod() {

        interface StringStart {
            boolean beginningCheck(String prefix);
        }

        var str = "Zoo";
        StringStart methodRef = str::startsWith;
        StringStart lambda = s -> str.startsWith(s);
    }

    @Test
    void parameterToBeDetermined() {

        interface StringParameterChecker {
            boolean check(String text);
        }

        StringParameterChecker methodRef = String::isEmpty;
        StringParameterChecker lambda = s -> s.isEmpty();

        System.out.println(methodRef.check("zoo"));
    }

    @Test
    void twoParameters() {

        interface StringTwoParametersChecker {
            boolean check(String text, String prefix);
        }

        StringTwoParametersChecker methodRef = String::startsWith;
        StringTwoParametersChecker lambda = (s, t) -> s.startsWith(t);

        System.out.println(methodRef.check("Zoo", "A"));
    }

    @Test
    void constructor() {

        interface EmptyStringCreator {
            String create();
        }

        EmptyStringCreator methodRef = String::new;
        EmptyStringCreator lambda = () -> new String();

        System.out.println(methodRef.create());
    }
}
