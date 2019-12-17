package zh.learn.javafx.ch29fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        URL fxmlUrl = getClass()
                .getClassLoader()
                .getResource("fxml/greetings.fxml");

        String resourcePath = "resourcebundles/greetings";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourcePath);

        Label defaultGreetingLbl = FXMLLoader.load(fxmlUrl, resourceBundle);

        Locale.setDefault(new Locale("hi", "in"));

        resourceBundle = ResourceBundle.getBundle(resourcePath);

        Label indianGreetingLbl = FXMLLoader.load(fxmlUrl, resourceBundle);

        VBox root = new VBox(5, defaultGreetingLbl, indianGreetingLbl);
        Aux.showStage(stage, root, "Using a ResourceBundle in FXML");
    }
}
