package resources;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;

public class AdditionalResources_fr_CA extends ResourceBundle {      // (4)
  @Override
  protected Object handleGetObject(String key) {
    switch (key) {
      case "population": return 35;
      case "currency":   return "CAD";
      case "banknotes":  return new int[] {5, 10, 20, 50, 100};
      default:           return null;
    }
  }

  @Override
  public Enumeration<String> getKeys() {
    return new Vector<>(
        Arrays.asList("population", "currency", "banknotes")
    ).elements();
  }
}