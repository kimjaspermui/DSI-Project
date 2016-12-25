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

/**
 * This class contains the instructions to create the Graphical User Interface
 * layout for the menu and controller.
 */
public class MyController extends WindowController implements ActionListener {
// implements MouseListener

  private static final int HALF = 2;

  // applet size
  private static final int APPLET_WIDTH = 1275;
  private static final int APPLET_HEIGHT = 730;

  // menu texts specifications
  private static final Color MENU_FONT_COLOR = Color.BLACK;
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

  private MyDataStructure myDS;

  /**
   * begin method, where everything starts
   * 
   * @author Jasper
   */
  public void begin() {

    setUpMenu();

    setUpController();

    // wait for user's selection of data structure in a loop

    // hide main menu using a helper method

    // the rest is mouse events
  }

  /**
   * setUpMenu method, to display the initial data structure selection.
   * 
   * @author Jasper
   */
  private void setUpMenu() {

    // the menu instruction for selecting data structure
    selectionText = new Text("Please choose a data structure:", 0, 0, canvas);
    selectionText.setFontSize(MENU_FONT_SIZE);

    // data structures selection text
    arrayListText = new Text("Array List", 0, selectionText.getY() +
    MENU_FONT_SIZE + Y_GAP, canvas);

    // Text objects can be put into a linkedlist, so this set up can be done in
    // a for loop
    arrayListText.setFontSize(MENU_FONT_SIZE);
    arrayListText.setColor(MENU_FONT_COLOR);

    // create the instruction text
    instructionText = new Text("Please enter value between 0 to 999 then press "
    + "corresponding button to add, find, or remove", 0, MENU_FONT_SIZE,
    canvas);
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

      // store int to be added
      System.out.println(addTextField.getText());
      addTextField.setText("");

      hideMenu();
      myDS = new MyArrayList(canvas);
    }

    else if (event == findButton) {

      // store int to be searched
      System.out.println(findTextField.getText());
      findTextField.setText("");
    }

    else if (event == removeButton) {

      // store int to be removed
      System.out.println(removeTextField.getText());
      removeTextField.setText("");
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
