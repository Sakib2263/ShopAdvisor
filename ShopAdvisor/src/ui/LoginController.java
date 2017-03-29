package ui;

import java.util.Calendar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
 
public class LoginController implements Initializable {
    ObservableList<String>SigninList = FXCollections.observableArrayList("Buyer","Seller");
    @FXML
    private ChoiceBox SigninBox;
    
    @FXML
    public void initialize() {
        SigninBox.setValue("Buyer");
        SigninBox.setItems(SigninList);
    }     

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
