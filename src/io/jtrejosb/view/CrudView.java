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
  private InputFieldsPane IFP;
  private ReadFieldsPane RFP;
  private FieldsPane TFP;
  public CrudView() {
    super("CRUD Project");
    setSize(420,200);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    IFP=new InputFieldsPane();
    RFP=new ReadFieldsPane();
    TFP=new FieldsPane();
    TFP.setDisplayMode(FieldsPane.UPDATE_MODE);
    TB=new JTabbedPane();
    TB.addTab("Create new record",IFP);
    TB.addTab("Read",RFP);
    TB.addTab("Update",TFP);
    add(TB);
    setVisible(true);
  }
  public String getCode() {
    return IFP.getComponentValue(0);
  }
  public String getName() {
    return IFP.getComponentValue(1);
  }
  public String getAge() {
    return IFP.getComponentValue(2);
  }
  public String getPhone() {
    return IFP.getComponentValue(3);
  }
  public String getEmail() {
    return IFP.getComponentValue(4);
  }
  public String getJob() {
    return IFP.getComponentValue(5);
  }
  public String getFindCode() {
    return RFP.fFind.getText();
  }
  public void fillData(List<String> info) {
    RFP.setCode(info.get(0));
    RFP.setName(info.get(1));
    RFP.setAge(info.get(2));
    RFP.setPhone(info.get(3));
    RFP.setEmail(info.get(4));
    RFP.setJob(info.get(5));
  }
  public void showWarning(String W) {
    java.awt.Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(null,W,"Error!",JOptionPane.ERROR_MESSAGE);
    RFP.flushFields();
  }
  public void addCreationListener(ActionListener L) {
    IFP.getActionButton().addActionListener(L);
  }
  public void addReadListener(ActionListener L) {
    RFP.getFinderField().addActionListener(L);
  }
  public static void jumpToTab(int index) {
    TB.setSelectedIndex(index);
  }
}
