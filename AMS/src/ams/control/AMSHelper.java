
/**
 * This class creates an object to interact with the MCP.
 */
package ams.control;

import ams.view.grid.cells.*;
import ams.model.exception.*;
import ams.model.Course;
import java.util.*;
import ams.model.facade.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class AMSHelper
{
   private AMSApplicationControl control;
   private AMSAddProgramControl programControl;
   private AMSAddCourseControl aCourseControl;
   private AMSRemoveCourseControl rCourseControl;
   private AMSCourseCell cell;
   private AMSMouseListener listen;
   
   
   
   public AMSHelper(AMSMouseListener listen, AMSApplicationControl control)
   {
      this.listen = listen;
//      this.cell = cell;
      this.control = control;
   }
   
   public AMSHelper(AMSApplicationControl control)
   {
      this.control = control;
   }
   
   public AMSHelper(AMSAddProgramControl programController, AMSApplicationControl control)
   {
      this.programControl = programController;
      this.control = control;
   }
   
   public AMSHelper(AMSAddCourseControl courseController, AMSApplicationControl control)
   {
      this.aCourseControl = courseController;
      this.control = control;
   }
   
   public AMSHelper(AMSRemoveCourseControl courseController, AMSApplicationControl control)
   {
      this.rCourseControl = courseController;
      this.control = control;
   }
   
   public AMSHelper getHelper()
   {
      return this;
   }
   
   public AMSApplicationControl getAC()
   {
      return control;
   }
   
   public AMSModel getModel()
   {
      return control.getModel();
   }
   
   public String getProgram()
   {
      return control.getProgram().toString();
   }
   
   public Course[] getAllCourses()
   {
      if (control.getAllCourses().length == 0)
         return null;
      else
         return control.getAllCourses();
   }
   
   public void addProgram(String programCode, String programName) 
            throws ProgramException
   {
      control.addProgram(programCode, programName);
   }

   /**
    * @param programCode
    * @param programName
    */
   public void addCourse(String courseCode, String courseName, String[] preReqs
                          , boolean isElective, int credit) throws ProgramException
   {
      try
      {
//         if(preReqs != null)
//         {
//            for (int i=0;i<preReqs.length;i++)
//            {
//               System.out.println(preReqs[i]);
//            }
//         }
         control.addCourse(courseCode, courseName, preReqs, isElective, credit);      
      }
      catch (ProgramException pe)
      {
         throw new ProgramException("Invalid entry");
      }
   }

   /**
    * 
    */
   public void removeCourse(String string) throws ProgramException
   {
//      System.out.println(string);
      control.removeCourse(string);
   }
}
