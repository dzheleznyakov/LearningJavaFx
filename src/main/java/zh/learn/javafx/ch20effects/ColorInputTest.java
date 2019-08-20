package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ColorInputTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ColorInput effect = new ColorInput();
        effect.setWidth(100);
        effect.setHeight(50);
        effect.setPaint(Color.LIGHTGRAY);

        GridPane sliders = getSliders(effect);

        Rectangle r1 = new Rectangle(100, 50);
        r1.setEffect(effect);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.TRANSPARENT);

        VBox root = new VBox(5, r1, sliders);
        Aux.style(root);

        Aux.showStage(stage, root, "Using the ColorInput Effect");
    }

    private GridPane getSliders(ColorInput effect) {
        Slider widthSlider = Aux.getSlider(0, 150, 5, effect.widthProperty());
        Slider heightSlider = Aux.getSlider(0, 75, 5, effect.heightProperty());

        GridPane grid = new GridPane();
        grid.addRow(0, new Label("Width:"), widthSlider);
        grid.addRow(1, new Label("Height:"), heightSlider);

        return grid;
    }
}
