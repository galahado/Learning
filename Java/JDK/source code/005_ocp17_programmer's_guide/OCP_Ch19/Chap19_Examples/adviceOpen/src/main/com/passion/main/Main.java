// File path: src/main/com/passion/main/Main.java
package com.passion.main;
import java.lang.reflect.*;                             // Types for reflection

public class Main {
  public static void main(String... args) {                                // (1)
    try {
      // Get the runtime object representing the class.
      Class<?> cObj
          = Class.forName("com.passion.controller.AdviceController");      // (2)

      // Get the no-argument constructor of the class.
      Constructor<?> constructor = cObj.getDeclaredConstructor();          // (3)

      // Create an instance of the class.
      Object instance = constructor.newInstance();                         // (4)

      // Get all declared methods, including those that are non-public.
      Method[] methods = cObj.getDeclaredMethods();                        // (5)
      // Class has only one method.
      Method method = methods[0];                                          // (6)
      // Check if it is the right method.
      if (!method.getName().equals("showAdvice")) {                        // (7)
        System.out.printf("Method showAdvice() not found in %s.%n",
                          cObj.getName());
        return;
      }

      // Disable access control checks on the method as it is a private method.
      method.setAccessible(true);                                          // (8)

      // Invoke the method on the instance, passing any arguments.
      method.invoke(instance, 1);                                          // (9)
      method.invoke(instance, 2);                                          // (10)
      method.invoke(instance, 3);                                          // (11)
      method.invoke(instance, 0);                                          // (12)

    } catch (ClassNotFoundException | NoSuchMethodException |
             InstantiationException | IllegalAccessException |
             IllegalArgumentException | InvocationTargetException ex) {
      ex.printStackTrace();
    }
  }
}