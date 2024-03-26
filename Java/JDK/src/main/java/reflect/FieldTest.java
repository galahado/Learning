package reflect;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

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
}
