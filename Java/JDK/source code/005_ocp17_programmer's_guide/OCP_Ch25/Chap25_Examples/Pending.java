import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marker annotation to indicate that a program element is still pending.
 * Can be used on any program element.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Pending { }