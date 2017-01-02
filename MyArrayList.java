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
import java.util.*;

/**
 *
 */
public class MyArrayList implements MyDataStructure {

  public static final int HALF = 2;

  // the canvas to draw the ArrayList
  private DrawingCanvas myCanvas;

  // number of cells initially
  private static final int INITIAL_SIZE = 10;

  // the size of width and height of a cell
  public static final int FRAME_SIZE = 50;

  // LinkedList to store a list of cells
  private LinkedList<MyCell> myList;

  // positions of the first cell on the canvas
  private int xPos = 0;
  private int yPos = 0;

  // the number of elements in the ArrayList
  private int nelems = 0;

  /**
   * MyArrayList constructor, to initialize the data structure and draw out the
   * array in the passed in canvas.
   */
  public MyArrayList(DrawingCanvas canvas) {

    // store the drawing canvas
    myCanvas = canvas;

    myList = new LinkedList<>();

    // initialize the x and y positions
    xPos = FRAME_SIZE;
    yPos = canvas.getHeight() / HALF - FRAME_SIZE / HALF;

    // temporary x position for creating cells
    int x = xPos;

    // for loop to initialize an empty array
    for (int i = 0; i < INITIAL_SIZE; i++) {

      // add empty array
      myList.add(new MyCell(new Location(x, yPos), myCanvas));
      x += FRAME_SIZE;
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

    /**
     * MyCell constructor to initialize a cell in the ArrayList with no value
     * in it.
     */
    public MyCell(Location location, DrawingCanvas canvas) {

      int halfFrame = FRAME_SIZE / HALF;

      // place the cell with no value on the canvas
      cellFrame = new FramedRect(location, FRAME_SIZE, FRAME_SIZE, canvas);
      value = new Text("", location.getX(), location.getY() + halfFrame / HALF,
      canvas);
      value.setFontSize(halfFrame);
    }

    /**
     * setValue method, to change the value in the Text object with the passed
     * in value.
     * 
     * @param int number, the value to be used in the Text object.
     * 
     * @author Jasper
     */
    public void setValue(int number) {

      // change the text
      value.setText(number);

      // reset the text
      value.moveTo(cellFrame.getX(), value.getY());

      // position the text
      value.move(FRAME_SIZE / HALF - (value.getWidth() / HALF), 0);
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
   * @author Jasper
   */
  public boolean add(int number) {

    // case when there is still space in the ArrayList
    if (nelems < myList.size()) {

      MyCell current = myList.get(nelems);
      current.setValue(number);
      nelems++;
    }

    return true;
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

    return true;
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

    return true;
  }
}
