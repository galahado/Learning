import static java.lang.System.out;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class ClassAnnotationProcessor {

  public static void main(String[] args) {
    ClassAnnotationProcessor.printer(Base.class, Subtype.class,
            BasicCalc.class, AdvancedCalc.class, Gizmo.class);
    ClassAnnotationProcessor.printer(Item.class);
  }

  public static void printer(AnnotatedElement... elements) {
    for(AnnotatedElement element: elements) {
      Annotation[] annotations = element.getAnnotations();
      if (annotations.length == 0) {
        out.printf("%s is not annotated.%n", element);
        continue;
      }
      for (Annotation annotation : annotations)
        out.printf("%s is annotated with %s%n", element, annotation);
    }
  }
}