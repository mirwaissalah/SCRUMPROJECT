package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

public class search {
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
}
