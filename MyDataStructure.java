/**
 * Name:            Kim Jasper Mui, Erick Soto, Tiffany Pan
 * Date:            Dec 24 2016
 * Filename:        MyDataStructure.java
 * Description:     This file contains the requirements for the data structures
 *                  interface.
 * Sources of help: None.
 */

/**
 * This interface contains the methods required to define a Data Structure.
 */
public interface MyDataStructure {

  /**
   * add method, to insert the passed in value to the data structure.
   * 
   * @param int number - the value to be added in the data structre.
   * 
   * @return a boolean to indicate whether or not the value has been
   * successfully inserted to the data structure.
   */
  public boolean add(int number);

  /**
   * find method, to search the passed in value in the data structure.
   * 
   * @param int number - the value to look for in the data structure.
   * 
   * @return a boolean to indicate whether or not the value has been
   * successfully found in the data structure.
   */
  public boolean find(int number);

  /**
   * remove method, to remove the passed in value from the data structure.
   * 
   * @param int number - the value to be removed from the data structure.
   * 
   * @return a boolean to indicate whether or not the value has been
   * successfully removed from the data structure.
   */
  public boolean remove(int number);
}
