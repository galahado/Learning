import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;

public class InheritingAnnotations {}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Hereditary { }

@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@interface Root {}

@Root
@Hereditary
class Base {}
class Subtype extends Base { }

@Root
@Hereditary
interface BasicCalc {}
interface AdvancedCalc extends BasicCalc {}

class Gizmo implements BasicCalc {}