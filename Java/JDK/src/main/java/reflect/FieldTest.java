package reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Properties;

import reflect.bean.Cat;

public class FieldTest {

    @Test
    void test1() throws Exception {

        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/re.properties"));
        String path = properties.getProperty("classPath");

        Class<?> clazz = Class.forName(path);

        Cat c = (Cat) clazz.getDeclaredConstructor().newInstance();
        c.age = 8;

        Field name = clazz.getDeclaredField("age");
        System.out.println(name.get(c));
    }

    @Test
    void getModifiers() throws Exception {
        Class<?> clazz = Class.forName("reflect.bean.Person");
        // get the public fields from only current class
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ", modifier: " + field.getModifiers());
        }
    }


    @Test
    void getType() throws Exception {
        Class<?> clazz = Class.forName("reflect.bean.Person");
        // get the public fields from only current class
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ", type: " + field.getType());
        }
    }


    @Test
    void set() throws Exception {
        Class<?> aClass = Class.forName("reflect.bean.Student");
        Object o = aClass.getConstructor().newInstance();

        // public field
        Field age = aClass.getField("age");
        age.set(o, 15);
        System.out.println(o);
        System.out.println(age.get(o));

        // private static field
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
//        name.set(o, "Chuanqi");
       // since name is static, we can set object as null
        name.set(null, "Chuanqi Zhang");
        System.out.println(o);
        System.out.println(name.get(o));
        System.out.println(name.get(null));
    }
}
