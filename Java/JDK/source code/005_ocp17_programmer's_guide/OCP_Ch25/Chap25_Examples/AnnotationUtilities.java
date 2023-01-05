import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.stream.Stream;

public class AnnotationUtilities {

  public static void printAllAnnotations(Class<?> classobj) {              // (1)
    printAnnotatedElements(classobj);                                      // (2)
    printAnnotatedElements(classobj.getDeclaredConstructors());            // (3)
    printAnnotatedElements(classobj.getDeclaredMethods());                 // (4)
    printAnnotatedElements(classobj.getDeclaredFields());                  // (5)
  }

  public static void printAnnotatedElements(AnnotatedElement... elements) {// (6)
    Stream.of(elements)                                                    // (7)
      .peek(ae -> System.out.printf("Annotations for \'%s\':%n", ae))      // (8)
      .flatMap(ae -> Stream.of(ae.getDeclaredAnnotations()))               // (9)
      .forEach(a -> System.out.println("  " + a));                         // (10)
  }

  public static void printSpecificAnnotations(Class<? extends Annotation> aType,
                                              Class<?> classobj) {         // (11)
    printSpecificAnnotation(aType, classobj);
    printSpecificAnnotation(aType, classobj.getDeclaredConstructors());
    printSpecificAnnotation(aType, classobj.getDeclaredMethods());
    printSpecificAnnotation(aType, classobj.getDeclaredFields());
  }

  public static void printSpecificAnnotation(Class<? extends Annotation> aType,
                                            AnnotatedElement... elements) {// (12)
    Stream.of(elements)                                                    // (13)
      .filter(e -> e.isAnnotationPresent(aType))                           // (14)
      .peek(ae -> System.out.printf("%s annotation for \'%s\':%n",
                                    aType.getName(), ae))                  // (15)
      .flatMap(ae -> Stream.of(ae.getDeclaredAnnotationsByType(aType)))    // (16)
      .forEach(a -> System.out.println("  " + a));                         // (17)
  }
}