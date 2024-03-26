package reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class ReflectionSpeedTest {

    @Test
    void test1() throws Exception{

        // tradition method
        long start1 = System.currentTimeMillis();
        Cat cat = new Cat();
        for (int i = 0; i < 100000000; i++){
            cat.doNothing();
        }
        long end1 = System.currentTimeMillis();


        // using reflection
        Class<?> aClass = Class.forName("reflect.Cat");
        Method method = aClass.getMethod("doNothing");
        Object o = aClass.getDeclaredConstructor().newInstance();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++){
            method.invoke(o);
        }
        long end2= System.currentTimeMillis();

        // using reflection but without security check
        long start3 = System.currentTimeMillis();
        method.setAccessible(true);
        for (int i = 0; i < 100000000; i++){
            method.invoke(o);
        }
        long end3= System.currentTimeMillis();

        System.out.println("traditional method: " + (end1 - start1));
        System.out.println("reflection method: " + (end2 - start2));
        System.out.println("reflection without security check: " + (end3 - start3));
    }
}
