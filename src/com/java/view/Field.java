/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: VIM 8.0
* Date: 06/03/2021, Time: 15:07:53.
*
* Additional Info.
*
* Source Code Target Or Details:
*
*     [Input or ouput field]
*
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal for non-commercial purposes.
* Developer Contact: jtrejosb@live.com
* GitHub.com/jtrejosb
*/
package com.java.view;

import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Field extends javax.swing.JTextField {
  private String PH;
  private boolean state=true;
  public Field(String PH) {
    this.PH=PH;
    initComponent();
  }
  public Field(String PH,boolean state) {
    this.PH=PH;
    this.state=!state;
    initComponent();
  }
  private void initComponent() {
    setPreferredSize(new Dimension(170,25));
    setForeground(Color.DARK_GRAY);
    setEditable(state);
    setFocusable(state);
    setToolTipText(!state?"READ ONLY":null);
  }
  public void setReadOnly(boolean state) {
    setEditable(!state);
    setFocusable(!state);
  }
  @Override
  public void paintComponent(java.awt.Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.GRAY);
    if(getText().isEmpty())
      g.drawString(PH,6,18);
  }
}
