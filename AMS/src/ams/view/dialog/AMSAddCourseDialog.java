
/**
 * This class is the add course dialog box
 * where the user enters the information
 * to be handed to the AMSystem.
 */
package ams.view.dialog;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.util.*;

import ams.control.AMSAddCourseControl;
import ams.control.AMSListListener;
import ams.model.Course;
import ams.view.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */
@SuppressWarnings("serial")
public class AMSAddCourseDialog extends JFrame
{  
   private AMSAddCourseControl controller;
   private JPanel addCoursePanel = new JPanel();
   private JPanel preReqPanel = new JPanel();
   private JLabel code = new JLabel("Course Code:");
   private JLabel name = new JLabel("Course Name:");
   private JLabel preReq = new JLabel("Pre-Requisites");
   private JTextField jtf1 = new JTextField(6);
   private JTextField jtf2 = new JTextField(15);
   private JToggleButton courseCredit = new JToggleButton("12");
   private JList<Course> preReqs;
   private Course[] courseList;// = new ArrayList<String>();
   private JScrollPane listHolder;// = new JScrollPane();
   private JToggleButton isElective = new JToggleButton("Core");
   private JButton ok = new JButton("OK");
   private AMSMainWindow mainWindow;
   private AMSListListener listener;
   
   /**
    * the add course dialog box constructor
    */
   
   public AMSAddCourseDialog(AMSMainWindow window)
   {
      super(AMSToolBar.ADD_COURSE);
      this.mainWindow = window;
      this.controller = new AMSAddCourseControl(this, mainWindow);
      this.listener = new AMSListListener(this);
      if(mainWindow.getAC().getAllCourses() != null)
      {
//         courseList = new String[mainWindow.getAC().getAllCourses().length];
         courseList = mainWindow.getAC().getAllCourses();
//       
      }
//      
      // set up the frame
      this.setSize(new Dimension(230, 300));
//      this.setSize(getSize());

      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      this.setLayout(new GridLayout(2,1,0,0));
      
      // set color and layout for the panels
      addCoursePanel.setBackground(Color.GRAY);
      addCoursePanel.setLayout(new GridLayout(0,2,5,5));
//      addCoursePanel.setSize(getPreferredSize());
      addCoursePanel.setSize(230,290);
      preReqPanel.setLayout(new BorderLayout());
      preReqPanel.setBackground(Color.LIGHT_GRAY);
//      preReqPanel.setSize(getMinimumSize());
//      preReqPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
      JPanel okPanel = new JPanel();
      okPanel.setLayout(new GridLayout(1,3,5,5));
      okPanel.setBackground(Color.GRAY);
      
      // add components to the add course panel
      addCoursePanel.add(code);
      addCoursePanel.add(jtf1);
      addCoursePanel.add(name);
      addCoursePanel.add(jtf2);
      addCoursePanel.add(isElective);
      isElective.addActionListener(controller);
      addCoursePanel.add(courseCredit);
      courseCredit.addActionListener(controller);
      addCoursePanel.add(preReq);
      
      // add components to the pre req panel
      courseList = mainWindow.getAC().getAllCourses();
      if (courseList != null)
      { 
         preReqs = new JList<Course>(courseList);
         preReqs.setBackground(Color.LIGHT_GRAY);
         preReqs.setVisibleRowCount(4);
         preReqs.addListSelectionListener(listener);
//         preReqs.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
         listHolder = new JScrollPane(preReqs);

//         listHolder.add(preReqs);
//         listHolder.setWheelScrollingEnabled(true);
         
//         preReqPanel.add(Box.createGlue());
//         listener = preReqs.getSelectionModel();
//         preReqs.addItemListener(listener);
         preReqPanel.add(listHolder, BorderLayout.CENTER);
//         preReqPanel.add(new JPanel(), BorderLayout.WEST);
//         preReqPanel.add(new JPanel(), BorderLayout.EAST);
      }
      else
      {
         listHolder = new JScrollPane();
         preReqPanel.add(listHolder, BorderLayout.CENTER);
      }
      
      
      // create the ok panel
      okPanel.add(Box.createGlue());
      okPanel.add(ok);
      okPanel.add(Box.createGlue());
      ok.setActionCommand("ok");
      ok.addActionListener(controller);
//      addCoursePanel.add(preReqPanel);
      
      preReqPanel.add(okPanel, BorderLayout.SOUTH);
      this.add(addCoursePanel);
      this.add(preReqPanel);
//      this.add(okPanel);
      this.pack();
      this.setLocationRelativeTo(null);
   }   
   
   /**
    * This method will get the text field jtf1
    * @return jtf1:JTextField
    */
   public JTextField getJtf1()
   {
      return jtf1;
   }

   /**
    * This method will get the text field jtf2
    * @return jtf2:JTextField
    */
   public JTextField getJtf2()
   {
      return jtf2;
   }   
   
   /**
    * This method will return the add course
    * controller
    * @return controller:AddCourseController
    */
   public AMSAddCourseControl getControl()
   {
      return controller;
   }
   /**
    * This method will provide access 
    * the list listener
    * @return listener:AMSListListener
    */
   public AMSListListener getListener()
   {
      return listener;
   }
   
   /**
    * This method will return the entire
    * course list present in a program
    * @return courseList:String[]
    */
   
   public String[] getCourseList()
   {
      Course[] courseList= mainWindow.getAC().getAllCourses();
      String[] stringCourseList = new String[mainWindow.getAC().getAllCourses().length];
      for (int i=0;i<stringCourseList.length;i++)
      {
         stringCourseList[i] = courseList[i].getCode();
      }
      return stringCourseList;
   }
   
   public String[] getPreReqs()
   { 
      if (listener.getSelectedCourses() != null)
      {
         String[] list = new String[listener.getSelectedCourses().size()];
         listener.getSelectedCourses().toArray(list);
//         String[] selectedCourseList = new String[list.length];
         return list;      
      }
      return null;
   }

   /**
    * This method will pass on the credit points
    * for a course.
    * @return courseCredit:Boolean
    */
   public boolean getCourseCredit()
   {
      if (courseCredit.isSelected())
         return true;
      return false;
   }
   
   public void selectCC()
   {
      courseCredit.setText("6");
      courseCredit.repaint();
   }
   
   public void deSelectCC()
   {
      courseCredit.setText("12");
      courseCredit.repaint();
   }
   
   public void coreCourse()
   {
      isElective.setText("Core");
      isElective.repaint();
   }
   
   public void electiveCourse()
   {
      isElective.setText("Elective");
      isElective.repaint();
   }

   /**
    * this method will tell if the elective toggle
    * box is checked.
    * @return isElective:Boolean
    */
   public boolean elective()
   {
      if (isElective.isSelected())
         return true;
      return false;
   }

   /**
    * @return
    */
   public int[] getSelected()
   {
      int[] indices = preReqs.getSelectedIndices();
      return indices;
   }
   
   
}
