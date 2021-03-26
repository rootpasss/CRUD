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
  private FieldsPane IFP;
  private FieldsPane RFP;
  private FieldsPane UFP;
  public CrudView() {
    super("CRUD Project");
    setSize(420,200);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    IFP=new FieldsPane();
    RFP=new FieldsPane();
    UFP=new FieldsPane();
    IFP.setDisplayMode(FieldsPane.CREATION_MODE);
    RFP.setDisplayMode(FieldsPane.READ_MODE);
    UFP.setDisplayMode(FieldsPane.UPDATE_MODE);
    TB=new JTabbedPane();
    TB.addTab("Create new record",IFP);
    TB.addTab("Read",RFP);
    TB.addTab("Update",UFP);
    add(TB);
    setVisible(true);
  }
  public String getCode() {
    return IFP.getCode();
  }
  public String getName() {
    return IFP.getName();
  }
  public String getAge() {
    return IFP.getAge();
  }
  public String getPhone() {
    return IFP.getPhone();
  }
  public String getEmail() {
    return IFP.getEmail();
  }
  public String getJob() {
    return IFP.getJob();
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
    if(RFP.isShowing()) {
      RFP.setCode(info.get(0));
      RFP.setName(info.get(1));
      RFP.setAge(info.get(2));
      RFP.setPhone(info.get(3));
      RFP.setEmail(info.get(4));
      RFP.setJob(info.get(5));
    } else if(UFP.isShowing()) {
      UFP.setCode(info.get(0));
      UFP.setName(info.get(1));
      UFP.setAge(info.get(2));
      UFP.setPhone(info.get(3));
      UFP.setEmail(info.get(4));
      UFP.setJob(info.get(5));
    }
  }
  public void showWarning(String W) {
    java.awt.Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(null,W,"Error!",JOptionPane.ERROR_MESSAGE);
    //RFP.flushFields();
  }
  public void addCreationListener(ActionListener L) {
    if(IFP.isShowing()) {
      IFP.getButton().addActionListener(L);
    }
    //IFP.getActionButton().addActionListener(L);
  }
  public void addReadListener(ActionListener L) {
    RFP.getFinderField().addActionListener(L);
    UFP.getFinderField().addActionListener(L);
  }
  public static void jumpToTab(int index) {
    TB.setSelectedIndex(index);
  }
}
