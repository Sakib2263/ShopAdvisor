package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
    private TableView<Product> table1;

    @FXML
    private TableColumn<Product, String> storeColumn;

    @FXML
    private TableColumn<Product, Double> priceColumn;

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

    private void initializeColumns() {
        storeColumn.setCellValueFactory(new PropertyValueFactory<>("store"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void initializeData() {
        ObservableList<Product> tableContent;
        try {
            tableContent = ProductTableMaker.getProduct("product1.csv");
            //tableContent.sort(Comparator.naturalOrder());
            storeColumn.setSortable(false);
            Comparator<? super Product> priceComparator = new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()> o2.getPrice()){
                        return 1;
                    }
                    return -1;
                }
            };
            tableContent.sort(priceComparator);
            table1.setItems(tableContent);
        } catch (IOException ex) {
            System.err.println("IOException" + ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hamburger_r.setVisible(false);

        initializeData();
        initializeColumns();
        priceColumn.setSortType(TableColumn.SortType.ASCENDING);
    }

}
