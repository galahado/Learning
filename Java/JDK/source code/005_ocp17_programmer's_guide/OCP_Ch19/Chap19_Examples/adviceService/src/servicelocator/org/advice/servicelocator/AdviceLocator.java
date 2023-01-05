// File:./src/servicelocator/org/advice/servicelocator/AdviceLocator.java
package org.advice.servicelocator;

import java.util.*;
import java.util.stream.*;
import org.advice.si.*;

public class AdviceLocator {

  /** Get advice for a particular locale. */
  public static Optional<IAdvice> getAdvice(Locale desiredLocale) {     // (1)
    ServiceLoader<IAdvice> loader = ServiceLoader.load(IAdvice.class);  // (2)
    Stream<ServiceLoader.Provider<IAdvice>> spStream = loader.stream(); // (3)
    Optional<IAdvice> optAdvice = spStream                              // (4)
      .map(ServiceLoader.Provider::get)                   // (5) Stream<IAdvice>
      .filter(a -> desiredLocale.equals(a.getLocale()))   // (6)
      .findFirst();                                       // (7)
    return optAdvice;
  }

  /** Get all advice implemented by all providers. */
  public static List<IAdvice> getAllAdvice() {            // (8)
    ServiceLoader<IAdvice> loader = ServiceLoader.load(IAdvice.class);
    List<IAdvice> allAdvice = loader
      .stream()
      .map(p -> p.get())                  // (9) map(ServiceLoader.Provider::get)
      .collect(Collectors.toList());      // (10) List<IAdvice>
    return allAdvice;
  }
}