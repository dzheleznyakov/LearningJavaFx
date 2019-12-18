package zh.learn.javafx.ch29fxml;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class LoginTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new LoginControl();
        Aux.showStage(stage, root, "Using FXML Custom Control");
    }
}
