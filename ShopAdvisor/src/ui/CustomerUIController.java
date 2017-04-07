package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
    private void hidePane(ActionEvent event) throws IOException{
        rootPane.setLeft(null);
        hamburger_r.setVisible(true);
        //hamburger_l.setVisible(false);

    }
        @FXML
        private void showPane(ActionEvent event) throws IOException{
            //hamburger_l.setVisible(false);
            hamburger_r.setVisible(false);
            rootPane.setLeft(leftPane);
            

        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	hamburger_r.setVisible(false);
    }    
    
}
