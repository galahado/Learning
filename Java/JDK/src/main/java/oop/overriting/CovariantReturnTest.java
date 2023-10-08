package oop.overriting;

import java.util.ArrayList;
import java.util.List;

public class CovariantReturnTest {

}

class SuperClassReturnList {
    List<String> test1() {
        return new ArrayList<>();
    }
}

class SubClassReturnArrayList extends SuperClassReturnList {
    @Override
    ArrayList<String> test1() {
        return new ArrayList<>();
    }
}

class SuperClassReturnDouble {
    double test() {
        return 0;
    }
}

class subClassReturnInt extends SuperClassReturnDouble {
    // will not work, covariant return only applies to reference type
//    @Override
//    int test() {
//        return 0;
//    }
}
