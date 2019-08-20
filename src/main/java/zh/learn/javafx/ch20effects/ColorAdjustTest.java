package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.net.URL;

public class ColorAdjustTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ColorAdjust effect = new ColorAdjust();

        Node node = getImageNode();
        node.setEffect(effect);

        GridPane controller = getController(effect);

        BorderPane root = new BorderPane();
        root.setCenter(node);
        root.setBottom(controller);
        Aux.style(root);

        Aux.showStage(stage, root, "Applying the ColorAdjust Effect");
    }

    private GridPane getController(ColorAdjust effect) {
        Slider hueSlider = new Slider(-1.0, 1.0, 0.0);
        effect.hueProperty().bind(hueSlider.valueProperty());

        Slider saturationSlider = new Slider(-1.0, 1.0, 0.0);
        effect.saturationProperty().bind(saturationSlider.valueProperty());

        Slider brightnessSlider = new Slider(-1.0, 1.0, 0.0);
        effect.brightnessProperty().bind(brightnessSlider.valueProperty());

        Slider contrastSlider = new Slider(-1.0, 1.0, 0.0);
        effect.contrastProperty().bind(contrastSlider.valueProperty());

        Slider[] sliders = new Slider[]{
                hueSlider, saturationSlider, brightnessSlider, contrastSlider
        };

        for (Slider s : sliders) {
            s.setPrefWidth(300);
            s.setMajorTickUnit(0.10);
            s.setShowTickLabels(true);
            s.setShowTickLabels(true);
        }

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(10);
        pane.addRow(0, new Label("Hue:"), hueSlider);
        pane.addRow(1, new Label("Saturation"), saturationSlider);
        pane.addRow(2, new Label("Brightness:"), brightnessSlider);
        pane.addRow(3, new Label("Contrast:"), contrastSlider);

        return pane;
    }

    private Node getImageNode() {
        Node node;
        String path = "picture/randomness.jpg";
        URL url = getClass().getClassLoader().getResource(path);

        if (url != null) {
            node = new ImageView(url.toExternalForm());
        } else {
            System.out.println("Missing image file " + path);
            node = new StackPane(new Rectangle(100, 500, Color.LIGHTGRAY),
                    new Text("Color Adjust"));
        }
        return node;
    }
}
