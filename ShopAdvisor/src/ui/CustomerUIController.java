package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import productHandler.*;

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
    private void hidePane(ActionEvent event) throws IOException {
        rootPane.setLeft(null);
        hamburger_r.setVisible(true);
        //hamburger_l.setVisible(false);

    }

    @FXML
    private void showPane(ActionEvent event) throws IOException {
        //hamburger_l.setVisible(false);
        hamburger_r.setVisible(false);
        rootPane.setLeft(leftPane);

    }
    
    @FXML
    void signoutButtonAction(ActionEvent event) throws IOException {
        CommonControll.changeScreen(FXMLLoader.load(getClass().getResource("login.fxml")), (Stage) ((Node) event.getSource()).getScene().getWindow());
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hamburger_r.setVisible(false);

        initializeData(table11,"product1.csv");
        initializeColumns(storeColumn11,priceColumn11);
    }

}
