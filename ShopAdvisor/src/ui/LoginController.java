package ui;

import java.util.Calendar;
import java.net.URL;
import java.util.ResourceBundle;
<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
 
=======
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 */
>>>>>>> origin/master
public class LoginController implements Initializable {
    ObservableList<String>SigninList = FXCollections.observableArrayList("Buyer","Seller");
    @FXML
    private ChoiceBox SigninBox;
    
    @FXML
    public void initialize() {
        SigninBox.setValue("Buyer");
        SigninBox.setItems(SigninList);
    }     

<<<<<<< HEAD
=======
    @FXML
    private Button signinButton;
    @FXML
    private Button signupButton;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private TextField userNameInput;
    @FXML
    private ChoiceBox<?> typeChoiceBox;

    /**
     * Initializes the controller class.
     */
>>>>>>> origin/master
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
