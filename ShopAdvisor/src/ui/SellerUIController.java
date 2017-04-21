package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SellerUIController implements Initializable {

    @FXML
    private Button signoutButton;
    @FXML
    private BorderPane Salesroot;
    @FXML
    private TableView<?> table1;
    @FXML
    private TableColumn<?, ?> storeColumn1;
    @FXML
    private TableColumn<?, ?> priceColumn1;
    @FXML
    private Button updateButton;

    @FXML
    void signoutButtonAction(ActionEvent event) throws IOException {
        if (CommonControll.ConfirmationDialogueOK("Continue?", "Signout", "You are about to be signed out")) {
            CommonControll.changeScreen(FXMLLoader.load(getClass().getResource("login.fxml")), (Stage) ((Node) event.getSource()).getScene().getWindow());
        }
    }

    @FXML
    private void updateButtonAction(ActionEvent event) {
        final DirectoryChooser directoryChooser
                = new DirectoryChooser();
        Window stage = null;
        final File selectedDirectory
                = directoryChooser.showDialog(stage);
        if (selectedDirectory != null) {
            selectedDirectory.getAbsolutePath();
        }
    }
    @FXML
    private TextArea OrdersText;
    @FXML
    private Button Refresh;
    // private String msg;

    @FXML
    public void displayTextOnButtonClick() throws FileNotFoundException {
        Scanner s = new Scanner(new File("orders.txt")).useDelimiter("\\s+");
        while (s.hasNext()) {
            if (s.hasNextInt()) { // check if next token is an int
                System.out.print(s.nextInt() + " "); // display the found integer
            } else {
                System.out.print(s.next() + " "); // else read the next token
            }
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        try {
            displayTextOnButtonClick();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SellerUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {

        msg="Hello World";
        OrdersText.setText(msg);

        Refresh.setOnAction(e->{
            OrdersText.setText(msg);
        });
    }  
     */
}
