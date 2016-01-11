
/**
 * 
 */
package ams.view;

import ams.control.AMSToolBarControl;
import ams.control.AMSComboBoxListener;
import javax.swing.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSToolBar extends JPanel
{
//   public static final String PROGRAM = "PROGRAM";
   public static final String ADD_COURSE = "ADD COURSE";
   public static final String REMOVE_COURSE = "REMOVE COURSE";
   public static final String TEST = "ADD TEST COURSES";
   public static final String RESET = "RESET PROGRAM";
   public static final String MODE0 = "Default";
   public static final String MODE1 = "Title";
   public static final String MODE2 = "Type";
   public static final String[] MODES = {"Default","Title","Type"};
   
   private AMSMainWindow mainWindow;
   private AMSToolBarControl control;
   private JButton addCourse, removeCourse, test, reset;
   private JComboBox<String> sorting;
   
   private AMSComboBoxListener comboControl;
   
   public AMSToolBar(AMSMainWindow window)
   {
      this.mainWindow = window;
      this.control = new AMSToolBarControl(this);
      comboControl = new AMSComboBoxListener(this, window);
      sorting = new JComboBox<String>(MODES);
      // create the buttons for each instance.
      
      addCourse = new JButton(ADD_COURSE);
      removeCourse = new JButton(REMOVE_COURSE);
      test = new JButton(TEST);
      reset = new JButton(RESET);
      
//      program.setActionCommand(PROGRAM);
//      program.addActionListener(control);
//      this.add(program);
      
      addCourse.setActionCommand(ADD_COURSE);
      addCourse.addActionListener(control);
      this.add(addCourse);
      
      removeCourse.setActionCommand(REMOVE_COURSE);
      removeCourse.addActionListener(control);
      this.add(removeCourse);
      
      test.setActionCommand(TEST);
      test.addActionListener(control);
      this.add(test);
      
      reset.setActionCommand(RESET);
      reset.addActionListener(control);
      this.add(reset);
      
      this.add(new JLabel("Sorting type :"));
      sorting.addItemListener(comboControl);
      this.add(sorting);
   }
   
   public AMSMainWindow getMainWindow()
   {
      return mainWindow;
   }
   public AMSComboBoxListener getListener()
   {
      return comboControl;
   }
}
