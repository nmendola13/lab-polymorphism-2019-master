package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left portion of the composition.
   */
  TextBlock main;

  /**
   * The right portion of the composition.
   */
  int newWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing left and right side by side.
   */
  public HorizontallyFlipped(TextBlock main) {
    this.main = main;
  } // HComposition(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    
    int h = this.main.height();

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String initial = this.main.row(i);

    char[] charArray = initial.toCharArray();

    for (i = 0; i < (charArray.length / 2); i++) {
        char temp = charArray[i];
        charArray[i] = charArray[charArray.length - i - 1];
        charArray[charArray.length - i - 1] = temp;
    }

    String result = new String(charArray);

    return result;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    // The height is the greater of the heights of the left and right
    // blocks.
    return this.main.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    // The number of columns is the width of the left plus the
    // width of the right.
    return this.main.width();
  } // width()

} // class HComposition
