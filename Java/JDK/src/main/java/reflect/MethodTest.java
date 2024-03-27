package reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MethodTest {
    @Test
    void getModifiers() throws Exception {
        Class<?> clazz = Class.forName("reflect.bean.Person");
        // get all methods from current class
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", modifier: " + method.getModifiers());
        }
    }


    @Test
    void getReturnType() throws Exception {
        Class<?> clazz = Class.forName("reflect.bean.Person");
        // get all methods from current class
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", return type: " + method.getReturnType());

            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }
    }


    @Test
    void getParameterTypes() throws Exception {
        Class<?> clazz = Class.forName("reflect.bean.Person");
        Method method = clazz.getDeclaredMethod("m1", String.class, int.class, double.class);
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }
    }
}
