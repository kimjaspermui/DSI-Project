/**
 * Name:            Kim Jasper Mui, Erick Soto, Tiffany Pan
 * Date:            Dec 23 2016
 * Filename:        MyArrayList.java
 * Description:     Partial implementation of the ArrayList using int as the
 *                  data type of each element. This will create the GUI
 *                  representation of the ArrayList. It contains functionality
 *                  for add, find, and remove.
 * Sources of help: None.
 */

import objectdraw.*;

/**
 *
 */
public class MyArrayList implements MyDataStructure {

  private DrawingCanvas myCanvas;

  private static final int INITIAL_SIZE = 10;

  /**
   * MyArrayList constructor, to initialize the data structure and draw out the
   * array in the passed in canvas.
   */
  public MyArrayList(DrawingCanvas canvas) {

    myCanvas = canvas;

    for (int i = 0; i < INITIAL_SIZE; i++) {

      // add empty array
    }
  }

  /**
   * This inner class will create a cell of the array (a box with a value in
   * it).
   */
  protected class MyCell {

    // the value inside the cell and the frame
    private Text value;
    private FramedRect cellFrame;

    // the size of width and height
    public static final double FRAME_WIDTH = 10;
    public static final double FRAME_HEIGHT = 10;

    public MyArrayList(String value, Location location, DrawingCanvas canvas)
    {

      // place the with the value on the canvas
      cellFrame = new FramedRect(frameLocation, FRAME_WIDTH, FRAME_HEIGHT,
      canvas);
      value = new Text(value, location, canvas);
    }
  }

  /**
   * add method, to insert the passed in value to the data structure.
   *
   * @param int number - the value to be added in the data structre.
   *
   * @return a boolean to indicate whether or not the value has been
   * successfully inserted to the data structure.
   *
   * @author
   */
  public boolean add(int number) {

  }

  /**
   * find method, to search the passed in value in the data structure.
   *
   * @param int number - the value to look for in the data structure.
   *
   * @return a boolean to indicate whether or not the value has been
   * successfully found in the data structure.
   *
   * @author
   */
  public boolean find(int number) {

  }

  /**
   * remove method, to remove the passed in value from the data structure.
   *
   * @param int number - the value to be removed from the data structure.
   *
   * @return a boolean to indicate whether or not the value has been
   * successfully removed from the data structure.
   *
   * @author
   */
  public boolean remove(int number) {

  }
}
