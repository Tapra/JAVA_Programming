
/**
 * 
 */
package ams.view.grid.cells;

import javax.swing.*;
import java.awt.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 * 
 * look and feel for all course cells
 */
public abstract class AMSGridCell extends JPanel
{
   
   public AMSGridCell()
   {
      this.setSize(getMaximumSize());
      setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
   }
}
