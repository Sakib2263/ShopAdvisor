
package ui;

import java.net.URL;
import java.util.ResourceBundle;
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
public class SignupController implements Initializable {

    @FXML
    private PasswordField passwordInput;
    @FXML
    private Button registerButton;
    @FXML
    private TextField userNameInput;
    @FXML
    private ChoiceBox<?> typeChoiceBox;
    @FXML
    private TextField fullNameInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField addressInput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
