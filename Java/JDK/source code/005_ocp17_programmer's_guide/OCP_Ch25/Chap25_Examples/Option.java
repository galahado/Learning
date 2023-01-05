import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//enum Size {S, M, L, XL}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Options.class)
@interface Option {
  String color();
  Size size() default Size.L;
}

// Containing annotation type
@Retention(RetentionPolicy.RUNTIME)
@interface Options {
  Option[] value();
  double minPrice() default 1.00;    // Must specify a default value.
}

@Option(color="Green", size=Size.S)
@Option(color="Yellow", size=Size.XL)
@Option(color="Red", size=Size.M)
@Option(color="White")
class Item10 {}