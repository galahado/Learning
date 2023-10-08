package oop.overriting;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowExceptionTest {
}

class SuperClassThrowsIOException {
    void test() throws IOException {
    }
}

class SubClassThrowsIOException extends SuperClassThrowsIOException {
    @Override
    void test() throws IOException {
        System.out.println("sub class throws IOException");
    }
}

class SubClassThrowsFileNotFoundException extends SuperClassThrowsIOException {
    @Override
    void test() throws FileNotFoundException {
        System.out.println("sub class throws FileNotFoundException");
    }
}

class SubClassThrowsNothing extends SuperClassThrowsIOException {
    @Override
    void test() {
        System.out.println("sub class throws nothing");
    }
}


class SubClassThrowsSQLException extends SuperClassThrowsIOException {
    // Will not work, cannot throw any checked exception that is wider
    //    @Override
    //    void test() throws SQLException {
    //        System.out.println("sub class throws SQLException");
    //    }
}
