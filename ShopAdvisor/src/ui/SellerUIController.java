package ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SellerUIController implements Initializable {
    
    @FXML
    private Button signoutButton;
    @FXML
    void signoutButtonAction(ActionEvent event) throws IOException {
        if(CommonControll.ConfirmationDialogueOK("Continue?", "Signout", "You are about to be signed out")){
            CommonControll.changeScreen(FXMLLoader.load(getClass().getResource("login.fxml")), (Stage) ((Node) event.getSource()).getScene().getWindow());
        }
    }  
    /*
    final Button browseButton = new Button("Browse");
    browseButton.setOnAction(
    new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent e) {
            final DirectoryChooser directoryChooser =
                new DirectoryChooser();
            Window stage = null;
            final File selectedDirectory =
                    directoryChooser.showDialog(stage);
            if (selectedDirectory != null) {
                selectedDirectory.getAbsolutePath();
            }
        }
    }
);
*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
