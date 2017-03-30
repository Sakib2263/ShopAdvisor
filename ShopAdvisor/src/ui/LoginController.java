package ui;

import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class LoginController  {
    //implements Initializable
    ObservableList<String>SigninList = FXCollections.observableArrayList("Seller","Buyer");
    @FXML
    private Button signinButton;
    @FXML
    private Button signupButton;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private TextField userNameInput;
    @FXML
    //private ChoiceBox<?> typeChoiceBox;
    private ChoiceBox SigninBox;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        //SigninBox.setValue("Buyer");
        SigninBox.setItems(SigninList);
    }    
    
}