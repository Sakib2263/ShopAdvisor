package ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.SyncClient;
import javafx.stage.StageStyle;

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
    private Button deliveredButton;
    @FXML
    private Button SfeedBackButton;
    @FXML
    private ListView<String> orderlist;
    ObservableList<String> orders = FXCollections.observableArrayList();

    @FXML
    void signoutButtonAction(ActionEvent event) throws IOException {
        if (CommonControll.ConfirmationDialogueOK("Continue?", "Signout", "You are about to be signed out")) {
            CommonControll.changeScreen(FXMLLoader.load(getClass().getResource("login.fxml")), (Stage) ((Node) event.getSource()).getScene().getWindow());
        }
    }

    public String getOrderText() {
        FileReader fr;
        String text = " ";
        try {
            fr = new FileReader("data/orders/server/" + CurrentState.getLoggedinUser().getFullName() + ".txt");
            FileWriter fw = new FileWriter("data/orders/" + CurrentState.getLoggedinUser().getFullName() + "_history.txt", true);
            Scanner s = new Scanner(fr);
            int linecount = 0;
            while (s.hasNext()) {
                text += s.nextLine().trim();
                text += "\r\n";
                linecount++;
                if(linecount > 9){
                    orders.add(text);
                    fw.append(text);
                    text = " ";
                    linecount = 0;
                }
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            orders.add("empty");
        } catch(IOException e){
            System.err.println(e);
        }
        return text;
    }
    public void updateOrder() {
        try {
            FileWriter fr = new FileWriter("data/orders/server/" + CurrentState.getLoggedinUser().getFullName() + ".txt");
            for(String s: orders){
                fr.append(s);
            }
            fr.close();
        } catch (IOException ex) {
            System.err.println("Exception: " + ex + " File could not be found");
        }
    }

    @FXML
    private void orderRefreshAction(ActionEvent event) {
        new SyncClient(CurrentState.getServerIP(), CurrentState.getLoggedinUser()).start();
        getOrderText();
        orderlist.setItems(orders);
    }

    @FXML
    private void deliverAction(ActionEvent event) {
        String temp = orderlist.getSelectionModel().getSelectedItem();
        orders.remove(temp);
        orderlist.refresh();
        updateOrder();
    }
    
    @FXML
    private Button visitSiteButton;
    @FXML
    private Button RegisterButton;

    @FXML
    private void visitSiteButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("webview.fxml"));
        Stage webstage = new Stage();
        webstage.initStyle(StageStyle.UTILITY);
        webstage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
        WebviewController.url = "https://sites.google.com/view/shopadvisor/home";
        CommonControll.changeScreen(fxmlLoader.load(), webstage);
    }
        @FXML
    private void RegisterButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("webview.fxml"));
        Stage webstage = new Stage();
        webstage.initStyle(StageStyle.UTILITY);
        webstage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
        WebviewController.url = "https://www.google.com/gmail/";
        CommonControll.changeScreen(fxmlLoader.load(), webstage);
    }
    
    @FXML
    private void SfeedBackButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("webview.fxml"));
        Stage webstage = new Stage();
        webstage.initStyle(StageStyle.UTILITY);
        webstage.initOwner((Stage)((Node) event.getSource()).getScene().getWindow());
        WebviewController.url = "https://sites.google.com/view/shopadvisor/customer-feedback";
        CommonControll.changeScreen(fxmlLoader.load(), webstage);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderRefreshAction(new ActionEvent());
    }
}
