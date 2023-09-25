package lab.polymorphism;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {

    PrintWriter pen = new PrintWriter(System.out, true);

    TextBlock block2 = new TextLine("World");
    TextBlock block = new TextLine("Hello");
    
    TBUtils.print(pen, block);
    
    VComposition block_vert = new VComposition(block, block2);

    TBUtils.print(pen, block_vert);

    BoxedBlock block_box = new BoxedBlock(block_vert);

    TBUtils.print(pen, block_box);

    VerticallyFlipped WorldHello = new VerticallyFlipped(block_box);

    TBUtils.print(pen, WorldHello);

    HorizontallyFlipped horiflip = new HorizontallyFlipped(block_box);

    TBUtils.print(pen, horiflip);

    BoxedBlock block_box_2 = new BoxedBlock(block_box);

    TBUtils.print(pen, block_box_2);

    Truncate block_trunc = new Truncate(block_box_2, 4);

    TBUtils.print(pen, block_trunc);

    pen.close();
  } // main(String[])

} // class TBExpt
