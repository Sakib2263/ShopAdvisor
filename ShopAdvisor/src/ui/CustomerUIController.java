package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import data.*;

/**
 * FXML Controller class
 *
 */
public class CustomerUIController implements Initializable {

    @FXML
    private BorderPane rootPane;
    @FXML
    private VBox leftPane;
    @FXML
    private Button hamburger_l;
    @FXML
    private Button hamburger_r;
    @FXML
    private Button signoutButton;
    
    @FXML
    private TableView<Product> table11;
    @FXML
    private TableColumn<Product, String> storeColumn11;
    @FXML
    private TableColumn<Product, Double> priceColumn11;
    @FXML
    private Button wishlistButton;
    @FXML
    private TableView<Product> table12;
    @FXML
    private TableColumn<Product, String> storeColumn12;
    @FXML
    private TableColumn<Product, Double> priceColumn12;
    @FXML
    private TableView<Product> table13;
    @FXML
    private TableColumn<Product, String> storeColumn13;
    @FXML
    private TableColumn<Product, Double> priceColumn13;
    @FXML
    private TableView<Product> table14;
    @FXML
    private TableColumn<Product, String> storeColumn14;
    @FXML
    private TableColumn<Product, Double> priceColumn14;
    @FXML
    private TableView<Product> wishlistTable; ////// whish list
    @FXML
    private TableColumn<Product, String> product_wishlist;
    @FXML
    private TableColumn<Product, String> store_wishlist;
    @FXML
    private TableColumn<Product, Double> price_wishlist;
    @FXML
    private Button orderButton;
    @FXML
    private Button hideWishlistButton;
    @FXML
    private AnchorPane rightPane;
    @FXML
    ObservableList<Product> SelectedProducts = FXCollections.observableArrayList();
     @FXML
    void hideWishlist(ActionEvent event) throws IOException {
        rootPane.setRight(null);
        showPane(new ActionEvent());
    }
     @FXML
    private void wishlistAction(ActionEvent event) throws IOException {
        rootPane.setRight(rightPane);
        hidePane(new ActionEvent());
    }
    @FXML
    void orderAction(ActionEvent event) {
    }
    @FXML
    private void hidePane(ActionEvent event) throws IOException {
        rootPane.setLeft(null);
        hamburger_r.setVisible(true);
    }

    @FXML
    private void showPane(ActionEvent event) throws IOException {
        hamburger_r.setVisible(false);
        rootPane.setLeft(leftPane);
    } 
    @FXML
    void signoutButtonAction(ActionEvent event) throws IOException {
        if(CommonControll.ConfirmationDialogueOK("Continue?", "Signout", "You are about to be signed out")){
            CommonControll.changeScreen(FXMLLoader.load(getClass().getResource("login.fxml")), (Stage) ((Node) event.getSource()).getScene().getWindow());
        }
    }

    Comparator<? super Product> priceComparator = new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()> o2.getPrice()){
                        return 1;
                    }
                    return -1;
                }
            };
    
    private void initializeColumns(TableColumn<Product, String> storeColumn,TableColumn<Product, Double> priceColumn) {
        storeColumn.setCellValueFactory(new PropertyValueFactory<>("store"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        storeColumn.setSortable(false);
    }

    private void initializeData(TableView<Product> table, String productFile) {
        ObservableList<Product> tableContent;
        try {
            tableContent = ProductTableMaker.getProduct(productFile);
            tableContent.sort(priceComparator);
            table.setItems(tableContent);
        } catch (IOException ex) {
            System.err.println("IOException" + ex);
        }
    }
    private void initializePanes(){
        hamburger_r.setVisible(false);
        rootPane.setRight(null);
        
    }
    public void addSelecteditem(TableView<Product> table){
        Product p = table.getSelectionModel().getSelectedItem();
        if(p != null){
           SelectedProducts.add(p);   
        }
    }
    public void makewishlist(){
        wishlistTable.setItems(SelectedProducts);
        initializeColumns(store_wishlist,price_wishlist);
        product_wishlist.setCellValueFactory(new PropertyValueFactory<>("Name"));
    }
    @FXML
    void addToWishListAction(ActionEvent event) {
        addSelecteditem(table11);
        makewishlist();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializePanes();
        initializeData(table11,"burger");
        initializeColumns(storeColumn11,priceColumn11);
        
        initializeData(table12,"product2.csv");
        initializeColumns(storeColumn12,priceColumn12);
        
         initializeData(table13,"product3.csv");
        initializeColumns(storeColumn13,priceColumn13);
        
    }

}
