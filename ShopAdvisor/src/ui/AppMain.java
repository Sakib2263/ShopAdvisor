package ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.TestServer;


public class AppMain extends Application {
    
    Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
       
        window = stage;
        window.setTitle("ShopAdvisor");
        
        TestServer server = new TestServer();
        server.setDaemon(true);
        server.start();
       
        stage.setScene(scene);
        stage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}