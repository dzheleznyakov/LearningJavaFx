package zh.learn.javafx.ch29fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.io.IOException;
import java.net.URL;

public class FxIncludeTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        URL fxmlUrl = getClass()
                .getClassLoader()
                .getResource("fxml/maindoc.fxml");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlUrl);
        VBox root = loader.load();
        Aux.showStage(stage, root, "Nesting Documents in FXML");
    }
}
