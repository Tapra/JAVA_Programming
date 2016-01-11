
/**
 * This class is the interaction point between
 * the UI and the model.
 */
package ams.control;

import ams.model.*;
import ams.model.facade.*;
import ams.model.exception.*;
import ams.view.*;
import ams.view.dialog.*;

import java.awt.Component;
import java.util.*;

import javax.swing.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

public class AMSApplicationControl
{
   public static final String PROGRAM = "PROGRAM";
   public static final String ADD_COURSE = "ADD COURSE";
   public static final String REMOVE_COURSE = "REMOVE COURSE";
   public static final String RESET = "RESET COURSES";
   private AMSModel model;
   private AMSMainWindow mainWindow;
   private Program program;
   private Course course;
   private Student student = new UGStudent(3482232, "Darrell Thoonen");
   
   public AMSApplicationControl()
   {}
   
   public AMSApplicationControl(AMSModel model)
   {
      this.model = model;
   }
   
   public Course[] getAllCourses()
   {
//      Course[] courseArray = model.getAllCourses();
//      Course[] courseArray = model.getAllCourses();
//      String[] courseList; 
//      if (courseArray != null)
//      {
//         courseList = new String[model.getAllCourses().length];
//      
//         for (int i=0; i<courseList.length; i++)
//         {
//            String temp = model.getCourse(courseArray[i].getCode()).toString();
//            courseList[i] = temp;
//         }
//////         return courseList;
//      }
//      else
//      {}
//      return courseList;
      return model.getAllCourses();
   }
   
   public AMSModel getModel()
   {
      return model;
   }
   
   public String getProgram()
   {
      return model.getProgram().toString();
   }
   
   public String getCourse(String courseCode)
   {
      return model.getCourse(courseCode).toString();
   }
   
   /**
    * A method to get the total course count
    * @return count:int
    */
   public int getCourseCount()
   {
      if (model.countCoreCourses() == 0)
      {
         return 0;
      }
      return model.getAllCourses().length;
   }

   /**
    * Application entry point
    */
   public void initialiseEngine()
   {
      this.model = new AMSFacade();
      mainWindow = new AMSMainWindow(this);
      mainWindow.setVisible(true);
      
      model.addStudent(student);
      mainWindow.callAddProgramDialog();
      
   }
   
   /**
    * This method will add a program to the university
    * 
    * @param programCode
    * @param programName
    */
   public void addProgram(String programCode, String programName) 
            throws ProgramException
   {
      //create a program
      program = new Program(programCode, programName);
      model.addProgram(program);
   }
   
   /**
    * this will add a course to our current program
    * 
    * @param courseCode:String
    * @param courseName:String
    * @param preReqs:String[]
    * @param isElective:Boolean
    * @param credit:int
    * @throws ProgramException
    */
   public void addCourse(String courseCode, String courseName,
                         String [] preReqs, boolean isElective, int credit)
                         throws ProgramException
   {
//      boolean success = false;
      
      /**
       *  NB: the credit points at this stage of the chain
       *  will be an integer.
       */
      
      // check if the course is elective
      if (isElective)
      {
         // add an elective course to the program
         course = new ElectiveCourse(courseCode, courseName, credit, preReqs);
         model.addCourse(course);

      }
      else
      {
         // add a core course to the program
         course = new CoreCourse(courseCode, courseName, preReqs);
         model.addCourse(course);

      }
   }
   
   /**
    * Method to reset the courses for a program
    * while keeping the original code and name.
    */
   public void resetCourses()
   {
      int split;
      // get the old program and 
      // split the old program code from the name
      String oldCode = model.getProgram().toString();
      split = oldCode.indexOf(":");
      String oldName = oldCode.substring(split+1, oldCode.length());
      oldCode = oldCode.substring(0,split);
      
//      // DEBUG
//      System.out.println("Old code: " + oldCode);
//      System.out.println("Old Name: " + oldName);
      
      // the old student
      Student oldStudent = model.getStudent();
                  
      this.model = new AMSFacade(oldStudent, new Program(oldCode, oldName));
      
      // create an info box
      String message = "Reset Complete with\nProgram: " + getProgram() + 
               " and\nStudent: " + model.getStudent().getStudentId() + 
               ", " + model.getStudent().getFullName();
      mainWindow.callInfoBox(message);
      
      // update course counts
      mainWindow.getCoursePanel().resetCoursePanel();
      mainWindow.updateCount();      
   }
   
   public void removeCourse(String courseId) throws ProgramException
   {
      try
      {
         model.removeCourse(courseId);
      }
      catch (ProgramException pe)
      {
         mainWindow.callInfoBox(courseId + " can not be removed.");
      }
   }
}
