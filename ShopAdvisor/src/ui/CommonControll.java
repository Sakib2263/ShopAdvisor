package ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommonControll {

    static void changeScreen(Parent root, Stage stage) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
