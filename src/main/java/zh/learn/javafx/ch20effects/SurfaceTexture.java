package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class SurfaceTexture extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text text = new Text();
        text.setText("Texture");
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 72));
        text.setBoundsType(TextBoundsType.VISUAL);

        Lighting effect = new Lighting();
        effect.setBumpInput(null);
        text.setEffect(effect);

        CheckBox bumpCbx = new CheckBox("Use a GaussianBlur Bump Input?");
        bumpCbx.selectedProperty().addListener((prop, oldvalue, newValue) -> {
            GaussianBlur gaussianBlur = newValue ? new GaussianBlur(20) : null;
            effect.setBumpInput(gaussianBlur);
        });

        Slider scaleSlider = new Slider(0, 10, 1.5);
        effect.surfaceScaleProperty().bind(scaleSlider.valueProperty());
        scaleSlider.setShowTickLabels(true);
        scaleSlider.setMajorTickUnit(2.0);
        scaleSlider.setShowTickMarks(true);

        VBox root = new VBox(10, text, bumpCbx, scaleSlider);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Surface Scale and Bump Input");
    }
}
