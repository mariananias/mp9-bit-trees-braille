import java.io.PrintWriter;

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
			String unicode = translateToUnicode(sourceChars);
			pen.println(unicode);
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
		// Iterate through each character in sourceChars
		for (char c : sourceChars.toCharArray()) {
			// Lookup the ASCII representation for the character
			String asciiChar = BrailleASCIITables.toASCII(c);
			// Append the ASCII representation to the result
			result.append(asciiChar);
		}
		return result.toString();
	} // translateToASCII(String)

	/**
	 * Translates source characters to Unicode.
	 * 
	 * @param sourceChars The source characters to translate.
	 * @return The translation to Unicode.
	 */
	private static String translateToUnicode(String sourceChars) {
		StringBuilder result = new StringBuilder();
		// Iterate through each character in sourceChars
		for (char c : sourceChars.toCharArray()) {
			// Convert the character to its Unicode representation
			String unicodeChar = String.format("\\u%04x", (int) c);
			// Append the Unicode representation to the result
			result.append(unicodeChar);
		}
		return result.toString();
	} // translateToUnicode(String)

} // BrailleASCII class
