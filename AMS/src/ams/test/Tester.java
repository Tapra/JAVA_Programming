/**
 * Discussion based tester class that will add
 * dummy courses to the model
 */
package ams.test;

import ams.model.Course;
import ams.model.ElectiveCourse;
import ams.model.CoreCourse;
import ams.model.facade.AMSModel;
import ams.model.exception.ProgramException;

/**
 * @author RMIT Discussion Board
 */

public class Tester
{
   private static final String P1 = "COSC1073";
   private static final String P2 = "COSC2136";
   private static final String MATHS = "MATH1074";
   private static final String COMP_THEORY = "COSC1107";
   private static final String MAD = "COSC2309";

   private Course coreCourse1, coreCourse2, coreCourse3, coreCourse4;
   private Course electiveCourse1;

   private AMSModel model;

   public Tester(AMSModel model)
   {
      this.model = model;
      coreCourse1 = new CoreCourse(P1, "Prog 1", null);
      coreCourse2 = new CoreCourse(MATHS, "Mathematics for Computing", null);
      coreCourse3 = new CoreCourse(P2, "Programming 2", null);
      coreCourse4 = new CoreCourse(COMP_THEORY, "Computing Theory", null);
      electiveCourse1 =
               new ElectiveCourse(MAD, "Mobile Application Development", 6,
                                  null);
   }

   public void addCourses()
   {
      try
      {
         model.addCourse(coreCourse1);
         model.addCourse(coreCourse2);
         model.addCourse(electiveCourse1);
         model.addCourse(coreCourse3);
         model.addCourse(coreCourse4);

      }
      catch (ProgramException e)
      {
         // WE ARE ASSUMING THAT NO EXCEPTIONS ARE THROWN HERE AS WAS DISCUSSED
         // DURING THE CHAT
      }
   }
}
