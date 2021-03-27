package io.jtrejosb.view.core;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FieldsPane extends javax.swing.JPanel implements FieldMode {
  private Field fCode;
  private Field fName;
  private Field fAge;
  private Field fPhone;
  private Field fEmail;
  private Field fJob;
  private JTextField fFind;
  private JButton B;
  public FieldsPane() {
    fCode=new Field("Code");
    fName=new Field("Full Name");
    fAge=new Field("Age");
    fPhone=new Field("Phone Number");
    fEmail=new Field("Email Address");
    fJob=new Field("Occupation");
    fFind=new JTextField() {
      @Override
      public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        if(getText().isEmpty())
          g.drawString("Client ID",6,18);
      }
    };
    fFind.setPreferredSize(new Dimension(150,25));
    fFind.setForeground(fCode.getForeground());
    B=new JButton();
    //B.setEnabled(false);

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

  public void setJob(String data) {
    fJob.setText(data);
  }

  public void setEmail(String data) {
    fEmail.setText(data);
  }

  //Setters: may be eventually replaced with the method getDataFields
  public String getCode() {
    return fCode.getText();
  }

  public String getName() {
    return fName.getText();
  }

  public String getAge() {
    return fAge.getText();
  }

  public String getPhone() {
    return fPhone.getText();
  }

  public String getEmail() {
    return fEmail.getText();
  }

  public String getJob() {
    return fJob.getText();
  }

  public void setDisplayMode(int mode) {
    switch(mode) {
      case CREATION_MODE: mode1();
        break;
      case READ_MODE: mode2();
        break;
      case UPDATE_MODE: mode3();
        break;
      case DELETION_MODE: mode4();
        break;
    }
  }

  public void clearAllFields() {
    fCode.setText("");
    fName.setText("");
    fAge.setText("");
    fPhone.setText("");
    fEmail.setText("");
    fJob.setText("");
    fFind.selectAll();
  }

  public JTextField[] getDataFields() {
    return new JTextField[]{fCode,fName,fAge,fPhone,fEmail,fJob};
  }

  public JTextField getFinderField() {
    return fFind;
  }

  public JButton getButton() {
    return B;
  }

  private void mode1() {
    B.setText("Create");
    remove(fFind);
  }

  private void mode2() {
    fCode.setEditable(false);
    fName.setEditable(false);
    fAge.setEditable(false);
    fPhone.setEditable(false);
    fEmail.setEditable(false);
    fJob.setEditable(false);
    B.setText("Go to Update tab");
    B.setVisible(false);
  }

  private void mode3() {
    mode2();
    B.setText("Update");
    B.setVisible(true);
  }

  private void mode4() {
    mode2();
    B.setText("Delete");
    B.setVisible(true);
  }

  public void enableEdit() {
    fCode.setEditable(true);
    fName.setEditable(true);
    fAge.setEditable(true);
    fPhone.setEditable(true);
    fEmail.setEditable(true);
    fJob.setEditable(true);
    B.setVisible(true);
  }

  public void showButton() {
    B.setVisible(true);
  }
}

@SuppressWarnings("serial")
class Field extends JTextField {
  private final String ph;
  public Field(String ph) {
    this.ph=ph;
    setEnabled(true);
    setPreferredSize(new Dimension(170,25));
    setForeground(Color.DARK_GRAY);
    setToolTipText("");
    addFocusListener(new java.awt.event.FocusAdapter() {
      @Override
      public void focusGained(java.awt.event.FocusEvent evt) {
        selectAll();
      }
    });
  }

  @Override
  public void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.GRAY);
    if(getText().isEmpty())
      g.drawString(ph,6,18);
  }

  @Override
  public String getToolTipText(java.awt.event.MouseEvent evt) {
    return isEditable()?"":"READ ONLY";
  }
}
