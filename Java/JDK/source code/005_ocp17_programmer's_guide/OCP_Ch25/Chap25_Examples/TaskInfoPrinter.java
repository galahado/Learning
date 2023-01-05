import java.util.Arrays;
public class TaskInfoPrinter {
  public static void main(String[] args) {
    printTaskInfoAnnotations(NuclearPlant.class);
  }

  public static void printTaskInfoAnnotations(Class<?> classobj) {       // (1)
    TaskInfo[] tias = classobj.getAnnotationsByType(TaskInfo.class);     // (2)
    if (tias.length == 0) {
      System.out.printf("No %s annotation for %s%n", TaskInfo.class.getName(),
                                                     classobj);
      return;
    }
    System.out.printf("%s annotation for %s%n", TaskInfo.class.getName(),
                                                classobj);
    TaskInfo tia = tias[0];                                             // (3)
    String desc = tia.taskDesc();
    String[] handlers = tia.assignedTo();
    TaskInfo.TaskPriority priority = tia.priority();
    System.out.println("Task description: " + desc);
    System.out.println("People assigned: " + Arrays.toString(handlers));
    System.out.println("Priority: " + priority);
  }
}