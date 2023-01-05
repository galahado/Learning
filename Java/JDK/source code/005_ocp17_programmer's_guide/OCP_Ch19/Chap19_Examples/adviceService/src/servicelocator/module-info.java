// File: ./src/servicelocator/module-info.java
module servicelocator {
  requires serviceinterface;
  exports org.advice.servicelocator;
  uses org.advice.si.IAdvice;          // In module serviceinterface.
}