package zh.learn.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Temp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label text = new Label("abc");
        System.out.println(text.getChildrenUnmodifiable());

        Platform.exit();
    }
}
