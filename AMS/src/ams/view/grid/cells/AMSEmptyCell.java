
/**
 * this will create an empty cell for the program map
 */
package ams.view.grid.cells;

import java.awt.Color;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

public class AMSEmptyCell extends AMSGridCell
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   public AMSEmptyCell()
   {
      this.setBorder(null);
      this.setBackground(Color.WHITE);
   }
}
