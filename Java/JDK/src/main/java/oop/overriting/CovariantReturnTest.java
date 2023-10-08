package oop.overriting;

import java.util.ArrayList;
import java.util.List;

public class CovariantReturnTest {

}

class superClass {
    List<String> test1() {
        return new ArrayList<>();
    }
}

class subClass extends superClass {
    @Override
    ArrayList<String> test1() {
        return new ArrayList<>();
    }
}

class superClass2 {
    double test() {
        return 0;
    }
}

class subClass2 extends superClass2 {
    // will not work, covariant return only applies to reference type
//    @Override
//    int test() {
//        return 0;
//    }
}
