
/**
 * 
 */
package ams.view.grid.cells;

import java.awt.Color;

import javax.swing.*;
import ams.control.AMSMouseListener;
import ams.view.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public abstract class AMSCourseCell extends AMSGridCell
{
   protected String courseInfo;
   private AMSMouseListener mouse;
   private String[] tokens;
   private String code, name;
//   private
   
   public AMSCourseCell(String courseInfo, AMSMainWindow window)
   {
//      this.setAlignmentX(CENTER_ALIGNMENT);
//      this.mainWindow = window;
      this.mouse = new AMSMouseListener(this, window);
      tokens = courseInfo.split(":");
//      System.out.println(tokens);
      code = tokens[0];
      name = tokens[1];
      this.courseInfo = courseInfo;
      this.setBackground(Color.GRAY);
      this.addMouseListener(mouse);
      addLabel();
//      JScrollPane pane = new JScrollPane();
//      JTextArea textArea = new JTextArea();
//      pane.add(textArea);
//      this.add(pane);
//      for (int i=0;i<tokens.length;i++)
//      {
//         JLabel[] text = new JLabel[tokens.length];
//         text[i] = new JLabel(tokens[i]);
//         add(text[i]);
//      }
  
      validate();
//      this.add(new JLabel(tokens));
      // attach a mouse listener :done
   }

   // METHOD/s for diaplaying "Course info"
   
   public void addLabel()
   {
      for (int i=0;i<tokens.length;i++)
      {
         JLabel[] text = new JLabel[tokens.length];
         text[i] = new JLabel(tokens[i]);
         add(Box.createGlue());
         add(text[i]);
         add(Box.createGlue());
      }
   }
   
   public String getCode()
   {
      return code;
   }
   
   public String getName()
   {
      return name;
   }
   
   public AMSCourseCell viewCell(String courseInfo)
   {
      return this;
   }
}
