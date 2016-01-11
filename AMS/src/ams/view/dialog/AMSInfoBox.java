
/**
 * This will display error messages in a
 * message dialog box.
 */
package ams.view.dialog;

import javax.swing.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

@SuppressWarnings("serial")
public class AMSInfoBox extends JOptionPane
{  
   public AMSInfoBox(String message)
   {
      showMessageDialog(null, message);
   }
}
