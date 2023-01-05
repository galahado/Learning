// File:./src/serviceprovider/org/advice/serviceprovider/CannedAdvice.java
package org.advice.serviceprovider;

import org.advice.si.IAdvice;
import java.util.Locale;

public class CannedAdvice implements IAdvice {
  public String getContent() {                         // (1)
    return "Keep calm and service on!"; 
  }
  public Locale getLocale() { return Locale.UK; }      // (2)
}