package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebviewController implements Initializable {

    @FXML
    private WebView web;
    @FXML
    private Label webaddress;
    static String url="https://www.google.com";
    
    void loadPage(){
        final WebEngine engine = web.getEngine();
        engine.load(url);
        webaddress.setText(engine.getLocation());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadPage();
    }    
    
}
