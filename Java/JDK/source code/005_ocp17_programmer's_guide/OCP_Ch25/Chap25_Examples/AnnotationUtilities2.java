import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class AnnotationUtilities2 {

  public static void printAllAnnotations(Class<?> classobj) {        // (1)
    System.out.println("Class level annotations:");
    printAnnotationedElements(classobj);                             // (2)

    System.out.println("Constructor level annotations:");
    Constructor<?>[] cons = classobj.getDeclaredConstructors();      // (3)
    printAnnotationedElements(cons);

    System.out.println("Method level annotations:");
    Method[] methods = classobj.getDeclaredMethods();                // (4)
    printAnnotationedElements(methods);

    System.out.println("Field level annotations:");
    Field[] fields = classobj.getDeclaredFields();                   // (5)
    printAnnotationedElements(fields);
  }

  public static void printAnnotationedElements(AnnotatedElement... elements) {  // (6)
    if (elements.length == 0) {
      System.out.println(" No annotated elements.");
      return;
    }

    for(AnnotatedElement element: elements) {                        // (7)
      System.out.println("-" + element);
      Annotation[] annotations = element.getAnnotations();           // (8)
      printAnnotations(annotations);
    }
  }

  public static void printAnnotations(Annotation... annotations) {   // (9)
    if (annotations.length == 0) {
      System.out.println(" No annotations.");
      return;
    }

    for(Annotation annotation: annotations) {                        // (10)
      System.out.println(" " + annotation);
    }
  }
}