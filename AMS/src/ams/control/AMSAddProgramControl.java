
/**
 * This class is the Add program manager
 */

package ams.control;

import java.awt.event.*;

import ams.view.AMSMainWindow;
import ams.view.dialog.AMSAddProgramDialog;
import ams.model.exception.*;

/**
 * @author Darrell Thoonen. 
 * @Student_Number: 3482232.
 */

public class AMSAddProgramControl implements ActionListener
{
   private AMSHelper helper;
   private AMSAddProgramDialog dialog;
   private AMSMainWindow mainWindow;
   
   public AMSAddProgramControl(AMSAddProgramDialog dialog, AMSMainWindow window)
   {
      this.dialog = dialog;
      this.mainWindow = window;
      this.helper = new AMSHelper(this, window.getAC());
   }
   
   /* (non-Javadoc)
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed(ActionEvent arg0)
   {
      boolean success = false;
      // Get Code from add program dialog
//      System.out.println(dialog.getTf1().getText());
      dialog.getTf1().requestFocusInWindow();
      String programCode = dialog.getTf1().getText();
      
      // Get Name form add program dialog
//      System.out.println(dialog.getTf2().getText());
      dialog.getTf2().requestFocusInWindow();
      String programName = dialog.getTf2().getText();
      
      // Add to the program to the model via the helper class
      try
      {
         // validate the program
         if (!validateProgram(programCode, programName))
         {
            throw new ProgramException();
         }
         else
         {
            // validation successful
            addProgram(programCode, programName);
            success = true;
         }
      }
      // Catch a program exception
      catch (ProgramException pe)
      {
         mainWindow.callInfoBox("Code must be 6 charaters.\nName must be atleast 2 characters");
      }
      // if entry was successful display a dialog box stating so.
      if (success)
      {
         String message = mainWindow.getAC().getProgram() + " has been added to \nthe university as a program.";
         mainWindow.updateLabel(mainWindow.getAC().getProgram());
         mainWindow.callInfoBox(message);
         dialog.dispose();
      }
   }
   
   /**
    * Helper method to pass the program on to the AMSHelper
    * 
    * @param programCode:String
    * @param programName:String
    * @throws ProgramException
    */
   public void addProgram(String programCode, String programName) 
            throws ProgramException
   {
      helper.addProgram(programCode, programName);
   }
   
   /**
    * Helper method to validate program entry
    * 
    * @param programCode:String
    * @param programName:String
    * @return isValid:boolean   This variable is created on the fly
    */
   public boolean validateProgram(String programCode, String programName)
   {
      if (programCode.length() != 6 || programName.length() < 2)
         return false;
      return true;
   }
}
