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
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import data.*;

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
    private ImageView bag;

    dataMap customerInfo = new dataMap("customer.txt");
    dataMap salerInfo = new dataMap("sales.txt");

    @FXML
    private void signupButtonAction(ActionEvent event) throws IOException {
        Parent signupParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene signupScene = new Scene(signupParent);
        Stage signupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        signupStage.setScene(signupScene);
        signupStage.show();

    }

    boolean isAuthenticated() {
        String user = userNameInput.getText();
        if (typeChoiceBox.getValue().equals("Seller")) {
            return passwordInput.getText().equals(salerInfo.recordMap.get(user));
<<<<<<< HEAD
        }else
        return passwordInput.getText().equals(customerInfo.recordMap.get(user)); 
=======
        }
        return passwordInput.getText().equals(customerInfo.recordMap.get(user));
>>>>>>> origin/beta1
    }

    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        if (isAuthenticated()) {
            if (typeChoiceBox.getValue().equals("Buyer")) {
                Parent customerUIParent = FXMLLoader.load(getClass().getResource("customerUI.fxml"));
                Scene customerUIScene = new Scene(customerUIParent);
                Stage customerUIStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                customerUIStage.setScene(customerUIScene);
                customerUIStage.centerOnScreen();
                customerUIStage.show();
            } else if (typeChoiceBox.getValue().equals("Seller")) {
                Parent SellerUIParent = FXMLLoader.load(getClass().getResource("SellerUI.fxml"));
                Scene SellererUIScene = new Scene(SellerUIParent);
                Stage SellererUIStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                SellererUIStage.setScene(SellererUIScene);
                SellererUIStage.centerOnScreen();
                SellererUIStage.show();
            }
        } else {
            //to be implemented later show an error
            Alert alert = new Alert(AlertType.ERROR, "Wrong Username or Password, Try again?");
            alert.setTitle("Authentication Error");
            alert.setHeaderText("Sign in failed :(");
            alert.setGraphic(null);
            alert.show();
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeChoiceBox.setItems(FXCollections.observableArrayList("Buyer", "Seller"));
        typeChoiceBox.setValue("Buyer");
        AnimationThread t = new AnimationThread(bag);
        t.start();
    }

}
