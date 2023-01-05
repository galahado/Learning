// Class ValidLVTI illustrates valid use of the restricted type name var.
public class ValidLVTI {

  // Static initializer block:
  static {
    var slogan = "Keep calm and code Java.";        // (1a) Allowed in static
  }                                                 //      initializer block

  // Instance initializer block:
  {
    var banner = "Keep calm and catch exceptions."; // (1b) Allowed in instance
  }                                                 //      initializer block

  // Constructor:
  public ValidLVTI() {
    var luckyNumber = 13;                       // (2) Allowed in a constructor.
  }

  // Method:
  public static void main(String[] args) {

    var virus = "COVID-19";                     // (3a) Type of virus is String.
    var acronym = virus.substring(0, 5);        // (3b) Type of acronym is String.
    var num = Integer.parseInt(virus.substring(6)); // (3c) Type of num is int.

    var obj = new Object();                     // (4) Type of obj is Object.
    var title = (String) null; // (5) Initialization expression type is String.
                               //     Type of title is String.
    var sqrtOfNumber = Math.sqrt(100); // (6) Type of sqrtOfNumber is double,
                                       //     since the method returns
                                       //     a double value.

    var tvSize  = (short) 55;  // (7) Type of tvSize is short.
    var tvSize2 = 65;          // (8) Type of tvSize2 is int.

    var diameter = 10.0;       // (9) Type of diameter is double.
    var radius = 2.5F;         // (10) Type of radius is float.

    // Arrays:
    var vowels = new char[] {'a', 'e', 'i', 'o', 'u' }; // (11a) Type of vowels
                                                        // is char[]. Size is 5.
    var zodiacSigns = new String[12]; // (11b) Type of zodiacSigns is String[].
                                      //       Size is 12.
    var a_2x3 = new int[2][3]; // (11c) Type of a_2x3 is int[][]. Size is 2x3.
    var a_2xn = new int[2][];  // (11d) Type of a_2xn is int[][]. Size is 2x?,
                               //       where second dimension can be undefined.

    // The for(:) loop:
    var word1 = "";            // (12) Type of word2 is String.
    for (var vowel : vowels) { // (13) Type of vowel is char in the for(:)loop.
      var letter = vowel;      // (14) Type of letter is char.
      word1 += letter;
    }

    // The for(;;) loop:
    var word2 = "";                           // (15) Type of word2 is String.
    for (var i = 0; i < vowels.length; i++) { // (16) Type of i is int in
                                              //      the for loop.
      var letter = vowels[i];                 // (17) Type of letter is char.
      word2 += letter;
    }

    // switch-statement:
    switch(virus) {
      case "Covid-19":
        var flag = "Needs to be tested.";     // (18) Type is String.
        // Do testing.
        break;
      default: // Do nothing.
    }
  }
}