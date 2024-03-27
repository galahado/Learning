package reflect.bean;

public class Student {
    public int age;

    private static String name;

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "age = " + age +
                ", name = " + name +
                '}';
    }
}
