package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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
    private Button refreshButton;
    @FXML
    private TextArea OrdersText;

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
    public String getOrderText(){
        FileReader fr = null;
        String text = " ";
        try {
            fr = new FileReader("data/orders.txt");
            Scanner s = new Scanner(fr);
            while (s.hasNext()) {
                text+= s.nextLine();
                text+="\r\n";
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return text;
    }
    
    @FXML
    private void orderRefreshAction(ActionEvent event) {
        OrdersText.appendText(getOrderText());
    }

    public void initialize(URL url, ResourceBundle rb) {
        orderRefreshAction(new ActionEvent());
    }
}
