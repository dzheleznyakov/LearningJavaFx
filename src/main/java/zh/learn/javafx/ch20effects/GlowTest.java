package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Glow;
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

public class GlowTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t1 = new Text("Glow");
        t1.setFill(Color.YELLOW);
        t1.setFont(Font.font(null, FontWeight.BOLD, 24));
        Glow glow = new Glow(0.1);
        t1.setEffect(glow);

        Rectangle rect = new Rectangle(100, 50, Color.GREEN);

        StackPane spane = new StackPane(rect, t1);

        GridPane sliders = getSliders(glow);

        BorderPane root = new BorderPane();
        root.setCenter(spane);
        root.setBottom(sliders);
        Aux.style(root);

        Aux.showStage(stage, root, "Using the Glow Effect");


    }

    private GridPane getSliders(Glow glow) {
        Slider levelSlider = new Slider(0.0, 1.0, 0.1);
        levelSlider.setMajorTickUnit(0.1);
        levelSlider.setShowTickLabels(true);
        glow.levelProperty().bind(levelSlider.valueProperty());

        GridPane grid = new GridPane();
        grid.addRow(0, new Label("Level:"), levelSlider);

        return grid;
    }
}
