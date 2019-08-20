package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class BloomTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text text = new Text("Bloom");
        text.setFill(Color.YELLOW);
        text.setFont(Font.font(null, FontWeight.BOLD, 24));
        Bloom bloom = new Bloom(0.10);
        text.setEffect(bloom);
        Rectangle rect = new Rectangle(100, 50, Color.GREEN);

        StackPane spane = new StackPane();
        spane.getChildren().addAll(rect, text);

        GridPane sliders = getSlidersPane(bloom);

        BorderPane root = new BorderPane();
        root.setCenter(spane);
        root.setBottom(sliders);
        Aux.style(root);

        Aux.showStage(stage, root, "Using the Bloom Effect");
    }

    private GridPane getSlidersPane(Bloom bloom) {
        Slider thresholdSlider = new Slider(0.0, 1.0, 0.1);
        thresholdSlider.setMajorTickUnit(0.1);
        thresholdSlider.setShowTickLabels(true);
        bloom.thresholdProperty().bind(thresholdSlider.valueProperty());

        GridPane grid = new GridPane();
        grid.addRow(0, new Label("Threshold:"), thresholdSlider);

        return grid;
    }
}
