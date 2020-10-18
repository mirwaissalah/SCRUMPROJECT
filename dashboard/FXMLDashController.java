/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progtwofinalproject;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLDashController implements Initializable {

    @FXML
    private Label lblDashHos;

    @FXML
    private JFXButton btnDashPat;

    @FXML
    private ImageView DashIconPat;

    @FXML
    private JFXButton DashPatRegBtn;

    @FXML
    private ImageView DashIconPatReg;

    @FXML
    private JFXButton DashUsersBtn;

    @FXML
    private FontAwesomeIconView DashUsersIco;
    

    @FXML
    void DashPadRegSub(ActionEvent event) {

        try{
            
                Parent root = FXMLLoader.load(getClass().getResource("FXMLpatientReg.fxml"));
                Scene scene = new Scene(root);
                Stage s = new Stage();
                s.setScene(scene);
                s.show();
        
        }catch(Exception ex){
        
        }
        
    }

    @FXML
    void DashPatSub(ActionEvent event) {

        try{
            
                Parent root = FXMLLoader.load(getClass().getResource("FXMLPatients.fxml"));
                Scene scene = new Scene(root);
                Stage s = new Stage();
                s.setScene(scene);
                s.show();
        
        }catch(Exception ex){
        
        }
        
    }
    
    @FXML
    void DashUsersSubm(ActionEvent event) {

        try{
            
                Parent root = FXMLLoader.load(getClass().getResource("FXMLTblUser.fxml"));
                Scene scene = new Scene(root);
                Stage s = new Stage();
                s.setScene(scene);
                s.show();
        
        }catch(Exception ex){
        
        }
        
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
