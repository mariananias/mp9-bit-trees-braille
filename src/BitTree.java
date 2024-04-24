import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Class intended to store mappings from bits to values.
 * 
 * @author Marina Ananias
 */

public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Builds a tree that will store mappings from strings of n bits to strings. 
   * We’d build our tree for mapping braille to ASCII with new BitTree(6). 
   * We’d build our tree for mapping ASCII to braille with new BitTree(7) or 
   * new BitTree(8). Do not create nodes in the tree until they are needed.
   */
  BitTree(int n) {

  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Follows the path through the tree given by bits (adding nodes as appropriate) 
   * and adds or replaces the value at the end with value. set should throw an exception 
   * if bits is the inappropriate length or contains values other than 0 or 1.   
   * 
   * @param bits
   * @param value
   */
  public void set (String bits, String value) {

    // if bits is has inappropriate length 

    // STUB
    return;
  } // set (String bits, String value)

  /**
   * Follows the path through the tree given by bits, returning the value at the end. 
   * If there is no such path, or if bits is the incorrect length, get should throw an exception.
   * 
   * @param bits
   */
    public String get (String bits) {
      // STUB
      return bits;
    } // get (String bits)

  /**
   * Prints out the contents of the tree in CSV format. 
   * For example, one row of our braille tree will be 
   * “101100,M” (without the quotation marks).
   * 
   * @param pen
   */
  void dump (PrintWriter pen) {
    // STUB
    return;
  } // dump (PrintWriter pen)

  /**
   * Reads a series of lines of the form bits,value and stores them in the tree.
   * 
   * @param source
   */
  void load (InputStream source) {
    // STUB
    return;
  } // load (InputStream source)
}
