
/**
 * 
 */
package ams.control;

import java.awt.event.*;

import javax.swing.*;

import ams.model.Course;
import ams.view.AMSMainWindow;
import ams.view.dialog.AMSAddCourseDialog;
import ams.model.exception.ProgramException;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSAddCourseControl implements ActionListener
{
   private AMSAddCourseDialog dialog;
   private AMSHelper helper;
   private AMSMainWindow mainWindow;
   private AMSApplicationControl appControl;
   
   public AMSAddCourseControl(AMSAddCourseDialog dialog, AMSMainWindow window)
   {
      this.mainWindow = window;
      this.dialog = dialog;
      this.appControl = window.getAC();
      this.helper = new AMSHelper(this, appControl);
      
      
   }
   
   public AMSMainWindow getMainWindow()
   {
      return mainWindow;
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent event)
   {
      
      try
      {
         int credit = 12;
         JButton confirm = (JButton)event.getSource();
         if (confirm.getActionCommand().equals("ok"))
         {
            String[] preReqs;
            // get the course code
            String courseCode = dialog.getJtf1().getText();
            
            // get the course name. 
            String courseName = dialog.getJtf2().getText();
            
//            // So validation is not required
//            // the first letter will be converted into a capital.
//            String subString = courseName.substring(1);
//            String capitals = courseName.toUpperCase();
//            char begin = capitals.charAt(0);
//            courseName = begin + subString;
            
            // get pre-requisite courses
            if (dialog.getPreReqs() != null)
            {
               preReqs = new String[dialog.getPreReqs().length];
//               for (int i=0;i<preReqs.length;i++)
//               {
//                  Course[] courseList = mainWindow.getAC().getAllCourses();
                  preReqs = dialog.getPreReqs();
//               }
            }
            else
            {
               preReqs = null;
            }
            
            // Get if the course is elective or not.
            boolean isElective = dialog.elective();
            
            // Validation for course code.
            if(validateCourse(courseCode))
            {
            // So validation is not required
               // the first letter will be converted into a capital.
               String subString = courseName.substring(1);
               String capitals = courseName.toUpperCase();
               char begin = capitals.charAt(0);
               courseName = begin + subString;
               // Check if entry is elective or core
               if (isElective)
               {
                  boolean cc = dialog.getCourseCredit();
                  // Check the text on the course credit
                  // toggle button
                  if (cc)
                  {
                     credit = 6;
                  }
               }
//               System.out.println("Add a course to program");
               addCourse(courseCode, courseName, preReqs, isElective);
               mainWindow.getCoursePanel().getControl().createCells(mainWindow.getAC().getAllCourses());
               
//               System.out.println(courseCode + " " + courseName + ", elective: " + isElective + " Course Credit: " + credit);
//               System.out.println(preReqs);
               
               // Update status bar
               mainWindow.updateLabel(mainWindow.getAC().getProgram());
               mainWindow.updateView(mainWindow.getAC().getAllCourses());
//               mainWindow.updateCount();
               
               // Close dialog box
               dialog.dispose();
            }
            else
            {
               throw new ProgramException();
            }
         }
      }
      // Catch a class cast exception
      catch(ClassCastException cce)
      {
         /**
          * this may not be the best way to do this but
          * what I have done is: When a class cast exception
          * is thrown because JToggleButton is a different
          * class to JButton the exception is thrown. This
          * catch block will actually change the text on the
          * toggle buttons to reflect core & elective courses
          * and toggle between 6 & 12(default value).
          */
         if (dialog.getCourseCredit() && dialog.elective())
         {
            dialog.selectCC();
         }
         else
         {
            dialog.deSelectCC();
         }
         
         if (dialog.elective())
         {
            dialog.electiveCourse();
         }
         else
         {
            dialog.coreCourse();
            dialog.deSelectCC();
         }
      }
      // Catch a program exception
      catch(ProgramException pe)
      {
//         mainWindow.callInfoBox("Course code length must be 8 Characters");
         mainWindow.callInfoBox("Check course entry.");
      }
   }
      
   /**
    *  Helper method to add a course to the program
    *  
    * @param courseCode:String
    * @param courseName:String
    * @param preReqs:String[]
    * @param isElective:boolean
    * @throws ProgramException
    */
   public void addCourse(String courseCode, String courseName,
                         String[] preReqs, boolean isElective)
                                  throws ProgramException
   {
      int credit = 12;      
      if (dialog.elective())
      {
         if (dialog.getCourseCredit())
         {
            credit = 6;
         }         
      }
      helper.addCourse(courseCode, courseName, preReqs, isElective, credit);
      
      /**
       *  Display a confirmation dialog box
       */
      String message =  courseCode + ", " + courseName + 
               "\nhas been added to\nthe program: " + mainWindow.getAC().getProgram();
      mainWindow.updateCount();
      mainWindow.callInfoBox(message);
      
      //DEBUG console output of pre-req array
      String[] list = mainWindow.getAC().getModel().getCourse(courseCode).getPreReqs();
      if (list != null)
         for (int i=0;i<list.length;i++)
            System.out.println(list[i].toString());
      else
         System.out.println("No pre Reqs");
      //---
   }
   
   /**
    * Course validation method
    * @param courseCode:String
    * @return isValid:boolean  This variable is created on the fly
    */
   public boolean validateCourse(String courseCode)
   {
      if (courseCode.length() != 8)
         return false;      
      else 
         return true;
   }
}
