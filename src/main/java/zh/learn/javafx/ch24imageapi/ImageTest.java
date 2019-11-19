package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ImageTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/randomness.jpg";

        double requestedWidth = 200;
        double requestedHeight = 100;
        boolean preserveRation = false;
        boolean smooth = true;
        Image image = new Image(imagePath, requestedWidth, requestedHeight, preserveRation, smooth);
        ImageView imageView = new ImageView(image);

        Aux.showStage(stage, new HBox(imageView), "Display an Image");
    }
}
