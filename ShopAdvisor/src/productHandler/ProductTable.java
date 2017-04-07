package productHandler;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductTable extends Application {

    private final ObservableList<Product> data = FXCollections.observableArrayList(new Product("Laptop", 859.00, 20), new Product("Bouncy Ball", 2.49, 198), new Product("Toilet", 99.00, 74), 
            new Product("The Notebook DVD", 19.99, 12),new Product("Corn", 1.49, 856));

    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage stage){
        window = stage;
        window.setTitle("Seller_Editor");
        
    //@Override
   // public void start(Stage stage) {

        stage.setWidth(500);
        stage.setHeight(550);

        // create table columns
        TableColumn<Product, String> NameCol = new TableColumn<Product, String>("Name");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn<Product, Double> PriceCol = new TableColumn<Product, Double>("Price");
        PriceCol.setMinWidth(100);
        PriceCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));

        TableColumn<Product, Integer> QuantityCol = new TableColumn<Product, Integer>("Quantity");
        QuantityCol.setMinWidth(60);
        QuantityCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));


        TableView<Product> table = new TableView<>();
        table.setPlaceholder(new Text("No content in table"));
        table.setItems(data);
        table.getColumns().addAll(NameCol, PriceCol, QuantityCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(table);

        vbox.getChildren().addAll(borderPane);

        vbox.getChildren().add( new Label( "Select cells and press CTRL+C. Paste the data into Excel or Notepad"));

        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.show();

        // enable multi-selection
        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // enable copy/paste
        TableUtils.installCopyPasteHandler(table);
    }


    public static class Product {

        private final StringProperty Name;
        private final DoubleProperty Price;
        private final IntegerProperty Quantity;

        private Product(String Name, Double price, Integer Quantity) {
            this.Name = new SimpleStringProperty(Name);
            this.Price = new SimpleDoubleProperty(price);
            this.Quantity = new SimpleIntegerProperty(Quantity);
        }

        public final StringProperty NameProperty() {
            return this.Name;
        }

        public final java.lang.String getName() {
            return this.NameProperty().get();
        }

        public final void setName(final java.lang.String Name) {
            this.NameProperty().set(Name);
        }

        public final DoubleProperty PriceProperty() {
            return this.Price;
        }

        public final double getPrice() {
            return this.PriceProperty().get();
        }

        public final void setPrice(final double Price) {
            this.PriceProperty().set(Price);
        }

        public final IntegerProperty QuantityProperty() {
            return this.Quantity;
        }

        public final int getQuantity() {
            return this.QuantityProperty().get();
        }

        public final void setQuantity(final int Quantity) {
            this.QuantityProperty().set(Quantity);
        }

    }


}