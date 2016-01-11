
/**
 * This class is the add Program dialog box.
 * It opens a dialog box so a program code and
 * program name can be entered and passed on to
 * the AddProgramController
 */
package ams.view.dialog;

import javax.swing.*;

import java.awt.*;

import ams.control.AMSAddProgramControl;
import ams.view.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 *
 */

@SuppressWarnings("serial")
public class AMSAddProgramDialog extends JFrame
{
   
   private AMSAddProgramControl controller;
   private AMSMainWindow mainWindow;
   private JPanel addProgramDialogPanel = new JPanel();
   
   // create the labels, text fields and the ok button
   private JLabel label1 = new JLabel("Program Code:");
   private JLabel label2 = new JLabel("Program Name:");
   private JTextField tf1 = new JTextField(15);
   private JTextField tf2 = new JTextField(15);
   private JButton ok = new JButton("Initilize Program");
   
   
   public AMSAddProgramDialog(AMSMainWindow window)
   {
      super("PROGRAM");
      this.mainWindow = window;
      this.controller = new AMSAddProgramControl(this, mainWindow);
//      this.pack();
      this.setSize(270,110);

      this.setResizable(false);
//      this.setSize(getPreferredSize());
      this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      
      addProgramDialogPanel.setBackground(Color.GRAY);
      addProgramDialogPanel.setLayout(new GridLayout(0,2,5,5));
      
      addProgramDialogPanel.add(label1);
      addProgramDialogPanel.add(tf1);
//      tf1.addActionListener(controller);
      addProgramDialogPanel.add(label2);
      addProgramDialogPanel.add(tf2);
      tf2.addActionListener(controller);
      addProgramDialogPanel.add(Box.createGlue());
      addProgramDialogPanel.add(ok);
      ok.addActionListener(controller);
      
      this.add(addProgramDialogPanel);
//      this.pack();
//      this.validate();
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }

   /**
    * This method transfers the program code
    * to the controller
    * @return tf1:JTextField
    */
   public JTextField getTf1()
   {
      return tf1;
   }

   /**
    * This method transfers the program name
    * to the controller
    * @return tf2:JTextField
    */
   public JTextField getTf2()
   {
      return tf2;
   }
}
