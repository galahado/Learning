import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

enum Size {S, M, L, XL}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Choices.class)
@interface Choice {
  String color();
  Size size() default Size.L;
}

// Containing annotation type
@Retention(RetentionPolicy.RUNTIME)
@interface Choices {
  Choice[] value();
//  double minPrice() default 1.00;    // Must specify a default value.
}

@Choice(color="Green", size=Size.S)
@Choice(color="Yellow", size=Size.XL)
@Choice(color="Red", size=Size.M)
@Choice(color="White")
class Item {}