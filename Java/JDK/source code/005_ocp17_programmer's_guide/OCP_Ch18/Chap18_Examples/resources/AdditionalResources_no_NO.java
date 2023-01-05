package resources;
import java.util.ListResourceBundle;
public class AdditionalResources_no_NO extends ListResourceBundle {  // (2)
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
        {"population", 5},
        {"currency", "NOK"},
        {"banknotes", new int[] {50, 100, 200, 500, 1000}},
    };
  }
}