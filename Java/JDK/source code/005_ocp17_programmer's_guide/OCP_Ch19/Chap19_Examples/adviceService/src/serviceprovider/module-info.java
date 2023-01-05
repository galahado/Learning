// File: ./src/serviceprovider/module-info.java

// Service provider provides 2 implementation of the service interface.
module serviceprovider {
  requires serviceinterface;
  provides org.advice.si.IAdvice with
    org.advice.serviceprovider.CannedAdvice,
    org.advice.serviceprovider.VikingAdvice;
}