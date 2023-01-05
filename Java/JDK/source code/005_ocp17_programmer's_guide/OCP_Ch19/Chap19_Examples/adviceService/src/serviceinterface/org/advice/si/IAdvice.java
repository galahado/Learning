// File: ./src/serviceinterface/org/advice/si/IAdvice.java
package org.advice.si;
import java.util.Locale;

// Service interface
public interface IAdvice {
  String getContent();                  // (1) Returns the content of the advice.
  Locale getLocale();                   // (2) Returns the associated locale.
}