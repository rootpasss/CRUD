/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: VIM 8.0
* Date: 26/02/2021, Time: 13:57:02.
*
* Additional Info.
*
* Source Code Target Or Details:
*
*     []
*
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal for non-commercial purposes.
* Developer Contact: jtrejosb@live.com
* GitHub.com/jtrejosb
*/
package io.jtrejosb.view;

import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import io.jtrejosb.view.core.FieldsPane;

//TODO: Try to make just ONE pane with fields and then instantiate it for the 4 tab panes
//TODO: Continue adding panels for Update and Delete sections
@SuppressWarnings("serial")
public class CrudView extends javax.swing.JFrame {
  private static JTabbedPane TB;
  private FieldsPane CFP;
  private FieldsPane RFP;
  private FieldsPane UFP;
  public CrudView() {
    super("CRUD Project");
    setSize(420,200);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    CFP=new FieldsPane();
    RFP=new FieldsPane();
    UFP=new FieldsPane();
    CFP.setDisplayMode(FieldsPane.CREATION_MODE);
    RFP.setDisplayMode(FieldsPane.READ_MODE);
    UFP.setDisplayMode(FieldsPane.UPDATE_MODE);
    TB=new JTabbedPane();
    TB.addTab("Create new record",CFP);
    TB.addTab("Read",RFP);
    TB.addTab("Update",UFP);
    add(TB);
    setVisible(true);
  }
  public String getCode() {
    if(CFP.isShowing())
      return CFP.getCode();
    else if(UFP.isShowing())
      return UFP.getCode();
    return "";
  }
  public String getName() {
    if(CFP.isShowing())
      return CFP.getName();
    else if(UFP.isShowing())
      return UFP.getName();
    return "";
  }
  public String getAge() {
    if(CFP.isShowing())
      return CFP.getAge();
    else if(UFP.isShowing())
      return UFP.getAge();
    return "";
  }
  public String getPhone() {
    if(CFP.isShowing())
      return CFP.getPhone();
    else if(UFP.isShowing())
      return UFP.getPhone();
    return "";
  }
  public String getEmail() {
    if(CFP.isShowing())
      return CFP.getEmail();
    else if(UFP.isShowing())
      return UFP.getEmail();
    return "";
  }
  public String getJob() {
    if(CFP.isShowing())
      return CFP.getJob();
    else if(UFP.isShowing())
      return UFP.getJob();
    return "";
  }

  public String getFindCode() {
    if(RFP.isShowing())
      return RFP.getFinderField().getText();
    else if(UFP.isShowing())
      return UFP.getFinderField().getText();
    else
      return "";
  }

  public void fillData(List<String> info) {
    javax.swing.JTextField[] fields;
    if(RFP.isShowing()) {
      fields=RFP.getDataFields();
      for(int i=0;i<fields.length;i++)
        fields[i].setText(info.get(i));
      RFP.showButton();
    } else if(UFP.isShowing()) {
      fields=UFP.getDataFields();
      for(int i=0;i<fields.length;i++)
        fields[i].setText(info.get(i));
      UFP.enableEdit();
    }
  }
  public void showWarning(String W) {
    java.awt.Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(null,W,"Error!",JOptionPane.ERROR_MESSAGE);
    //RFP.flushFields();  TIP: FieldsPane class includes the method clearAllFields()
  }
  public void addCreationListener(ActionListener L) {
    if(CFP.isShowing()) {
      CFP.getButton().addActionListener(L);
    }
  }
  public void addReadListener(ActionListener L) {
    RFP.getFinderField().addActionListener(L);
    UFP.getFinderField().addActionListener(L);
  }

  public void addUpdateListener(ActionListener L) {
    UFP.getButton().addActionListener(L);
  }
  public static void jumpToTab(int index) {
    TB.setSelectedIndex(index);
  }
}
