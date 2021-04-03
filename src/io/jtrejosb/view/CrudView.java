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

@SuppressWarnings("serial")
public class CrudView extends javax.swing.JFrame {
  private JTabbedPane TB;
  private FieldsPane CFP;
  private FieldsPane RFP;
  private FieldsPane UFP;
  private FieldsPane DFP;
  public CrudView() {
    super("CRUD Project");
    setSize(420,200);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    CFP=new FieldsPane();
    RFP=new FieldsPane();
    UFP=new FieldsPane();
    DFP=new FieldsPane();
    CFP.setDisplayMode(FieldsPane.CREATION_MODE);
    RFP.setDisplayMode(FieldsPane.READ_MODE);
    UFP.setDisplayMode(FieldsPane.UPDATE_MODE);
    DFP.setDisplayMode(FieldsPane.DELETION_MODE);
    TB=new JTabbedPane();
    TB.addTab("Create",CFP);
    TB.addTab("Read",RFP);
    TB.addTab("Update",UFP);
    TB.addTab("Delete",DFP);
    add(TB);
    setVisible(true);
  }
  public String getCode() {
    if(CFP.isShowing())
      return CFP.getCode();
    else
      return UFP.getCode();
  }
  public String getName() {
    if(CFP.isShowing())
      return CFP.getName();
    else
      return UFP.getName();
  }
  public String getAge() {
    if(CFP.isShowing())
      return CFP.getAge();
    else
      return UFP.getAge();
  }
  public String getPhone() {
    if(CFP.isShowing())
      return CFP.getPhone();
    else
      return UFP.getPhone();
  }
  public String getEmail() {
    if(CFP.isShowing())
      return CFP.getEmail();
    else
      return UFP.getEmail();
  }
  public String getJob() {
    if(CFP.isShowing())
      return CFP.getJob();
    else
      return UFP.getJob();
  }

  public String getFindCode() {
    if(RFP.isShowing())
      return RFP.getFinderField().getText();
    else if(UFP.isShowing())
      return UFP.getFinderField().getText();
    else
      return DFP.getFinderField().getText();
  }

  public void fillData(List<String> info) {
    javax.swing.JTextField[] fields;
    if(RFP.isShowing()) {
      fields=RFP.getDataFields();
      RFP.showButton();
      RFP.getButton().addActionListener(e->jumpToTab(2));
    } else if(UFP.isShowing()) {
      fields=UFP.getDataFields();
      UFP.enableEdit();
    } else {
      fields=DFP.getDataFields();
      DFP.showButton();
    }

    for(int i=0;i<fields.length;i++)
      fields[i].setText(info.get(i));
  }
  public void showWarning(String W) {
    java.awt.Toolkit.getDefaultToolkit().beep();
    JOptionPane.showMessageDialog(null,W,"Error!",JOptionPane.ERROR_MESSAGE);
    if(RFP.isShowing()) {
      RFP.clearAllFields();
      RFP.getButton().setVisible(false);
    } else if(UFP.isShowing()) {
      UFP.clearAllFields();
      UFP.getButton().setVisible(false);
    } else if(DFP.isShowing()) {
      DFP.clearAllFields();
      DFP.getButton().setVisible(false);
    }
  }
  public void addCreationListener(ActionListener L) {
    if(CFP.isShowing()) {
      CFP.getButton().addActionListener(L);
    }
  }
  public void addReadListener(ActionListener L) {
    RFP.getFinderField().addActionListener(L);
    UFP.getFinderField().addActionListener(L);
    DFP.getFinderField().addActionListener(L);
  }

  public void addUpdateListener(ActionListener L) {
    UFP.getButton().addActionListener(L);
  }

  public void addDeletionListener(ActionListener L) {
    DFP.getButton().addActionListener(L);
  }

  private void jumpToTab(int index) {
    TB.setSelectedIndex(index);
    javax.swing.JTextField[]data=RFP.getDataFields();
    for(int i=0;i<data.length;i++)
      UFP.getDataFields()[i].setText(data[i].getText());
    UFP.enableEdit();
  }
}
