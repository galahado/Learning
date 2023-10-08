package oop.hiding;

import org.junit.jupiter.api.Test;

public class HidingFieldTest {

    @Test
    void test() {
        System.out.println(SuperclassWithStaticField.field);
        SubclassHidingFields subclassHidingFields = new SubclassHidingFields();
        System.out.println(subclassHidingFields.field);
    }
}

class SuperclassWithStaticField {
    public static String field = "field";
}

class SubclassHidingFields extends SuperclassWithStaticField {
    protected String field = "fieldInSubclass";
}