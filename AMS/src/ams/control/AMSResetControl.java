
/**
 * 
 */
package ams.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ams.view.*;
import ams.view.dialog.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSResetControl implements ActionListener
{
   
   private AMSMainWindow mainWindow;
   private AMSResetBox dialog;
   
   public AMSResetControl(AMSResetBox dialog, AMSMainWindow window)
   {
      this.mainWindow = window;
      this.dialog = dialog;
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent arg0)
   {
      JButton invoked = (JButton)arg0.getSource();
      if(invoked.getActionCommand().equals(dialog.CANCEL))
      {
         dialog.dispose();
      }
      else
      {
         mainWindow.getAC().resetCourses();
         dialog.dispose();
      }
   }
   
   public boolean processResponse()
   {
      return false;
   }
}
