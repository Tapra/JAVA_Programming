
/**
 * This class is the main frame that
 * makes up the UI window for the 
 * Academic Management System.
 */
package ams.view;

import javax.swing.*;

import java.awt.*;
import ams.control.AMSApplicationControl;
import ams.model.Course;
import ams.test.*;
import ams.view.dialog.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

@SuppressWarnings("serial")
public class AMSMainWindow extends JFrame
{
   private JMenuBar menuBar = new AMSMenuBar(this);
   private AMSToolBar toolBar = new AMSToolBar(this);
   private AMSCoursePanel coursePanel = new AMSCoursePanel(this);
   private AMSStatusBar statusBar;
   private AMSApplicationControl control;
   
   public AMSMainWindow(AMSApplicationControl control)
   {
      // set up the controller
      this.control = control;
      this.statusBar = new AMSStatusBar(this);
      
      
      this.setJMenuBar(menuBar);
      this.setTitle("Assignment 2 - AMS");
      this.setSize(800,600);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setResizable(true);
      this.setLayout(new BorderLayout());
      this.add(toolBar, BorderLayout.NORTH);
      this.add(coursePanel, BorderLayout.CENTER);
      this.add(statusBar, BorderLayout.SOUTH);
//      System.out.println("Program NOT Present");
      updateLabel("None.");
      validate();
   }
   
   /**
    * Access to the main window
    * @return mainWindow:AMSMainWindow
    */
   public AMSMainWindow getMainWindow()
   {
      return this;
   }
   
   /**
    * Access to the app controller
    * @return control:AMSApplicationControl
    */
   public AMSApplicationControl getAC()
   {
      return control;
   }
   
   /**
    * Access to the tool bar
    * @return toolBar:AMSToolBar
    */
   public AMSToolBar getToolBar()
   {
      return toolBar;
   }
   
   /**
    * Access to the course panel
    * @return coursePanel:AMSCoursePanel
    */
   public AMSCoursePanel getCoursePanel()
   {
      return coursePanel;
   }
   
   /**
    * Update status label
    * @param status:String
    */
   public void updateLabel(String status)
   {
      statusBar.updateLabel(status);
   }
   
   /**
    * Update course counts
    */
   public void updateCount()
   {
      statusBar.updateCoreCount();
      statusBar.updateElectiveCount();
   }
   
   /**
    * Update course panel
    * @param cells
    */
   public void updateView(Course[] courseList)
   {
      coursePanel.updateView(courseList);
      validate();
   }
      
   /**
    * Calls add program dialog
    */
   public void callAddProgramDialog()
   {
      AMSAddProgramDialog dialog = new AMSAddProgramDialog(this);
   }

   /**
    * Calls add course dialog
    */
   public void callAddCourseDialog()
   {
      AMSAddCourseDialog dialog = new AMSAddCourseDialog(this);
      dialog.setVisible(true);
   }

   /**
    * Calls remove course dialog
    */
   public void callRemoveCourseDialog()
   {
      AMSRemoveCourseDialog dialog = new AMSRemoveCourseDialog(this);
   }
   
   /**
    * Calls an info box
    * @param message:String
    */
   public void callInfoBox(String message)
   {
      AMSInfoBox infoBox = new AMSInfoBox(message);
//      error.setVisible(true);
   }

   /**
    * Adds test course to the model
    */
   public void addTestCourses()
   {
      Tester test = new Tester(getAC().getModel());
      test.addCourses();
      updateCount();
      updateView(control.getAllCourses());
      callInfoBox("Test Courses add to program " + control.getProgram());
   }

   /**
    * 
    */
   public void callResetBox()
   {
      AMSResetBox confirm = new AMSResetBox("Confirm Reset?", this);
   }
}
