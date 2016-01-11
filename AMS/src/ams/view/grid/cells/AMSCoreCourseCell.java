
/**
 * 
 */
package ams.view.grid.cells;

import javax.swing.*;
import java.awt.*;
import ams.view.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSCoreCourseCell extends AMSCourseCell
{

   /**
    * @param courseInfo
    */
   public AMSCoreCourseCell(String courseInfo, AMSMainWindow window)
   {
      super(courseInfo, window);
      setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
//      setBackground(Color.WHITE);
   }
}
