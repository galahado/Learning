import static java.lang.System.out;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.stream.Stream;

public class TaskInfoAnnotationProcessor {

  public static void printTaskInfoAnnotation(AnnotatedElement... elements) {// (1)
    Stream.of(elements)                                                     // (2)
      .filter(ae -> ae.isAnnotationPresent(TaskInfo.class))                 // (3)
      .peek(ae -> out.printf("%s annotation for '%s':%n",                   // (4)
          TaskInfo.class.getName(), ae))
      .flatMap(ae -> Stream.of(
                       ae.getDeclaredAnnotationsByType(TaskInfo.class)))    // (5)
      .forEach(a -> {                                                       // (6)
        out.printf("  Task description: %s%n", a.taskDesc());
        out.printf("  Priority: %s%n", a.priority());
        out.printf("  Assigned to: %s%n", Arrays.toString(a.assignedTo()));
      });
  }

  public static void main(String[] args) {
    Class<?> classobj = NuclearPlant.class;                                 // (7)
    printTaskInfoAnnotation(classobj);                                      // (8)
    printTaskInfoAnnotation(classobj.getDeclaredMethods());                 // (9)
  }
}