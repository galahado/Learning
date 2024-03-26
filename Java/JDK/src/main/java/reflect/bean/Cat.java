package reflect.bean;

public class Cat {

    private String name = "Kitty";

    public int age = 10;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hi() {
        System.out.println("Hi, " + name);
    }

    public void doNothing(){

    }
}
