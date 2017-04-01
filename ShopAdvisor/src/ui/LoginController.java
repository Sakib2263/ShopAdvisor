package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class LoginController implements Initializable {

    @FXML
    private Button signinButton;
    @FXML
    private Button signupButton;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private TextField userNameInput;
    @FXML
    private ChoiceBox typeChoiceBox;
    
    @FXML
    private void signupButtonAction(ActionEvent event) throws IOException{
        Parent signupParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene signupScene = new Scene(signupParent);
        Stage signupStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        signupStage.setScene(signupScene);
        signupStage.show();
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeChoiceBox.setItems(FXCollections.observableArrayList("Buyer", "Seller"));
        typeChoiceBox.setValue("Buyer");
    }    
    
}