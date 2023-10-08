package oop.invoking;

import org.junit.jupiter.api.Test;

public class InvokingTest {
    @Test
    void test() {
        SuperclassForInvokingTest sup = new SubclassForInvokingTest();
        System.out.println(sup.field);
        System.out.println(sup.field2);
        System.out.println(sup.method());
        System.out.println(sup.method2());
    }

}

class SuperclassForInvokingTest {
    public static String field = "Super Static Field";
    public String field2 = "Super Instance Field";

    public static String method() {
        return "Super Static Method";
    }

    public String method2() {
        return "Super Instance Method";
    }
}

class SubclassForInvokingTest extends SuperclassForInvokingTest {
    public static String field = "Sub Static Field";
    public String field2 = "Sub Instance Field";

    public static String method() {
        return "Sub Static Method";
    }

    @Override
    public String method2() {
        return "Sub Instance Method";
    }
}
