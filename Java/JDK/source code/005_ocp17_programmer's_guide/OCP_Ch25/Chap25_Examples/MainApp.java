import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.Arrays;
public class MainApp {
  public static void main(String[] args) {
    // get all class level annotations
    System.out.println("Class level annotations:");
    Annotation[] classAnnotations = Composition.class.getAnnotations(); // (7)
    processAnnotations(classAnnotations);
    
    // get all methods of a class
    System.out.println("Method level annotations:");
    Method[] methods = Composition.class.getMethods(); // (8)
    for(Method method: methods) {
      // get all annotation for each method
      Annotation[] methodAnnotations = method.getDeclaredAnnotations(); // (9)
      processAnnotations(methodAnnotations);
    }
    // get all fields of a class
    System.out.println("Field level annotations:");
    Field[] fields = Composition.class.getFields(); // (10)
    for(Field field: fields) {
      // get all annotation for each field
      Annotation[] fieldAnnotations = field.getDeclaredAnnotations(); // (9)
      processAnnotations(fieldAnnotations);
    }
    // get all annotations of a specific type for a given class
    System.out.println("MusicMeta annotations:");
    MusicMeta[] musicAnnotations = Composition.class.getAnnotationsByType(MusicMeta.class);  // (11)
    processAnnotations(musicAnnotations);
  }
  
  private static void processAnnotations(Annotation[] annotations) {
    for(Annotation annotation: annotations) {
      // discover annotation type
      Class<?> annotationType = annotation.annotationType();  // (12)
      System.out.println(annotationType.getName()); // (13)
      // check annotation type
      if (annotation instanceof MusicMeta)  {  // (14)
        MusicMeta musicAnnotation = (MusicMeta)annotation; // (15)
        // get specific attributes
        String value = musicAnnotation.value();
        String[] countries = musicAnnotation.countries();
        System.out.println(value+", "+Arrays.toString(countries)); // (16)
      }
    }
  }
}
