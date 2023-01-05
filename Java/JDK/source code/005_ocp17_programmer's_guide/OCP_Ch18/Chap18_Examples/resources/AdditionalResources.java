package resources;
import java.util.ListResourceBundle;
public class AdditionalResources extends ListResourceBundle {        // (1)
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
        {"population", 314},                                // Value type: Integer
        {"currency", "USD"},                                // Value type: String
        {"banknotes", new int[] {1, 2, 5, 10, 20, 50, 100}},// Value type: int[]
    };
  }
}