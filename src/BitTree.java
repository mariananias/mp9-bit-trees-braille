import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class intended to store mappings from bits to values.
 *
 * @author Marina Ananias
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  private BitTreeNode root;

  private int depth;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Builds a tree that will store mappings from strings of n bits to strings. We’d build our tree
   * for mapping braille to ASCII with new BitTree(6). We’d build our tree for mapping ASCII to
   * braille with new BitTree(7) or new BitTree(8). Do not create nodes in the tree until they are
   * needed.
   * 
   * @param n
   */
  public BitTree(int n) {
    root = new BitTreeNode();
    depth = n;
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Follows the path through the tree given by bits (adding nodes as appropriate) and adds or
   * replaces the value at the end with value. set should throw an exception if bits is the
   * inappropriate length or contains values other than 0 or 1.
   *
   * @param bits
   * @param value
   * @throws Exception
   */
  public void set(String bits, String value) throws IllegalArgumentException {
    if (bits.length() != depth || !isValidBits(bits)) {
      throw new IllegalArgumentException("Invalid bits");
    }
    BitTreeNode currentNode = root;
    for (int i = 0; i < bits.length(); i++) {
      char bit = bits.charAt(i);
      if (bit == '0') {
        if (currentNode.getLeftChild() == null) {
          currentNode.setLeftChild(new BitTreeNode());
        }
        currentNode = currentNode.getLeftChild();
      } else if (bit == '1') {
        if (currentNode.getRightChild() == null) {
          currentNode.setRightChild(new BitTreeNode());
        }
        currentNode = currentNode.getRightChild();
      } else {
        throw new IllegalArgumentException("Invalid bit value. Bits must be either '0' or '1'.");
      }
    }
    currentNode.setValue(value);
  } // set(String, String)

  /**
   * Follows the path through the tree given by bits, returning the value at the end. If there is no
   * such path, or if bits is the incorrect length, get should throw an exception.
   *
   * @param bits
   * @throws Exception
   */
  public String get(String bits) throws IllegalArgumentException {
    if (bits.length() != depth || !isValidBits(bits)) {
      throw new IllegalArgumentException("Invalid bits");
    }
    BitTreeNode currentNode = root;
    for (int i = 0; i < bits.length(); i++) {
      char bit = bits.charAt(i);
      if (bit == '0') {
        if (currentNode.getLeftChild() == null) {
          throw new IllegalArgumentException("Path not found in the tree.");
        }
        currentNode = currentNode.getLeftChild();
      } else if (bit == '1') {
        if (currentNode.getRightChild() == null) {
          throw new IllegalArgumentException("Path not found in the tree.");
        }
        currentNode = currentNode.getRightChild();
      } else {
        throw new IllegalArgumentException("Invalid bit value. Bits must be either '0' or '1'.");
      }
    }
    return currentNode.getValue();
  } // get(String)

  /**
   * Prints out the contents of the tree in CSV format. For example, one row of our braille tree
   * will be “101100,M” (without the quotation marks).
   *
   * @param pen
   */
  public void dump(PrintWriter pen) {
    dumpHelper(root, "", pen);
  } // dump (PrintWriter)

  /**
   * Recursive helper function to dump tree contents
   * 
   * @param node
   * @param bits
   * @param pen
   */
  private void dumpHelper(BitTreeNode node, String bits, PrintWriter pen) {
    if (node.isLeaf()) {
      pen.println(bits + "," + node.getValue());
    } else {
      if (node.getLeftChild() != null) {
        dumpHelper(node.getLeftChild(), bits + "0", pen);
      }
      if (node.getRightChild() != null) {
        dumpHelper(node.getRightChild(), bits + "1", pen);
      }
    }
  } // dumpHelper(BitTreeNode, String, PrintWriter) 

  /**
  * Reads a series of lines of the form bits,value and stores them in the tree.
  *
  * @param source The input stream to read from.
  * @throws Exception
  */
  public void load(InputStream source) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(source))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
          set(parts[0], parts[1]);
        }
      }
    }
  } // load(InputStream)

  // Method to check if the bits are valid (contain only '0' and '1')
  private boolean isValidBits(String bits) {
    for (int i = 0; i < bits.length(); i++) {
      char c = bits.charAt(i);
      if (c != '0' && c != '1') {
        return false;
      }
    }
    return true;
  } // isValidBits(String)

} // BitTree class