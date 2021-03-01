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
package com.java.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class CrudView extends javax.swing.JFrame {
  private JTabbedPane TB;
  private InputFieldsPane IFP;
  public CrudView() {
    super("CRUD Project");
    setSize(420,200);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    IFP=new InputFieldsPane();
    TB=new JTabbedPane();
    TB.addTab("Create new record",IFP);
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
  public void addCreationListener(java.awt.event.ActionListener L) {
    IFP.getActionButton().addActionListener(L);
  }
}
@SuppressWarnings("serial")
class InputFieldsPane extends javax.swing.JPanel {
  private JTextField[] inputComponents;
  private JButton bCreate;
  public InputFieldsPane() {
    String[]titles="Code,Full Name,Age,Phone Number,Email Address,Occupation".split(",");
    inputComponents=new JTextField[titles.length];
    bCreate=new JButton("Create");
    for(int i=0;i<titles.length;i++) {
      String value=titles[i];
      JTextField TF=new JTextField() {
        @Override
        public void paintComponent(java.awt.Graphics g) {
          super.paintComponent(g);
          g.setColor(Color.GRAY);
          if(getText().isEmpty())
            g.drawString(value,6,18);
        }
      };
      TF.setPreferredSize(new java.awt.Dimension(170,25));
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
