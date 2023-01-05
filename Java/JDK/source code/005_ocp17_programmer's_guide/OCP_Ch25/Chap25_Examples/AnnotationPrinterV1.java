import static java.lang.System.out;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationPrinterV1 {

  public static void main(String[] args) {
    //  printer.printAnnotations(UsingMyAnnotationTypes.class);
    //      AnnotationPrinter.printAnnotations(Item.class);
    AnnotationPrinterV1.printAnnotations(Composition.class);
    AnnotationPrinterV1.printAnnotations(Item.class);

  }

  public static <T> void printAnnotations(Class<T> classobj) {
    printAnnotationedElements(classobj);
    out.println();

    Constructor<?>[] cons = classobj.getDeclaredConstructors();
    printAnnotationedElements(cons);
    out.println();

    Method[] methods = classobj.getDeclaredMethods();
    printAnnotationedElements(methods);
    out.println();

    Field[] fields = classobj.getDeclaredFields();
    printAnnotationedElements(fields);
  }

  public static void printAnnotationedElements(AnnotatedElement... elements) {
    for(AnnotatedElement element: elements) {
      Annotation[] annotations = element.getDeclaredAnnotations();
      if (annotations.length == 0) {
        out.printf("No annotations for '%s'.%n", element);
        continue;
      }
      out.printf("Annotations for '%s':%n", element);
      for (Annotation annotation : annotations) {
        out.printf("- %s%n", annotation);
      }
    }
  }
}