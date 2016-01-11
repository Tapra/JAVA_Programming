
/**
 * 
 */
package ams.view.dialog;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ams.control.AMSComboBoxListener;
import ams.control.AMSRemoveCourseControl;
import ams.model.Course;
import ams.view.*;
import ams.model.exception.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSRemoveCourseDialog extends JFrame
{
   private JComboBox<Course> courseList;// = new JComboBox<JMenuItem>();
   private Course[] currentCourseList;// = new String[5];// = new ArrayList<String>();
   private JButton ok = new JButton("OK");
   private AMSRemoveCourseControl controller;
   private AMSMainWindow mainWindow;
   private String selectedCourse;
   private AMSComboBoxListener listener;
//   private AMSListListener listener;
   private Object[] selected;
   private JLabel label = new JLabel("Remove which course(s)");
   
   /**
    * Remove course dialog box constructor
    * @param window:AMSMainWindow
    */
   
   public AMSRemoveCourseDialog(AMSMainWindow window)
   {
      super("Remove Course");
      this.mainWindow = window;
      this.controller = new AMSRemoveCourseControl(this, window);
      this.currentCourseList = window.getAC().getAllCourses();
      this.listener = new AMSComboBoxListener(this, window);
//      this.listener = new AMSListListener(this);
      JPanel RCPanel = new JPanel();
      //debug courses
//      currentCourseList[0] = ("CPT123");
//      currentCourseList[1] = ("CPT124");
//      currentCourseList[2] = ("CPT125");
//      currentCourseList[3] = ("CPT126");
//      currentCourseList[4] = ("CPT127");
      try
      {
         if (currentCourseList.length != 0)
         {
            courseList = new JComboBox<>(currentCourseList);
            this.setSize(250,50);
//            this.setSize(getPreferredSize());
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            this.setLocationRelativeTo(null);
            
            RCPanel.setBackground(Color.LIGHT_GRAY);
            RCPanel.setLayout(new FlowLayout());
            RCPanel.add(label);
            RCPanel.add(courseList);
//            courseList.addActionListener(controller);
            courseList.setSelectedIndex(0);
            courseList.addItemListener(listener);
            courseList.setEditable(false);
//            System.out.println(selected.toString());
//            System.out.println(getSelected().toString());
//            selected = courseList.getSelectedObjects();
               
                                                 
            RCPanel.add(ok);
                        

            ok.addActionListener(controller);
            ok.setActionCommand("ok");
            
            this.add(RCPanel);
//            this.validate();
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
         }
         else
         {
            throw new ProgramException();
         }
      }
      catch (ProgramException pe)
      {
         mainWindow.callInfoBox("No Courses Found");
      }
   }

   /**
    * this will pass the selected course to the
    * controller.
    * @return selectedCourse:String
    */
   public String getSelectedCourse()
   {
      Course course = (Course) courseList.getSelectedItem();
      String item = course.getTitle();
//      System.out.println(item);
      return item;
   }
   
   public AMSMainWindow getMainWindow()
   {
      return mainWindow;
   }
   
   public String[] getSelected()
   {
      String[] items = new String[selected.length];
      for(int i=0;i<selected.length;i++)
      {
         items[i] = (String) selected[i];
      }
      return items;
   }
   
   public AMSComboBoxListener getListener()
   {
      return listener;
   }

   /**
    * returns the course list
    * @return currentCourseList:String[]
    */
   public JComboBox<Course> getCourseList()
   {
      return courseList;
   }
}
