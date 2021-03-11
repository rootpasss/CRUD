/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: VIM 8.0
* Date: 06/03/2021, Time: 10:08:54.
*
* Additional Info.
*
* Source Code Target Or Details:
*
*     [Panel containing required fields for create record on database]
*
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal for non-commercial purposes.
* Developer Contact: jtrejosb@live.com
* GitHub.com/jtrejosb
*/
package com.java.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InputFieldsPane extends javax.swing.JPanel {
  private JTextField[] inputComponents;
  private JButton bCreate;
  public InputFieldsPane() {
    String[]titles="Code,Full Name,Age,Phone Number,Email Address,Occupation".split(",");
    inputComponents=new JTextField[titles.length];
    bCreate=new JButton("Create");
    for(int i=0;i<titles.length;i++) {
      String value=titles[i];
      Field TF=new Field(value);
      inputComponents[i]=TF;
      add(TF);
    }
    add(bCreate);
  }
  public String getComponentValue(int val) {
    return inputComponents[val].getText();
  }
  public JButton getActionButton() {
    return bCreate;
  }
}
