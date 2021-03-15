/**
* Developed by Johnny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 11.0.4 LTS, Standard Edition.
* Development Environment: VIM 8.0
* Date: 26/02/2021, Time: 13:11:21.
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
package com.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

//TODO: Test separatelly every single CRUD method
public class CrudModel {
  private Connection CC;
  public CrudModel() {
    connect();
  }
  private void connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String baseName="dummy";
      String url="jdbc:mysql://localhost:3306/"+baseName;
      String usr="root";
      String pwd="rootpass";
      System.out.println("Connecting...");
      CC=DriverManager.getConnection(url,usr,pwd);
      System.out.println("You are now connected to MySQL localhost server "+
                         "using database '"+baseName+"'");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public void create(String code,String name,String age,String phone,String email,String job) {
    try {
      String Q="INSERT INTO data (code,name,age,phone,email,job) "+
               "VALUES(?,?,?,?,?,?)";
      PreparedStatement PS=CC.prepareStatement(Q);
      PS.setString(1,code);
      PS.setString(2,name);
      PS.setString(3,age);
      PS.setString(4,phone);
      PS.setString(5,email);
      PS.setString(6,job);
      PS.executeUpdate();
      System.out.println("Stored");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
  public ArrayList<String> read(String id) {
    ArrayList<String>data=new ArrayList<>();
    try {
      String Q="SELECT * FROM data WHERE code = ?";
      PreparedStatement PS=CC.prepareStatement(Q);
      PS.setString(1,id);
      ResultSet RS=PS.executeQuery();
      if(RS.next()) {
        data.add(RS.getString("code"));
        data.add(RS.getString("name"));
        data.add(RS.getString("age"));
        data.add(RS.getString("phone"));
        data.add(RS.getString("email"));
        data.add(RS.getString("job"));
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return data;
  }
  public void update(String code,String name,String age,String phone,
                     String email,String job,String finderCode) {
    try {
      String Q="UPDATE data SET code=?, name=?, age=?, phone=?, email=?, job=? WHERE code=?";
      PreparedStatement PS=CC.prepareStatement(Q);
      PS.setString(1,code);
      PS.setString(2,name);
      PS.setString(3,age);
      PS.setString(4,phone);
      PS.setString(5,email);
      PS.setString(6,job);
      PS.setString(7,finderCode);
      if(PS.executeUpdate()>0)
        System.out.println("Updated");
      else
        System.out.println("No records with code '"+finderCode+"' were found");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
  public void delete(String finderCode) {
    try {
      String Q="DELETE FROM data WHERE code=?";
      PreparedStatement PS=CC.prepareStatement(Q);
      PS.setString(1,finderCode);
      if(PS.executeUpdate()>0)
        System.out.println("Deleted");
      else
        System.out.println("No records with code '"+finderCode+"' were found");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
}
