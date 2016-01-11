
/**
 * 
 */
package ams.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

@SuppressWarnings("serial")

public class AMSStatusBar extends JPanel
{
   private AMSMainWindow mainWindow;
//   private String status ;
   private JLabel statusLabel = new JLabel();
   private JLabel title1 = new JLabel("Core course count: ");
   private JLabel title2 = new JLabel("Elective course count: ");
   private JLabel count1 = new JLabel("0");
   private JLabel count2 = new JLabel("0");
      
   public AMSStatusBar(AMSMainWindow window)
   {
      this.mainWindow = window;
//      this.setBackground(Color.LIGHT_GRAY);
      this.setLayout(new FlowLayout(FlowLayout.LEADING));
      add(statusLabel);
      this.add(Box.createHorizontalStrut(100));
      this.add(title1);
      add(count1);
      this.add(title2);
      add(count2);
   }
   
   public void updateLabel(String labelText)
   {
      statusLabel.setText("Program: " + labelText);
   }
   
   public void updateCoreCount()
   {
      int temp = mainWindow.getAC().getModel().countCoreCourses();
      String tempString = Integer.toString(temp);
      count1.setText(tempString);
   }
   
   public void updateElectiveCount()
   {
      int temp = mainWindow.getAC().getModel().countElectiveCourses();
      String tempString = Integer.toString(temp);
      count2.setText(tempString);
   }
}
