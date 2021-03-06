package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
public class FeedBackController implements Initializable {

    @FXML
    private WebView bfcform;
    @FXML
    private WebView review1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        WebEngine engine1 = bfcform.getEngine();
        engine1.load("https://survey.zohopublic.com/zs/SAB0mt");
        WebEngine engine2 = review1.getEngine();
        engine2.load("https://sites.google.com/view/shopadvisor/customer-feedback");
    }
}
