
/**
 * Testing harness for the UI.
 */
package ams.test;

import ams.control.AMSApplicationControl;
import ams.model.exception.ProgramException;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSMain
{

   /**
    * Main method for the test driver class
    * @param args
    */
   public static void main(String[] args)
   {
      AMSApplicationControl programControl = new AMSApplicationControl();
      programControl.initialiseEngine();
   }
}
