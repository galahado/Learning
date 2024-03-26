package reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConstructorTest {

    /**
     * get a class's constructors
     */
    @Test
    void test1() throws Exception{

        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/re.properties"));
        String path = properties.getProperty("classPath");

        Class<?> clazz = Class.forName(path);

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        System.out.println(constructor);

        Constructor<?> constructor2 = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor2);
    }
}
