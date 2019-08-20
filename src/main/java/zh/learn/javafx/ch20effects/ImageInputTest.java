package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.net.URL;

public class ImageInputTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String path = "picture/randomness.jpg";
        URL url = getClass().getClassLoader().getResource(path);

        Node node;
        if (url == null) {
            node = new Text("Missing image file " + path + " in classpath.");
        } else {
            ImageInput imageInputEffect = new ImageInput();
            double requestedWidth = 100;
            double requestedHeight = 50;
            boolean preserveRation = false;
            boolean smooth = true;
            Image image = new Image(url.toExternalForm(),
                    requestedWidth,
                    requestedHeight,
                    preserveRation,
                    smooth);
            imageInputEffect.setSource(image);
            node = new Rectangle(100, 50);
            GaussianBlur dsEffect = new GaussianBlur();
            dsEffect.setInput(imageInputEffect);
            node.setEffect(dsEffect);
        }

        HBox root = new HBox(node);
        Aux.style(root);

        Aux.showStage(stage, root, "Applying the ImageInput Effect");
    }
}
