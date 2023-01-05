package safe;
/** Interface that defines a basic counter. */
interface ICounter {                                                      // (1)
  void increment();
  int getValue();
}