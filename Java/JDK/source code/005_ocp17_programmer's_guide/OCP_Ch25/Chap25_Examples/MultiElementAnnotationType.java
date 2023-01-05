/*
A primitive type
A String
The class Class
An enum type
An annotation type
A 1-dimensional array whose element type is one of the above types
*/



public @interface MultiElementAnnotationType {

  public enum Priority { LOW, NORMAL, HIGH };

  public int certificationLevel()     default 1;
  String date()                       default "2021-01-11";
  Class<? extends PrettyPrinter> pp() default AdvancedPrettyPrinter.class;
  Priority priorityLevel()            default Priority.NORMAL;
  Tag annotation()                    default @Tag;
  SuppressWarnings warnings()         default @SuppressWarnings("unchecked");
  int[] value()                       default {10, 20, 30};

}

class PrettyPrinter {}
class AdvancedPrettyPrinter extends PrettyPrinter {}

@interface ProblematicAnnotationType {
  StringBuilder message();              // Illegal return type.
  int[][] voting();                     // Only 1-dim array allowed.
  String name;                          // Missing parentheses.
  private Thread.State state();         // Only public can be specified.
}

@interface Refactor {
  int id()          default (int) Math.random() * 100;// Not constant expression.
  String desc()     default null;                     // Cannot be null.
  String deadline() default new String("2021-01-11"); // Not constant expression.
  String[] team()   default new String[] {"VJ", "PT"};// Not constant expression.
}


