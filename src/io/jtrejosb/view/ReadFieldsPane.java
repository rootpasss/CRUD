/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: VIM 8.0
* Date: 06/03/2021, Time: 10:19:44.
*
* Additional Info.
*
* Source Code Target Or Details:
*
*     [Panel with JLabels to show query results]
*
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal for non-commercial purposes.
* Developer Contact: jtrejosb@live.com
* GitHub.com/jtrejosb
*/
package io.jtrejosb.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ReadFieldsPane extends javax.swing.JPanel {
  private Field fCode;
  private Field fName;
  private Field fAge;
  private Field fPhone;
  private Field fEmail;
  private Field fJob;
  public static JTextField fFind;
  private JButton B;
  public ReadFieldsPane() {
    fCode=new Field("Code",true);//true:false -> set read-only mode
    fName=new Field("Full Name",true);
    fAge=new Field("Age",true);
    fPhone=new Field("Phone Number",true);
    fEmail=new Field("Email Address",true);
    fJob=new Field("Occupation",true);
    fFind=new JTextField() {
      @Override
      public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        if(getText().isEmpty())
          g.drawString("Record ID",6,18);
      }
    };
    fFind.setPreferredSize(new Dimension(150,25));
    B=new JButton("Go to Update tab");
    B.addActionListener(e->io.jtrejosb.view.CrudView.jumpToTab(2));
    B.setVisible(false);
    add(fCode);
    add(fName);
    add(fAge);
    add(fPhone);
    add(fEmail);
    add(fJob);
    add(fFind);
    add(B);
  }
  public void setCode(String data) {
    fCode.setText(data);
  }
  public void setName(String data) {
    fName.setText(data);
  }
  public void setAge(String data) {
    fAge.setText(data);
  }
  public void setPhone(String data) {
    fPhone.setText(data);
  }
  public void setEmail(String data) {
    fEmail.setText(data);
  }
  public void setJob(String data) {
    fJob.setText(data);
  }
  public JTextField getFinderField() {
    return fFind;
  }
  public void flushFields() {
    fCode.setText("");
    fName.setText("");
    fAge.setText("");
    fPhone.setText("");
    fEmail.setText("");
    fJob.setText("");
    fFind.selectAll();
  }
}
