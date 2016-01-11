
/**
 * 
 */
package ams.control;

import ams.view.*;
import ams.view.grid.cells.*;
import ams.model.*;

import java.awt.event.*;
import java.awt.Color;
import java.util.Arrays;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSCoursePanelControl //implements ActionListener
{
   protected AMSCoursePanel panel;
   protected AMSMainWindow mainWindow;
   protected AMSGridCell[] cellArray;
   
   public AMSCoursePanelControl(AMSCoursePanel panel)
   {
      this.panel = panel;
      this.mainWindow = panel.getMainWindow();
      cellArray = new AMSCourseCell[30];
   }
   
   public AMSCoursePanelControl getControl()
   {
      return this;
   }
   
   
   public AMSGridCell[] getCells()
   {
      return cellArray;
   }
   
   public AMSGridCell[] createCells(Course[] courseList)
   {
      cellArray = new AMSCourseCell[courseList.length];
      if (courseList != null)
      {
         for (int i=0;i<courseList.length;i++)
         {
            if (courseList[i].getClass().getSimpleName().equals("ElectiveCourse"))
            {
               cellArray[i] = new AMSElectiveCourseCell(courseList[i].toString(), mainWindow);
            }
            else
            {
               cellArray[i] = new AMSCoreCourseCell(courseList[i].toString(), mainWindow);
            }
         }
      }
      return cellArray;
   }
   
   public void updateView(Course[] courseList)
   {
      panel.removeAll();
      
      if (courseList != null)
      {
         System.out.println(courseList.toString());
         createCells(courseList);
         panel.revalidate();
         panel.repaint();
      }
      else
      {
         panel.removeAll();
      }
   }
   
   public void sortByType()
   {
      // sort by class
      
      Course[] origCourseList = mainWindow.getAC().getAllCourses();
      String[] courseList = new String[origCourseList.length];
      String[] sortedList = new String[origCourseList.length];
      Course[] tempArray = new Course[origCourseList.length];
      for (int i=0;i<origCourseList.length;i++)
      {
         courseList[i] =  origCourseList[i].getClass().getSimpleName() + " ; " + origCourseList[i].getCode();
      }
      Arrays.sort(courseList);
//      Arrays.sort(courseList);
      for(int i=0;i<courseList.length;i++)
      {
//         System.out.println(courseList[i]);
            
         String courseCode = courseList[i].substring(courseList[i].length()-8);
//         System.out.println(courseCode);
         tempArray[i] = mainWindow.getAC().getModel().getCourse(courseCode);
      }
      panel.updateView(tempArray);
      panel.revalidate();
      panel.repaint();
   }
   
   public void sortByTitle()
   {
      Course[] origCourseList = mainWindow.getAC().getAllCourses();
      String[] courseList = new String[origCourseList.length];
      Course[] tempArray = new Course[origCourseList.length];
      
      
      for (int i=0;i<origCourseList.length;i++)
      {
         courseList[i] = origCourseList[i].toString();
      }
      
      Arrays.sort(courseList);
      
      for(int i=0;i<courseList.length;i++)
      {
         String courseCode = courseList[i].substring(0,8);
         tempArray[i] = mainWindow.getAC().getModel().getCourse(courseCode);
      }
      
      // panel operations
      panel.updateView(tempArray);
      panel.revalidate();
      panel.repaint();
   }

//   /* (non-Javadoc)
//    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
//    */
//   @Override
//   public void actionPerformed(ActionEvent arg0)
//   {
//      System.out.println("cell clicked");
//   }
}
