import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Takes two command-line parameters, the first of which represents the target character set and the
 * second of which represents the source characters, and that translates the text.
 * 
 * @author Marina Ananias
 */
public class BrailleASCII {
	
	public static void main(String[] args) throws Exception {		
		// PrintWriter for printing the translation result
		PrintWriter pen = new PrintWriter(System.out, true);
		
		// Check if command-line arguments are provided
		if (args.length < 2) {
			return;
		}

		// Extract command-line arguments
		String targetCharSet = args[0];
		String sourceChars = args[1];

		// Translate based on the target character set
		if (targetCharSet.equals("braille")) {
			// Translate source characters to braille
			String braille = translateToBraille(sourceChars);
			pen.println(braille);
		} else if (targetCharSet.equals("ascii")) {
			// Translate source characters to ASCII
			String ascii = translateToASCII(sourceChars);
			pen.println(ascii);
		} else if (targetCharSet.equals("unicode")) {
			// Translate source characters to Unicode
			translateToUnicode(sourceChars);
		} else {
			pen.println("Invalid target character set.");
		}
	} // main

	/**
	 * Translates source characters to braille.
	 * 
	 * @param sourceChars The source characters to translate.
	 * @return The translation to braille.
	 */
	private static String translateToBraille(String sourceChars) {
		StringBuilder result = new StringBuilder();
		// Iterate through each character in sourceChars
		for (char c : sourceChars.toCharArray()) {
			// Lookup the Braille representation for the character
			String brailleChar = BrailleASCIITables.toBraille(c);
			// Append the Braille representation to the result
			result.append(brailleChar);
		}
		return result.toString();
	} // translateToBraille(String)

	/**
	 * Translates source characters to ASCII.
	 * 
	 * @param sourceChars The source characters to translate.
	 * @return The translation to ASCII.
	 */
	private static String translateToASCII(String sourceChars) {
		StringBuilder result = new StringBuilder();
		char[] charArr = sourceChars.toCharArray();
		for (int i = 0; i < (charArr.length - 5); i+= 6) {
			// Split array by character
			String brailleChar = new String (Arrays.copyOfRange(charArr, i, i+6));
			// Convert and append the ASCII representation to the result
			String asciiChar = BrailleASCIITables.toASCII(brailleChar);
			result.append(asciiChar);
		}
		return result.toString().toLowerCase();
	} // translateToASCII(String)

	/**
	 * Translates source characters to Unicode.
	 * 
	 * @param sourceChars The source characters to translate.
	 * @return The translation to Unicode.
	 */
  private static void translateToUnicode(String sourceChars) {
		//StringBuilder result = new StringBuilder();
		char[] charArr = sourceChars.toCharArray();
		
		// if ASCII->Unicode
		if (charArr[0] != '0' && charArr[1] != '1') {
			translateToUnicode(translateToBraille(sourceChars));
		}

    for (int i = 0; i < (charArr.length - 5); i+= 6) {
      // Split array by character
      String brailleChar = new String (Arrays.copyOfRange(charArr, i, i+6));
      // Convert and append the ASCII representation to the result
      String unicodeChar = BrailleASCIITables.toUnicode(brailleChar);
      int j = Integer.decode("0x" + unicodeChar);
      System.out.print(Character.toChars(j));
    }
    System.out.println();
  } // translateToUnicode(String)
} // BrailleASCII class
