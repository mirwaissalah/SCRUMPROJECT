package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Signup1 {
	@FXML
	private TextField fnametxt;
	@FXML
	private TextField lnametxt;
	@FXML 
	private TextField usernametxt;
	@FXML 
	private PasswordField password;
	@FXML 
	private DatePicker birth;
	@FXML
	private TextField addresstxt;
	
public void reset() {
    fnametxt.clear();
    lnametxt.clear();
    usernametxt.clear();
    password.clear();
    birth.setValue(null);
    addresstxt.clear();
	}
public void insert(ActionEvent event)throws IOException{
	String url = "jdbc:mysql://localhost:3306/programming2";
	String user="root";
	String pass="wasim12345";
	
	String name1=fnametxt.getText();
	String name2=lnametxt.getText();
	String user1=usernametxt.getText();
	String Pass1=password.getText();
	LocalDate birthdate=birth.getValue();
	String date=birthdate.toString();
	String address=addresstxt.getText();
	try {
		 Connection mycon=DriverManager.getConnection(url,user,pass);
		 Statement state=mycon.createStatement();
		 state.executeUpdate("insert into signup (First_Name,Last_Name,Username,Password,Birth_Date,Address) values('"+name1+"','"+name2+"','"+user1+"','"+Pass1+"','"+date+"','"+address+"')");
		 JOptionPane.showMessageDialog(null, "The Data Has Been Inserted");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
}



}
