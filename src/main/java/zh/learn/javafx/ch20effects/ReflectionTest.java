package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ReflectionTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t = new Text("Reflection");
        t.setFont(Font.font(null, FontWeight.BOLD, 24));
        Reflection reflection = new Reflection(2.0, 0.9, 1.0, 1.0);
        t.setEffect(reflection);

        GridPane sliders = getSliders(reflection);

        BorderPane root = new BorderPane();
        root.setCenter(t);
        BorderPane.setAlignment(t, Pos.TOP_CENTER);
        root.setBottom(sliders);
        Aux.style(root);
        Aux.showStage(stage, root, 600, 300, "Using the Reflection Effect");
    }

    private GridPane getSliders(Reflection reflection) {
        Slider topOffsetSlider = Aux.getSlider(0, 100, 5, reflection.topOffsetProperty());
        TextField topOffsetTf = new TextField();
        bind(topOffsetTf, topOffsetSlider);

        Slider fractionSlider = Aux.getSlider(0, 1, 0.1, reflection.fractionProperty());
        TextField fractionTf = new TextField();
        bind(fractionTf, fractionSlider);

        Slider topOpacitySlider = Aux.getSlider(0, 1, 0.1, reflection.topOpacityProperty());
        TextField topOpacityTf = new TextField();
        bind(topOpacityTf, topOpacitySlider);

        Slider bottomOpacitySlider = Aux.getSlider(0, 1, 0.1, reflection.bottomOpacityProperty());
        TextField bottomOpacityTf = new TextField();
        bind(bottomOpacityTf, bottomOpacitySlider);

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(10);
        grid.addRow(0, new Label("Top Offset:"), topOffsetSlider, topOffsetTf);
        grid.addRow(1, new Label("Fraction:"), fractionSlider, fractionTf);
        grid.addRow(2, new Label("Top Opacity:"), topOpacitySlider, topOpacityTf);
        grid.addRow(3, new Label("Bottom Opacity:"), bottomOpacitySlider, bottomOpacityTf);
        return grid;
    }

    private void bind(TextField tf, Slider slider) {
        tf.setPrefColumnCount(3);
        tf.setText(String.valueOf(slider.getValue()));
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double value = Double.parseDouble(newValue);
                slider.setValue(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        slider.valueProperty().addListener(((observable, oldValue, newValue) -> {
            tf.setText(String.valueOf(newValue));
        }));
    }
}
