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

import java.util.List;

import com.java.model.CrudModel;
import com.java.view.CrudView;

//TODO: Continue adding listeners for CRUD
public class CrudController {
  private CrudModel CM;
  private CrudView CV;
  public CrudController() {
    CV=new CrudView();
    CM=new CrudModel();
    CV.addCreationListener(e->creation());
    CV.addReadListener(e->read());
  }
  private void creation() {
    String code=CV.getCode();
    String name=CV.getName();
    String age=CV.getAge();
    String phone=CV.getPhone();
    String email=CV.getEmail();
    String job=CV.getJob();
    if(code.length()>0&&name.length()>0&&age.length()>0&&phone.length()>0&&
        email.length()>0&&job.length()>0) {
      CM.create(code,name,age,phone,email,job);
    } else {
      CV.showWarning("All fields are REQUIRED due to create a new record!");
    }
  }
  private void read() {
    String ID=CV.getFindCode();
    if(!ID.isEmpty()) {
      List<String>data=CM.read(ID);
      if(data.size()>0)
        CV.fillData(data);
      else
        CV.showWarning("No record with ID '"+ID+"' were found");
    } else {
      CV.showWarning("Record ID is REQUIRED!");
    }
  }
}
