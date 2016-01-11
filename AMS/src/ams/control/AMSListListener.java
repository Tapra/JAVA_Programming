
/**
 * TODO find out how Item listener works
 */
package ams.control;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;
import ams.view.dialog.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

public class AMSListListener implements  ListSelectionListener
{
   private AMSAddCourseDialog dialog; 
   private ArrayList<String> preReqList;
   private AMSAddCourseControl control;
//   private String selected;
   
   public AMSListListener(AMSAddCourseDialog dialog)
   {
      this.dialog = dialog;
      this.control = dialog.getControl();
   }

   /**
    * @return selectedCourses:ArrayList<String>
    */
   public ArrayList<String> getSelectedCourses()
   {
      return preReqList;
   }

   /**
    * This override method will notify of any
    * item selection changes
    */
   @SuppressWarnings("unchecked")
   /* (non-Javadoc)
    * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
    */
   @Override
   public void valueChanged(ListSelectionEvent selection)
   {
      preReqList = new ArrayList<String>();
      String[] courseList = dialog.getCourseList();
      JList<String> selected = (JList<String>)selection.getSource();

      int[]indices = selected.getSelectedIndices();
      for (int i=0;i<indices.length;i++)
      {
         String course = courseList[indices[i]];
         preReqList.add(course);
      }
   }
}
