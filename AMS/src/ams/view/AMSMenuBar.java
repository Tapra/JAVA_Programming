
/**
 * 
 */
package ams.view;

import javax.swing.*;

import java.awt.event.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSMenuBar extends JMenuBar implements ActionListener
{
   private AMSMainWindow mainWindow;
   
   // set the menu items
   public static final JMenuItem RESET = new JMenuItem("Reset Program");
   public static final JMenuItem ADD_COURSE = new JMenuItem("Add Course");
   public static final JMenuItem REMOVE_COURSE = new JMenuItem("Remove Course");
   public static final JMenuItem TEST = new JMenuItem("Test Courses");
   
   // set up the menus
   private JMenu program = new JMenu("Program");
   private JMenu course = new JMenu("Course");
   private JMenu student = new JMenu("Student");
   private JMenu help = new JMenu("Help");
   
   public AMSMenuBar(AMSMainWindow window)
   {
      this.mainWindow = window;
      // set up the menu bar
      // add "reset" to the program menu
      program.add(RESET);
      RESET.setActionCommand("RESET");
      RESET.addActionListener(this);
      // add "add course" to the course menu
      course.add(ADD_COURSE);
      ADD_COURSE.setActionCommand("ADD");
      ADD_COURSE.addActionListener(this);
      // add "remove course" to the course menu
      course.add(REMOVE_COURSE);
      REMOVE_COURSE.setActionCommand("REMOVE");
      REMOVE_COURSE.addActionListener(this);
      // add "test courses" to the course menu
      course.add(TEST);
      TEST.setActionCommand("TEST");
      TEST.addActionListener(this);
      
      // add the menus to the AMSMenuBar
      this.add(program);
      this.add(course);
      this.add(student);
      this.add(help);
   }

   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent action)
   {
      JMenuItem selected = (JMenuItem)action.getSource();
      
      switch(selected.getActionCommand())
      {
         // program -> reset fired
         case("RESET"):
         {
//            System.out.println("Reset Fired");
            mainWindow.callResetBox();
            break;
         }
         // course -> add course
         case("ADD"):
         {
//            System.out.println("Add Course Fired");
            mainWindow.callAddCourseDialog();
            break;
         }
         // course -> remove course
         case("REMOVE"):
         {
//            System.out.println("Remove Course Fired");
            if (mainWindow.getAC().getAllCourses() != null)
            {
               mainWindow.callRemoveCourseDialog();
            }
            else
            {
               mainWindow.callInfoBox("No Courses Found.");
            }
            break;
         }
         // course -> test courses
         case("TEST"):
         {
//            System.out.println("Test courses Fired");
            mainWindow.addTestCourses();
            break;
         }
      }
   }
}
