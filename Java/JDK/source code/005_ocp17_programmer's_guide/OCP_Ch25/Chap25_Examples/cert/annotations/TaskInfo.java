package cert.annotations;
import java.lang.annotation.ElementType;                       // (1)
import java.lang.annotation.Retention;                         // (2)
import java.lang.annotation.RetentionPolicy;                   // (3)
import java.lang.annotation.Target;                            // (4)

@Target({ElementType.TYPE, ElementType.METHOD})                // (5)
@Retention(RetentionPolicy.RUNTIME)                            // (6)
public @interface TaskInfo {                                   // (7)

  String taskDesc();                                           // (8)
  String[] value();                                            // (9)
  TaskPriority priority() default TaskPriority.NORMAL;         // (10)

  public enum TaskPriority { LOW, NORMAL, HIGH };              // (11)

  public static final String LOG_FILE = "./logs/Tasks.log";    // (12)

}