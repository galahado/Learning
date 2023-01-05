// File: NumericOptionalUsage.java
import java.util.OptionalInt;

class Recipe {
  private String recipeName;
  private OptionalInt calories;    // Optional number of calories.

  public String getRecipeName() { return recipeName; }
  public OptionalInt getCalories() { return calories; }

  public Recipe(String recipeName, OptionalInt calories) {
    this.recipeName = recipeName;
    this.calories = calories;
  }
}

public final class NumericOptionalUsage {
  public static void main(String[] args) {
    // Creating an OptionalInt:
    OptionalInt optNOC0 = OptionalInt.of(3500);
    OptionalInt optNOC1 = OptionalInt.empty();

    // Creating recipes with optional number of calories:
    Recipe recipe0 = new Recipe("Mahi-mahi", optNOC0);
    Recipe recipe1 = new Recipe("Loco moco", optNOC1);

    // Querying an Optional:
    //  System.out.println(recipe1.getCalories()
    //                            .getAsInt());            // NoSuchElementException
    System.out.println((recipe1.getCalories().isPresent()
        ? recipe1.getCalories().getAsInt()
            : "Unknown calories."));       // Unknown calories.

    recipe0.getCalories().ifPresent(s -> System.out.println(s + " calories."));
    System.out.println(recipe0.getCalories().orElse(0) + " calories.");
    System.out.println(recipe1.getCalories().orElseGet(() -> 0) + " calories.");
    //  int noc = recipe1.getCalories()                    // RuntimeException
    //                .orElseThrow(() -> new RuntimeException("Unknown calories."));
  }
}