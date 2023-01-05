
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
//@Target(ElementType.ANNOTATION_TYPE)
@Target({TYPE_USE, TYPE_PARAMETER, TYPE, FIELD, METHOD})
@interface Tag {
  String value() default "OK";
}

@Tag
@interface Status {
  String value() default "OK";
}

@Tag class AnnoCases<T> extends Object {

  final @Tag String str = (String) "Hi";
  java.lang. String str2 = (String) "Hi";
  @Tag @Status(value = "Not ok") String coldCaseName;

  AnnoCases<String> sc = new AnnoCases<String>();

  <V> void simpleMethod(@Tag V v) {}
  @Tag int caseNumber() { return 10; }
}

@Tag class SpecialCase<@Tag T> extends @Tag Object {

  @Tag SpecialCase() {}

  final @Tag String str = (@Tag String) "Hi";
  java.lang. @Tag String str2 = (String) "Hi";
  @Tag String coldCaseName;

  SpecialCase<@Tag String> sc = new SpecialCase<@Tag String>();

  <@Tag V> void simpleMethod(@Tag V v) {}
  @Tag int caseNumber() { return 10; }
}

@Tag class OldCase {}

@Tag enum TRIPPEL {HOP, @Tag STEP, JUMP}

//________________________________
@Target({})
@interface Exclusive { }

//@Exclusive class Krypton {}                // Compile-time error.


@interface ExtraExclusive {
  Exclusive value() default @Exclusive;
}

@ExtraExclusive class Titanium {}
//________________________________