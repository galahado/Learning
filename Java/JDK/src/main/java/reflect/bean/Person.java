package reflect.bean;

public class Person implements Cloneable, Comparable<Person> {
    public String name;

    protected int age;

    String job;

    private double salary;

    public Person() {

    }

    public Person(String name) {

    }

    private Person(String name, int age) {

    }

    public void m1(){

    }

    protected void m2() {

    }

    void m3(){

    }

    private void m4() {

    }

    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
