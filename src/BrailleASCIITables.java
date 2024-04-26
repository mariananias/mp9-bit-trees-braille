import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class that stores translation information.
 *
 * @author Marina Ananias
 */
public class BrailleASCIITables {

  // Define mappings for ASCII to braille, braille to ASCII, and braille to Unicode
  private static final HashMap<Character, String> asciiToBrailleMap = new HashMap<>();
  private static final HashMap<String, Character> brailleToAsciiMap = new HashMap<>();
  private static final HashMap<String, Character> brailleToUnicodeMap = new HashMap<>();

  // Load mappings from text files
  static {
    loadMappings("ASCIIToBraille.txt", asciiToBrailleMap);
    loadMappings("BrailleToASCII.txt", brailleToAsciiMap);
    loadMappings("BrailleToUnicode.txt", brailleToUnicodeMap);
  }

  /**
   * Loads mappings from a text file into the specified map.
   * 
   * @param filename The name of the text file containing the mappings.
   * @param map The map to load the mappings into.
   */
  @SuppressWarnings("unchecked")
  private static <K, V> void loadMappings(String filename, HashMap<K, V> map) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
          // Convert char to String before adding to the map
          map.put((K) parts[0], (V) String.valueOf(parts[1].charAt(0)));        
        } // if
      } // while
    } catch (IOException e) {
      e.printStackTrace();
    }
  } // loadMappings(String, HashMap)

  /**
   * Converts an ASCII character to a string of bits representing the 
   * corresponding braille character.
   * 
   * @param letter The ASCII character to convert.
   * @return The braille representation of the ASCII character.
   */
  public static String toBraille(char letter) {
    return asciiToBrailleMap.getOrDefault(Character.toUpperCase(letter), "");
  } // toBraille(char)

  /**
   * Converts a string of bits representing a braille character to the 
   * corresponding ASCII character.
   * 
   * @param c The string of bits representing a braille character.
   * @return The corresponding ASCII character.
   */
  public static String toASCII(char c) {
    return String.valueOf(brailleToAsciiMap.getOrDefault(c, ' ')); // Default to space if not found
  } // toASCII(char)

  /**
   * Converts a string of bits representing a braille character to the 
   * corresponding Unicode braille character.
   * 
   * @param bits The string of bits representing a braille character.
   * @return The corresponding Unicode braille character.
   */
  public String toUnicode(String bits) {
    return String.valueOf(brailleToUnicodeMap.getOrDefault(bits, ' ')); // Default to space if notfound
  } // toUnicode(String)
  
} // BrailleASCIITables class
