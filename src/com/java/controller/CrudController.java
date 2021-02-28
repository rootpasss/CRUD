/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: VIM 8.0
* Date: 26/02/2021, Time: 13:52:15.
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
package com.java.controller;

import com.java.model.CrudModel;
import com.java.view.CrudView;

//TODO: Add listeners for CRUD
public class CrudController {
  private CrudModel CM;
  private CrudView CV;
  public CrudController() {
    CV=new CrudView();
    CM=new CrudModel();
    CV.addCreationListener(e->creation());
    //CV.addReadListener(e->read());
  }
  private void creation() {
    String code=CV.getCode();
    String name=CV.getName();
    String age=CV.getAge();
    String phone=CV.getPhone();
    String email=CV.getEmail();
    String job=CV.getJob();
    CM.create(code,name,age,phone,email,job);
  }
}
