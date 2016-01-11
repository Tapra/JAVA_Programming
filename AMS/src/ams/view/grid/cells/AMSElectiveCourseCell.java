
/**
 * 
 */
package ams.view.grid.cells;

import java.awt.Color;
import ams.view.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSElectiveCourseCell extends AMSCourseCell
{
   
   // set background if needed
   // set different borders

   /**
    * @param courseInfo
    */
   public AMSElectiveCourseCell(String courseInfo, AMSMainWindow window)
   {
      super(courseInfo, window);
//      this.setBackground(Color.WHITE);
      setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    
   }
}
