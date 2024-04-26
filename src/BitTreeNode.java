/**
 * Class representing nodes of the BitTree
 *
 * @author Marina Ananias
 */
class BitTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  private String value;

  private BitTreeNode leftChild;

  private BitTreeNode rightChild;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  // Constructor for interior nodes
  public BitTreeNode() {
    this.leftChild = null;
    this.rightChild = null;
  }

  // Constructor for leaf nodes
  public BitTreeNode(String value) {
    this.value = value;
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Method to check if the node is a leaf.
   * 
   * @return
   */
  public boolean isLeaf() {
    return leftChild == null && rightChild == null;
  } // isLeaf()

  /**
   * Method to get node's value.
   * 
   * @return
   */
  public String getValue() {
    return value;
  } // getValue()

  /**
   * Method to set "value".
   * 
   * @param value
   */
  public void setValue(String value) {
    this.value = value;
  } // setValue(String)

  /**
   * Method to get leftChild.
   * 
   * @return
   */
  public BitTreeNode getLeftChild() {
    return leftChild;
  } // getLeftChild()

  /**
   * Method to set leftChild
   * 
   * @param leftChild
   */
  public void setLeftChild(BitTreeNode leftChild) {
    this.leftChild = leftChild;
  } // setLeftChild(BitTreeNode)

  /**
   * Method to get rightChild.
   * 
   * @return
   */ 
   public BitTreeNode getRightChild() {
    return rightChild;
  } // getRightChild()

  /**
   * Method to set rightChild.
   * 
   * @param rightChild
   */
  public void setRightChild(BitTreeNode rightChild) {
    this.rightChild = rightChild;
  } // setRightChild(BitTreeNode)

} // BitTreeNode class
