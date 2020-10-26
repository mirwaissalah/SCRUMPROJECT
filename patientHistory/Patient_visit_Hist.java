package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

	public class Patient_visit_Hist implements Initializable {
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
			Logger.getLogger(Patient_visit_Hist.class.getName()).log(Level.SEVERE, null,ex);
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
