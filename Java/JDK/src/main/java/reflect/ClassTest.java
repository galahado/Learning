package reflect;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ClassTest {

    /**
     * get values from properties files and create object from the values
     */
    @Test
    void test() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/re.properties"));
        String path = properties.getProperty("classPath");
        String methodName = properties.getProperty("methodName");
        System.out.println(path);
        System.out.println(methodName);

        Class<?> clazz = Class.forName(path);
        Object o = clazz.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());

        Method method = clazz.getMethod(methodName);
        method.invoke(o);
    }

    @Test
    void getNames() throws Exception {
        Class<?> clazz = Class.forName("reflect.Person");
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
    }


    @Test
    void getFields() throws Exception {
        Class<?> clazz = Class.forName("reflect.Man");
        // get the public fields from current class and the superclass
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    void getAllFields() throws Exception {
        Class<?> clazz = Class.forName("reflect.Man");
        // get the public fields from only current class
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    void getMethods() throws Exception {
        Class<?> clazz = Class.forName("reflect.Man");
        // get all the public methods from current class and the ones inherited
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());

        }
    }

    @Test
    void getDeclaredMethods() throws Exception {
        Class<?> clazz = Class.forName("reflect.Person");
        // get all methods from current class
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());

        }
    }

    @Test
    void getConstructors() throws Exception {
        Class<?> clazz = Class.forName("reflect.Man");
        // get all the public methods from current class and the ones inherited
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
    }


    @Test
    void getDeclaredConstructors() throws Exception {
        Class<?> clazz = Class.forName("reflect.Person");
        // get all the public methods from current class and the ones inherited
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
    }

    @Test
    void getPackage() throws Exception {
        Class<?> aClass = Class.forName("reflect.Person");
        System.out.println(aClass.getPackage().getName());
        System.out.println(aClass.getPackageName());
    }

    @Test
    void getSuperClass() throws Exception {
        Class<?> aClass = Class.forName("reflect.Man");
        System.out.println(aClass.getSuperclass().getName());
    }

    @Test
    void getInterfaces() throws Exception {
        Class<?> aClass = Class.forName("reflect.Person");
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> c : interfaces) {
            System.out.println(c.getName());
        }
    }

    @Test
    void getAnnotations() throws Exception {
        Class<?> aClass = Class.forName("reflect.Man");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
