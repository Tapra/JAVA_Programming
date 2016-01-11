/**
 * 
 */
package ams.view.dialog;

import javax.swing.*;

import java.awt.*;

import ams.control.AMSResetControl;
import ams.view.AMSMainWindow;

/**
 * @author Darrell Thoonen.
 * @Student_Number: 3482232.
 *
 */
public class AMSResetBox extends JFrame
{
//   public static final String TITLE = "";
   public static final String OK = "YES";
   public static final String CANCEL = "NO";
   private AMSMainWindow mainView;
   private JButton ok = new JButton(OK);
   private JButton cancel = new JButton(CANCEL);
   private FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 50, 15);
   private AMSResetControl control;// = new ConfirmBoxController(this, operation); 

   public AMSResetBox(String operation, AMSMainWindow view)
   {
      super("Reset");
      this.mainView = view;
      this.control = new AMSResetControl(this, view);
      JPanel panel = new JPanel();
      this.setSize(150,175);
      this.setResizable(false);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      panel.setLayout(layout);
      panel.add(new JLabel(operation.toLowerCase()));
      panel.add(ok);
      ok.addActionListener(control);
      ok.setActionCommand(OK);
      panel.add(cancel);
      cancel.addActionListener(control);
      cancel.setActionCommand(CANCEL);
      this.add(panel);
      this.setVisible(true);
   }
}
