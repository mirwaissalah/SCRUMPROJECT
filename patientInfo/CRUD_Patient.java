package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableControler implements Initializable {
	@FXML
	private TableView<ModelTable> table;
	@FXML
	private TableColumn<ModelTable, String> col_id;
	@FXML
	private TableColumn<ModelTable, String> col_name;
	@FXML
	private TableColumn<ModelTable, String> col_dname;
	@FXML
	private TableColumn<ModelTable, String> col_age;
	@FXML
	private TableColumn<ModelTable, String> col_diag;
	@FXML
	private TableColumn<ModelTable, String> col_treat;
	@FXML
	private TableColumn<ModelTable, String> col_diagdate;

	@FXML
	private TextField name;
	@FXML
	private TextField dname;
	@FXML
	private TextField age;
	@FXML
	private TextField diag;
	@FXML
	private TextField treat;
	@FXML
	private TextField ID;
	@FXML
	private TextField searchid;
	@FXML 
	private DatePicker diagdate;

	

	ObservableList<ModelTable> oblist=FXCollections.observableArrayList();

public void initialize(URL arg0, ResourceBundle arg1) {
	
	try {
		Connection con = DBConnector.getConnection();
		ResultSet rs=con.createStatement().executeQuery("select * from pro_database");
		while (rs.next()) {
			oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("dname"),
					rs.getString("age"), rs.getString("diag"), rs.getString("treat"), rs.getString("diagdate")));
		}
	} catch (SQLException ex) {
		Logger.getLogger(TableControler.class.getName()).log(Level.SEVERE, null,ex);
	}
	
	
	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
	col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	col_dname.setCellValueFactory(new PropertyValueFactory<>("dname"));
	col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	col_diag.setCellValueFactory(new PropertyValueFactory<>("diag"));
	col_treat.setCellValueFactory(new PropertyValueFactory<>("treat"));
	col_diagdate.setCellValueFactory(new PropertyValueFactory<>("diagdate"));
	
	table.setItems(oblist);
}

public void reset() {
	name.clear();
	dname.clear();
	age.clear();
	diag.clear();
	treat.clear();
	ID.clear();
	diagdate.setValue(null);
}

public void insertData(ActionEvent event)throws IOException{
	String url="jdbc:mysql://localhost:3306/programming2";
	String user="root";
	String pass="wasim12345";
	
	LocalDate date1=diagdate.getValue();
	String name1=name.getText();
	String name2=dname.getText();
	String age1=age.getText();
	String diag1=diag.getText();
	String treat1=treat.getText();
	String date=date1.toString();
	
	
	
	try {
	 Connection mycon=DriverManager.getConnection(url,user,pass);
	 Statement state=mycon.createStatement();
	 state.executeUpdate("insert into pro_database (name,dname,age,diag,treat,diagdate) values('"+name1+"','"+name2+"','"+age1+"','"+diag1+"','"+treat1+"','"+date+"')");
	 refresh();

	}
	catch(Exception exc) {
		exc.printStackTrace();
	}
}
public void search(ActionEvent event)throws IOException{
	String url="jdbc:mysql://localhost:3306/programming2";
	String user="root";
	String pass="wasim12345";
	
	oblist.clear();
	
	String id1=searchid.getText();
	
	try {
	 Connection mycon=DriverManager.getConnection(url,user,pass);
	 Statement state=mycon.createStatement();
	 String sql="Select * from pro_database where ID='"+id1+"'";
	 state.executeQuery(sql);
	 ResultSet rs=state.executeQuery(sql);
	 while (rs.next()) {
			oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("dname"),
					rs.getString("age"), rs.getString("diag"), rs.getString("treat"), rs.getString("diagdate")));
			
		}
	 rs.close();
	}
	catch(Exception ex) {
		Logger.getLogger(TableControler.class.getName()).log(Level.SEVERE, null,ex);
	}
	
	
	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
	col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	col_dname.setCellValueFactory(new PropertyValueFactory<>("dname"));
	col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	col_diag.setCellValueFactory(new PropertyValueFactory<>("diag"));
	col_treat.setCellValueFactory(new PropertyValueFactory<>("treat"));
	col_diagdate.setCellValueFactory(new PropertyValueFactory<>("diagdate"));
	
	table.setItems(oblist);
}
public void update(ActionEvent event)throws IOException{
	String url="jdbc:mysql://localhost:3306/programming2";
	String user="root";
	String pass="wasim12345";
	
	LocalDate date1=diagdate.getValue();
	String name1=name.getText();
	String name2=dname.getText();
	String age1=age.getText();
	String diag1=diag.getText();
	String treat1=treat.getText();
	String id1=ID.getText();
	String date=date1.toString();
	
	try {
	 Connection mycon=DriverManager.getConnection(url,user,pass);
	 Statement state=mycon.createStatement();
	 String sql=" update pro_database set name='"+name1+"',dname='"+name2+"',age='"+age1+"',diag='"+diag1+"',treat='"+treat1+"',diagdate='"+date+"' Where ID='"+id1+"'";
	 state.executeUpdate(sql);
	 int myres=state.executeUpdate(sql);
	if(myres==1) {
	 refresh();
	
	}
	else {
		JOptionPane.showMessageDialog(null, "The Following Row Does Not Exist");
		
	}
	}
	catch(Exception exc) {
		exc.printStackTrace();
	}
}
public void delete(ActionEvent event)throws IOException{
	String url="jdbc:mysql://localhost:3306/programming2";
	String user="root";
	String pass="wasim12345";
	
	String id1=ID.getText();
	
	try {
	 Connection mycon=DriverManager.getConnection(url,user,pass);
	 Statement state=mycon.createStatement();
	 state.executeUpdate(" DELETE FROM pro_database WHERE ID='"+id1+"'");
	 refresh();
	}
	catch(Exception exc) {
		exc.printStackTrace();
	}
}
public void refresh() {
	oblist.clear();
	try {
		Connection con = DBConnector.getConnection();
		ResultSet rs=con.createStatement().executeQuery("select * from pro_database");
		while (rs.next()) {
			oblist.add(new ModelTable(rs.getString("id"), rs.getString("name"), rs.getString("dname"),
					rs.getString("age"), rs.getString("diag"), rs.getString("treat"), rs.getString("diagdate")));
		}
		rs.close();
	} catch (SQLException ex) {
		Logger.getLogger(TableControler.class.getName()).log(Level.SEVERE, null,ex);
	}
	
	table.setItems(oblist);
}
	
}



