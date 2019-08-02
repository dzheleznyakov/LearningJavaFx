package zh.learn.javafx.ch12control.pickers;

import javafx.application.Application;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ColorPickerTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ColorPicker bgColor = new ColorPicker(Color.RED);

        Rectangle rect = new Rectangle(0, 0, 100, 50);
        rect.setFill(bgColor.getValue());
        rect.setStyle("-fx-stroke-width: 2; -fx-stroke: black;");

        bgColor.setOnAction(e -> rect.setFill(bgColor.getValue()));

        HBox root = new HBox(new Label("Color:"), bgColor, rect);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ColorPicker Controls");
    }
}
