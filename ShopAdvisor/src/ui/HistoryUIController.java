
package ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.Order;


public class HistoryUIController implements Initializable {

    @FXML
    private TableColumn<Order, String> timeColumn;
    @FXML
    private TableColumn<Order, String> productColumn;
    @FXML
    private TableColumn<Order, String> ShopColumn;
    @FXML
    private TableColumn<Order, Double> priceColumn;
    @FXML
    private TableView<Order> historyTable;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeTable();
    }
    
    void initializeTable(){
        initializeData(historyTable,CurrentState.getLoggedinUser().getUserName());
        ShopColumn.setCellValueFactory(new PropertyValueFactory<>("shop"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    } 

    private void initializeData(TableView<?> historyTable, String name) {
        ObservableList<Order> orders = FXCollections.observableArrayList();
        
        try {
         FileInputStream fileIn = new FileInputStream("data/orders/" + name +  ".ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         ArrayList<Order> o = (ArrayList<Order>) in.readObject();
         for(Order order : o){
            orders.add(order);
        }
         in.close();
         fileIn.close();
         this.historyTable.setItems(orders);
      }catch(IOException i) {
            System.err.println(i);
      }catch(ClassNotFoundException c) {
         System.out.println("Employee class not found");
      }
        
    }
    
}
