package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class CommonControll {

    static void changeScreen(Parent root, Stage stage) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    static boolean ConfirmationDialogueOK(String meassage, String title, String header){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, meassage);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setGraphic(null);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
             return  true;
        }
        return false;
    }
    //overloaded
    static boolean ConfirmationDialogueOK(String meassage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, meassage);
        alert.setTitle("Confimation");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
             return  true;
        }
        return false;
    }

}
