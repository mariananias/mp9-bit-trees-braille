import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that stores translation information.
 *
 * @author Marina Ananias
 */
public class BrailleASCIITables {

  private static String getValue(String filename, String key) {

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while (((line = reader.readLine()) != null)) {
        String[] parts = line.split(",");
        if ((key.equals(parts[0])) && (parts.length == 2)) {
          return parts[1];
        }
      } // while
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "Error: Key not found.";
  } // getValue (String, String)

  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille
   * character.
   * 
   * @param letter The ASCII character to convert.
   * @return The braille representation of the ASCII character.
   */
  public static String toBraille(char letter) {
    String key = Integer.toBinaryString(letter);
    key = "0" + key; // to match texfile binary representation
    // return getValue("src/ASCIIToBraille.txt", key);
    return getValue("ASCIIToBraille.txt", key);
  } // toBraille(String)

  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII
   * character.
   * 
   * @param brailleBits The string of bits representing a braille character.
   * @return The corresponding ASCII character.
   */
  public static String toASCII(String brailleBits) {
    // return getValue("src/BrailleToASCII.txt", brailleBits);
    return getValue("BrailleToASCII.txt", brailleBits);
  } // toASCII(String)

  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille
   * character.
   * 
   * @param bits The string of bits representing a braille character.
   * @return The corresponding Unicode braille character.
   */
  public static String toUnicode(String bits) {
    return getValue("BrailleToUnicode.txt", bits);
  } // toUnicode(String)
  
} // BrailleASCIITables class