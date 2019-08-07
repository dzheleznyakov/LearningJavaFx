package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class DropShadowTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(100, 50, Color.GRAY);
        DropShadow dsEffect = new DropShadow();
        rect.setEffect(dsEffect);

        GridPane controllerPane = getControllerPane(dsEffect);
        BorderPane root = new BorderPane();
        root.setCenter(rect);
        root.setBottom(controllerPane);
        Aux.style(root);

        controllerPane.getStylesheets().add("css/training/sliderstyle.css");

        Aux.showStage(stage, root, "Experimenting with DropShadow Effect");
    }

    private GridPane getControllerPane(final DropShadow dsEffect) {
        Slider offsetXSlider = new Slider(-200, 200, 0);
        dsEffect.offsetXProperty().bind(offsetXSlider.valueProperty());

        Slider offsetYSlider = new Slider(-200, 200, 0);
        dsEffect.offsetYProperty().bind(offsetYSlider.valueProperty());

        Slider radiusSlider = new Slider(0, 127, 10);
        dsEffect.radiusProperty().bind(radiusSlider.valueProperty());

        Slider spreadSlider = new Slider(0.0, 1.0, 0);
        dsEffect.spreadProperty().bind(spreadSlider.valueProperty());

        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        dsEffect.colorProperty().bind(colorPicker.valueProperty());

        ComboBox<BlurType> blurTypeList = new ComboBox<>();
        blurTypeList.setValue(dsEffect.getBlurType());
        blurTypeList.getItems().addAll(BlurType.ONE_PASS_BOX,
                BlurType.TWO_PASS_BOX,
                BlurType.THREE_PASS_BOX,
                BlurType.GAUSSIAN);
        dsEffect.blurTypeProperty().bind(blurTypeList.valueProperty());

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(10);
        pane.addRow(0, new Label("OffsetX:"), offsetXSlider);
        pane.addRow(1, new Label("OffsetY:"), offsetYSlider);
        pane.addRow(2, new Label("Radius:"), radiusSlider,
                new Label("Spread:"), spreadSlider);
        pane.addRow(3, new Label("Color:"), colorPicker,
                new Label("Blur Type:"), blurTypeList);

        return pane;
    }
}
