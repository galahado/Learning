package resources;
import java.util.ListResourceBundle;
public class AdditionalResources_fr_FR extends ListResourceBundle {  // (3)
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
        {"population", 66},
        {"currency", "EUR"},
        {"banknotes", new int[] {5, 10, 20, 50, 100, 200, 500}},
    };
  }
}