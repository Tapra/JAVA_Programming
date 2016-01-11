
/**
 * This is the controller for the toolbar.
 */
package ams.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ams.view.AMSToolBar;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

public class AMSToolBarControl implements ActionListener
{
   private AMSToolBar toolBar;
   
   public AMSToolBarControl(AMSToolBar toolBar)
   {
      this.toolBar = toolBar;
   }
   
   public AMSToolBar getToolBar()
   {
      return toolBar;
   }

   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent arg0)
   {
      
      JButton invoked = (JButton)arg0.getSource();

      switch(invoked.getActionCommand())
      {
         case(AMSToolBar.ADD_COURSE):
         {
//            System.out.println("in add course");
            toolBar.getMainWindow().callAddCourseDialog();
            break;
         }
         case(AMSToolBar.REMOVE_COURSE):
         {
//            System.out.println("in remove course");
            if (toolBar.getMainWindow().getAC().getAllCourses() != null)
            {
               toolBar.getMainWindow().callRemoveCourseDialog();
            }
            else
            {
               toolBar.getMainWindow().callInfoBox("No Courses Found.");
            }
            break;
         }
         case(AMSToolBar.TEST):
         {
//            System.out.println("Creating test courses");
            toolBar.getMainWindow().addTestCourses();
            break;
         }
         case(AMSToolBar.RESET):
         {
//            System.out.println("resetting courses");
            toolBar.getMainWindow().callResetBox();
            toolBar.getMainWindow().updateCount();
            break;
         }
      }
   }
}
