package zh.learn.javafx.ch29fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.io.IOException;
import java.net.URL;

public class SayHelloFXML extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        URL fxmlUrl = this.getClass()
                .getClassLoader()
                .getResource("fxml/sayhello.fxml");
        VBox root = FXMLLoader.load(fxmlUrl);
        Aux.showStage(stage, root, "Hello FXML");
    }
}
