package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class FeedBackController implements Initializable {

    @FXML
    private ChoiceBox sellerChoice;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sellerChoice.setItems(FXCollections.observableArrayList("KFC", "Subway", "BFC", "Ryans", "Transcend"));
        sellerChoice.setValue("Subway");
    }

}
