package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class MotionBlurTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t1 = new Text("Motion Blur");
        t1.setFont(Font.font(null, FontWeight.BOLD, 36));
        MotionBlur mbEffect = new MotionBlur();
        t1.setEffect(mbEffect);

        Slider radiusSlider = new Slider(0.0, 63.0, 10.0);
        radiusSlider.setMajorTickUnit(10);
        radiusSlider.setShowTickLabels(true);
        mbEffect.radiusProperty().bind(radiusSlider.valueProperty());

        Slider angleSlider = new Slider(0.0, 360.0, 0);
        angleSlider.setMajorTickUnit(10);
        angleSlider.setShowTickLabels(true);
        mbEffect.angleProperty().bind(angleSlider.valueProperty());

        HBox pane = new HBox(10, new Label("Radius:"), radiusSlider,
                new Label("Angle:"), angleSlider);

        BorderPane root = new BorderPane();
        root.setCenter(t1);
        root.setBottom(pane);
        Aux.style(root);

        Aux.showStage(stage, root, "Using the MotionBlur Effect");
    }
}
