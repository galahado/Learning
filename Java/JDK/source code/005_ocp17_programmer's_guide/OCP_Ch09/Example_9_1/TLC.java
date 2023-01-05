
class TLC {                       // (1) Top-level class

  // Static member types:
  static class     SMC {}         // (2) Static member class
         interface SMI {}         // (3) Static member interface
         enum      SME {}         // (4) Static member enum
         record    SMR() {}       // (5) Static member record

  // Non-static member class:
  class NSMC {}                   // (6) Inner class

  // Local types in non-static context (analogous for static context):
  void nsm() {                    // Non-static method
    class     LC {}               // (7) Local class (inner class)
    interface SLI {}              // (8) Static local interface
    enum      SLE {}              // (9) Static local enum
    record    SLR() {}            // (10) Static local record
  }

  // Anonymous classes (here defined as initializer expressions):
         SMC nsf = new SMC() {};  // (11) Inner class in non-static context
  static SMI  sf = new SMI() {};  // (12) Inner class in static context
}