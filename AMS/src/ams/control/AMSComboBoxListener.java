
/**
 * 
 */
package ams.control;

import java.awt.event.*;
import javax.swing.*;
import ams.view.*;
import ams.view.dialog.*;
import ams.model.exception.*;
import ams.model.Course;
/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */
public class AMSComboBoxListener implements ItemListener
{
   private AMSMainWindow mainWindow;
//   private AMSCoursePanelControl coursePanel;
   private AMSRemoveCourseDialog dialog;
   private AMSToolBar toolBar;
   protected Object selected;
   
   public AMSComboBoxListener(AMSRemoveCourseDialog dialog, AMSMainWindow window)
   {
      this.dialog = dialog;
      this.mainWindow = window;
   }
   
   public AMSComboBoxListener(AMSToolBar toolbar, AMSMainWindow window)
   {
      this.toolBar = toolbar;
      this.mainWindow = window;
//      this.coursePanel = window.getCoursePanel().getControl();
   }

   /* (non-Javadoc)
    * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
    */
   @Override
   public void itemStateChanged(ItemEvent event)
   {
      if(mainWindow.getAC().getAllCourses() != null)
      {
         try
         {
            selected = event.getItem();
            //DEBUG
      //      System.out.println("Break");
      //      System.out.println(selected.toString());
      //      System.out.println(event.getStateChange());
            int state = event.getStateChange();
            if (state == ItemEvent.SELECTED);
            {
      //         System.out.println(selected + " is selected");
               getSelected();
            }
            
            if(selected.equals("Type"))
            {
               toolBar.getMainWindow().getCoursePanel().getControl().sortByType();
            }
            else if(selected.equals("Title"))
            {
               toolBar.getMainWindow().getCoursePanel().getControl().sortByTitle();
            }
            else if(selected.equals("Default"))
            {
               Course[] courseList = mainWindow.getAC().getAllCourses();
               mainWindow.getCoursePanel().updateView(courseList);
      //         coursePanel.
            }
         }
         catch(ClassCastException cce)
         {
            getSelected();
         }
      }
//      else
//      {}
   }
   
   public String getSelected()
   {
      String selectedCourse = selected.toString();
      return selectedCourse;
   }
}
