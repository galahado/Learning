import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MusicMeta {
  String value();
  int maxDuration() default 9999;
  String[] countries();
}