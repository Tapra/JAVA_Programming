
/**
 * 
 */
package ams.test;

import ams.model.*;
import ams.model.facade.*;
import ams.model.exception.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
public class TesterWithPreReqs
{
   private static final String P1 = "COSC1073";
   private static final String P2 = "COSC2136";
   private static final String MATHS = "MATH1074";
   private static final String COMP_THEORY = "COSC1107";
   private static final String MAD = "COSC2309";
   private static final String DISTRIBUTED = "COSC1197";
   private static final String ADV_DISTRIBUTED = "ISYS2403";
   private static final String ADV_DISTRIBUTED2 = "ISYS2222";
   
   private Course coreCourse1, coreCourse2, coreCourse3, coreCourse4;
   private Course electiveCourse1, electiveCourse2, electiveCourse3,
         electiveCourse4;
   
   public TesterWithPreReqs(AMSModel model) throws ProgramException
   {
      try
      {
         model.addCourse(coreCourse1);
         model.addCourse(coreCourse2);
         model.addCourse(coreCourse3);
         model.addCourse(coreCourse4);
         model.addCourse(electiveCourse1);
         model.addCourse(electiveCourse2);
         model.addCourse(electiveCourse3);
         model.addCourse(electiveCourse4);
         
      }
      catch(ProgramException pe)
      {
         
      }
   }
   
   // create sample courses
   public void initialiseCourses() {
      coreCourse1 = new CoreCourse(P1, "Programming 1", null);
      coreCourse2 = new CoreCourse(MATHS, "Mathematics for Computing", null);
      coreCourse3 = new CoreCourse(P2, "Programming 2", new String[] { P1 });
      coreCourse4 = new CoreCourse(COMP_THEORY, "Computing Theory",
            new String[] { P2, MATHS });
      electiveCourse1 = new ElectiveCourse(MAD,
            "Mobile Application Development", 6, new String[] { P2 });
      electiveCourse2 = new ElectiveCourse(DISTRIBUTED,
            "Distributed Systems", 12, new String[] { COMP_THEORY, MAD });
      electiveCourse3 = new ElectiveCourse(ADV_DISTRIBUTED,
            "Advanced Topics in Distributed Systems", 12,
            new String[] { DISTRIBUTED });
      electiveCourse4 = new ElectiveCourse(ADV_DISTRIBUTED2,
            "Advanced Topics in Distributed Systems 2", 6,
            new String[] { ADV_DISTRIBUTED });
   }
}

