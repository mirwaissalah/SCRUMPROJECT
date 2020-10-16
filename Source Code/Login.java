package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Control {
@FXML
private TextField txtusername;
@FXML
private PasswordField txtpass;

	
public void login(ActionEvent event) throws IOException {
	String url = "jdbc:mysql://localhost:3306/programming2";
	String user="root";
	String pass="wasim12345";
	String uname=txtusername.getText();
	String pass1=txtpass.getText();
try {
		Connection mycon=DriverManager.getConnection(url,user,pass);
		Statement mystate=mycon.createStatement();
		String sql="select * from signup where Username='"+uname+"' and Password='"+pass1+"'";
		mystate.executeQuery(sql);
		ResultSet myres=mystate.executeQuery(sql);
			
if (myres.next()) {
	JOptionPane.showMessageDialog(null, "welcome");
	Parent nextwindow= FXMLLoader.load(getClass().getResource("/application/Dashboard.fxml"));
		Scene add = new Scene(nextwindow,750,600);
		Stage stage= new Stage();
		stage.setScene(add);
		stage.show();
}
   else{
	
   JOptionPane.showMessageDialog(null, "Sorry try again");
	 }	 
}
	catch(Exception exc) {
	exc.printStackTrace();
	
		}}
public void signup(ActionEvent event) throws IOException {
	 Parent nextwindow= FXMLLoader.load(getClass().getResource("/application/Registeration.fxml"));
		Scene add = new Scene(nextwindow,600,415);
		Stage stage= new Stage();
		stage.setScene(add);
		stage.show();
	
}
public void fun(ActionEvent event) throws IOException {
	 Parent nextwindow= FXMLLoader.load(getClass().getResource("/application/Functions.fxml"));
		Scene add = new Scene(nextwindow,1240,640);
		Stage stage= new Stage();
		stage.setScene(add);
		stage.show();
	
}
}

