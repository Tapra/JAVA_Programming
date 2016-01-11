
/**
 * This is the Remove course controller class
 */
package ams.control;

import ams.model.exception.ProgramException;
import ams.view.dialog.AMSRemoveCourseDialog;
import ams.view.*;
import ams.model.Course;
import ams.view.grid.cells.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */
public class AMSRemoveCourseControl implements ActionListener
{
   private AMSRemoveCourseDialog dialog;
   private AMSHelper helper;
   private AMSMainWindow mainWindow;
   private AMSApplicationControl appControl;
   private AMSGridCell cell;
   
   public AMSRemoveCourseControl(AMSRemoveCourseDialog dialog, AMSMainWindow window)
   {
      this.dialog = dialog;
      this.mainWindow = window;
      this.appControl = window.getAC();
      this.helper = new AMSHelper(this, appControl);
   }
   
   public AMSRemoveCourseControl(AMSCourseCell cell, AMSMainWindow window)
   {
      this.cell = cell;
      this.mainWindow = window;
      this.appControl = window.getAC();
      this.helper = new AMSHelper(this,appControl);
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent event)
   {
      String selected = "Hoo Bum";
      boolean success = false;

      try
      {
         selected = dialog.getListener().getSelected();
         String code = selected.substring(0,8);
//         System.out.println(code);
//         Course course = mainWindow.getAC().getCourse(selected);
         removeCourse(code);
         success = true;
//         mainWindow.callInfoBox(selected + " has be removed successfully.");

      }
      catch(ProgramException pe)
      {
         mainWindow.callInfoBox(selected + " can not be removed.");
      }
      catch(NullPointerException npe)
      {
         mainWindow.callInfoBox("Please reset program to remove last course");
      }
      if (success)
      {
         String message = selected + " has been removed from the program.";
         mainWindow.updateView(mainWindow.getAC().getAllCourses());
         mainWindow.callInfoBox(message);
         mainWindow.updateCount();
         dialog.dispose();
      }      
   }
   
   public void removeCourse(String courseCode) throws ProgramException
   {
//      try
//      {
         helper.removeCourse(courseCode);

//      }
//      catch(ProgramException pe)
//      {
//         mainWindow.callInfoBox(courseCode + " can not be removed.");
//      }      
   }
}
