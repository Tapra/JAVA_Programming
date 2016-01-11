/**
 * 
 */
package ams.view;

import ams.control.AMSCoursePanelControl;
import ams.model.Course;
import ams.view.grid.cells.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author Darrell Thoonen.
 * @Student_Number: 3482232
 */
public class AMSCoursePanel extends JPanel 
{
   private int count = 0;
   private AMSMainWindow mainWindow;
   private AMSGridCell[] cellArray;
   private AMSCoursePanelControl control;

   public AMSCoursePanel(AMSMainWindow window)
   {
      this.mainWindow = window;
      this.control = new AMSCoursePanelControl(this);
      this.cellArray = control.getCells();
      this.setBackground(Color.WHITE);
//      this.setLayout(new GridLayout(0, 4, 10, 10));
            
//      this.add(new AMSEmptyCell());
//      this.add(new AMSCoreCourseCell("Blah"));
//      this.add(new AMSElectiveCourseCell("meh"));
   }
   
   // main window
   public AMSMainWindow getMainWindow()
   {
      return mainWindow;
   }   
   
   // pass updating the view to the controller
   public void updateView(Course[] courseList)
   {
      removeAll();
      
      if(courseList.length<4)
         this.setLayout(new GridLayout(0,courseList.length,10,10));
      else 
         this.setLayout(new GridLayout(0,4,10,10));
      
      
      int cols = 4 - ((courseList.length)%4);
//      System.out.println(courseList.length + " :cols value " + cols);
      cellArray = control.createCells(courseList);  
      for (int i=0;i<courseList.length;i++)
      {
//         cellArray[i].addActionListener(control);
         add(cellArray[i]);
         
         
         
//         if ((courseList.length % 4) != 0)
//            add(new AMSEmptyCell());
         
      }
      while ((cols) != 0)
      {
         if(courseList.length > 4)
            add(new AMSEmptyCell());
         cols--;
      }
//      while ((cols != 0)) 
//      {
//         add(new AMSEmptyCell());
//         cols--;
//      }
//      repaint();
   }
   
   public void resetCoursePanel()
   {
      removeAll();
      setBackground(Color.WHITE);
      repaint();
   }
   
   /**
    * @return
    */
   public AMSCoursePanelControl getControl()
   {
      return control;
   }
   
   public AMSGridCell[] getCellArray()
   {
      return cellArray;
   }
}
