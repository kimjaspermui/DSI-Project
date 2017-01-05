/**
 * Name:            Kim Jasper Mui, Erick Soto, Tiffany Pan
 * Date:            Dec 24 2016
 * Filename:        MyController.java
 * Description:     This program is the controller of the GUI, which has a
 *                  general structures of the GUI representation.
 * Sources of help: None.
 */

import Acme.*;
import objectdraw.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

/**
 * This class contains the instructions to create the Graphical User Interface
 * layout for the menu and controller.
 */
public class MyController extends WindowController implements ActionListener,
MouseListener, MouseMotionListener {

  private static final int HALF = 2;

  // applet size
  private static final int APPLET_WIDTH = 1275;
  private static final int APPLET_HEIGHT = 730;

  // menu texts specifications
  private static final Color MENU_FONT_COLOR = Color.BLACK;
  private static final Color MENU_FONT_HOVER_COLOR = Color.BLUE;
  private static final int MENU_FONT_SIZE = 50;
  private static final int Y_GAP = 20;

  // menu texts from objectdraw
  private Text selectionText;
  private Text arrayListText;
  private Text instructionText;

  // canvas panels
  private JPanel southPanel;

  // buttons for the controller
  private JButton addButton;
  private JButton findButton;
  private JButton removeButton;

  // text fields for the controller
  private JTextField addTextField;
  private JTextField findTextField;
  private JTextField removeTextField;

  private static final int TEXT_FIELD_SIZE = 5;

  // the boolean to indicate whether or not the user is at the menu
  private boolean onMenu;

  private boolean textHover;

  // selection assigments
  private static final int ARRAYLIST = 0;

  private MyDataStructure myDS;

  /**
   * begin method, where everything starts
   * 
   * @author Jasper
   */
  public void begin() {

    onMenu = true;
    textHover = false;

    canvas.addMouseListener(this);
    canvas.addMouseMotionListener(this);

    setUpMenu();

    setUpController();

    // wait for user's selection of data structure in a loop

    // the rest is mouse events
  }

  /**
   * setUpMenu method, to display the initial data structure selection.
   * 
   * @author Jasper
   */
  private void setUpMenu() {

    // the menu instruction for selecting data structure
    selectionText = new Text("Please choose a data structure:", MENU_FONT_SIZE,
    MENU_FONT_SIZE, canvas);
    selectionText.setFontSize(MENU_FONT_SIZE);

    // data structures selection text
    arrayListText = new Text("Array List", selectionText.getX(),
    selectionText.getY() + MENU_FONT_SIZE + Y_GAP, canvas);

    // Text objects can be put into a linkedlist, so this set up can be done in
    // a for loop
    arrayListText.setFontSize(MENU_FONT_SIZE);
    arrayListText.setColor(MENU_FONT_COLOR);

    // create the instruction text
    instructionText = new Text("Please enter value between 0 to 999 then press "
    + "corresponding button to add, find, or remove", MENU_FONT_SIZE,
    MENU_FONT_SIZE, canvas);
    instructionText.setFontSize(MENU_FONT_SIZE / HALF);
    instructionText.setColor(MENU_FONT_COLOR);
    instructionText.hide();
  }

  /**
   * setUpController method, create the panel to manipulate the elements in the
   * data structure, which contains add, find, and remove buttons.
   * 
   * @author Jasper
   */
  private void setUpController() {

    // set up sout panel
    southPanel = new JPanel();
    southPanel.setBackground(Color.BLACK);
    this.add(southPanel, BorderLayout.SOUTH);

    // add text field
    addTextField = new JTextField("", TEXT_FIELD_SIZE);
    southPanel.add(addTextField);

    // add button
    addButton = new JButton("Add");
    addButton.addActionListener(this);
    southPanel.add(addButton);

    // find text field
    findTextField = new JTextField("", TEXT_FIELD_SIZE);
    southPanel.add(findTextField);

    // find button
    findButton = new JButton("Find");
    findButton.addActionListener(this);
    southPanel.add(findButton);

    // remove text field
    removeTextField = new JTextField("", TEXT_FIELD_SIZE);
    southPanel.add(removeTextField);

    // remove button
    removeButton = new JButton("Remove");
    removeButton.addActionListener(this);
    southPanel.add(removeButton);

    this.validate();
  }

  /**
   * hideMenu method, to hide the menu texts from the canvas.
   * 
   * @author Jasper
   */
  private void hideMenu() {

    // hide the texts
    selectionText.hide();
    arrayListText.hide();

    // show the instruction
    instructionText.show();

    // not on menu anymore
    onMenu = false;
  }

  /**
   * menuTextNoHover method, to set every menu text to original menu color.
   *
   * @author Jasper
   */
  private void menuTextNoHover() {

    // can use for loop

    arrayListText.setColor(MENU_FONT_COLOR);

    textHover = false;
  }

  /**
   * checkMousePosition method, to check the current position of the mouse to
   * determine if the mouse is at a particular data structure text.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   *
   * @return an int that indicates the data structure text that is being hover,
   * -1 if none.
   * 
   * @author Jasper
   */
  private int checkMousePosition(MouseEvent evt) {

    // obtain the mouse's x and y positions
    int mouseX = evt.getX();
    int mouseY = evt.getY();

    // obtain the current's text position and length, can use for loop later
    int textX = (int) arrayListText.getX();
    int textY = (int) arrayListText.getY();
    int textWidth = (int) arrayListText.getWidth();
    int textHeight = (int) arrayListText.getHeight();

    // check if the mouse is within the text box
    if (mouseX >= textX && mouseX <= textX + textWidth && mouseY >= textY &&
    mouseY <= textY + textHeight) {

      return ARRAYLIST;
    }

    // otherwise, return -1
    return -1;
  }

  /**
   * actionPerformed method, to handle event from button clicking.
   * 
   * @param ActionEvent evt - the event that is being triggered.
   * 
   * @author Jasper
   */
  public void actionPerformed(ActionEvent evt) {

    Object event = evt.getSource();

    if (event == addButton) {

      // input check

      // store int to be added

      // add the number if it's not in menu
      if (!onMenu) {

        myDS.add(Integer.parseInt(addTextField.getText()));
      }

      addTextField.setText("");
    }

    else if (event == findButton) {

      // input check

      // search the number when is not in menu
      if (!onMenu) {

        myDS.find(Integer.parseInt(findTextField.getText()));
      }

      findTextField.setText("");
    }

    else if (event == removeButton) {

      // store int to be removed
      System.out.println(removeTextField.getText());
      removeTextField.setText("");
    }
  }

  /**
   * mouseClicked method, the event when the mouse was clicked.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   * 
   * @author Jasper
   */
  public void mouseClicked(MouseEvent evt) {

    // if a data structure text is being hover, check the mouse position then
    // assign a data structure
    if (textHover) {

      switch (checkMousePosition(evt)) {

        case ARRAYLIST:
          hideMenu();
          myDS = new MyArrayList(canvas);
          break;
      }
    }
  }

  /**
   * mouseEntered method, the event when the mouse entered the canvas.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   * 
   * @author
   */
  public void mouseEntered(MouseEvent evt) {

  }

  /**
   * mouseExited method, the event when the mouse exited the canvas.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   * 
   * @author
   */
  public void mouseExited(MouseEvent evt) {

  }

  /**
   * mousePressed method, the event when the mouse was pressed.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   * 
   * @author
   */
  public void mousePressed(MouseEvent evt) {

  }

  /**
   * mouseReleased method, the event when the mouse was released.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   * 
   * @author
   */
  public void mouseReleased(MouseEvent evt) {

  }

  /**
   * mouseDragged method, the event when the mouse was dragged.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   * 
   * @author
   */
  public void mouseDragged(MouseEvent evt) {

  }

  /**
   * mouseMoved method, the event when the mouse was moved.
   * 
   * @param MouseEvent evt - the MouseEvent object that contains information
   * about the current mouse's state.
   * 
   * @author Jasper
   */
  public void mouseMoved(MouseEvent evt) {

    if (onMenu) {

      // case when text is being hover
      if (textHover) {

        // then if mouse position is -1, then reset the texts color
        if (checkMousePosition(evt) == -1) {

          menuTextNoHover();
        }
      }

      // case when text is not being hover
      else {

        switch (checkMousePosition(evt)) {

          case -1:
            break;

          case ARRAYLIST:
            arrayListText.setColor(MENU_FONT_HOVER_COLOR);
            textHover = true;
            break;
        }
      }
    }
  }

  /**
   * main method, it will be call first to create the applet window.
   * 
   * @param String args - the arguments passed in to the program.
   * 
   * @author Jasper
   */
  public static void main(String [] args) {

    new Acme.MainFrame(new MyController(), args, APPLET_WIDTH, APPLET_HEIGHT);
  }
}
