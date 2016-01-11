
/**
 * 
 */
package ams.control;

import ams.view.grid.cells.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import ams.model.exception.*;
import ams.view.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSMouseListener implements MouseInputListener
{
   public AMSCourseCell cell;
   private AMSMainWindow mainWindow;
   private AMSHelper helper;
   
   public AMSMouseListener(AMSCourseCell cell, AMSMainWindow window)
   {
      this.cell = cell;
      this.mainWindow = window;
      this.helper = new AMSHelper(this, window.getAC());
   }
   
   public AMSCourseCell getCell(AMSCourseCell cell)
   {
      return cell;
   }
   
   public void removeCourse(String code)
   {
      String message = "Confirm delete of " + cell.getName()+ "?";
      int confirm = JOptionPane.showConfirmDialog(null, message);
      if (confirm == JOptionPane.YES_OPTION)
      {
         try
         {
            helper.removeCourse(code);
            mainWindow.updateView(mainWindow.getAC().getAllCourses());
            mainWindow.updateCount();
            mainWindow.callInfoBox(cell.getName() + " has be removed.");
         }
         catch(ProgramException pe)
         {}
         
      }
      else if(confirm == JOptionPane.NO_OPTION)
      {
         mainWindow.callInfoBox(cell.getName() + " has NOT be removed.");
      }
      else
      {
         mainWindow.callInfoBox("Operation aborted.");
      }
   }
            
            

   /* (non-Javadoc)
    * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseClicked(MouseEvent arg0)
   {
      
      String code = cell.getCode();
//      System.out.println(code);
      removeCourse(code);
//      getCell(cell);
   }

   /* (non-Javadoc)
    * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseEntered(MouseEvent arg0)
   {

      cell.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
   }

   /* (non-Javadoc)
    * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseExited(MouseEvent arg0)
   {
      String type = cell.getClass().getSimpleName();
      if(type.equals("AMSCoreCourseCell"))
         cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
      else if(type.equals("AMSElectiveCourseCell"))
         cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
   }

   /* (non-Javadoc)
    * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
    */
   @Override
   public void mousePressed(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseReleased(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseDragged(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseMoved(MouseEvent arg0)
   {
      // TODO Auto-generated method stub

   }

}
