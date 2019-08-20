package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class PointLightTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Light.Point light = new Light.Point(150, 50, 50, Color.WHITE);

        Lighting effect = new Lighting();
        effect.setLight(light);
        effect.setSurfaceScale(8.0);

        Text text = new Text();
        text.setText("Point");
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 72));
        text.setBoundsType(TextBoundsType.VISUAL);

        Rectangle rect = new Rectangle(300, 100);
        rect.setFill(Color.LIGHTGRAY);

        text.setEffect(effect);
        rect.setEffect(effect);

        StackPane sp = new StackPane(rect, text);
        BorderPane.setMargin(sp, new Insets(5));
        GridPane lightDirectionController = getPointLightUI(light);
        GridPane controllersPane = LightingUtil.getPropertyControllers(effect);

        BorderPane root = new BorderPane();
        root.setCenter(sp);
        root.setRight(controllersPane);
        root.setBottom(lightDirectionController);
        Aux.style(root);

        Aux.showStage(stage, root, "Configuring a Point Light");
    }

    private GridPane getPointLightUI(Light.Point light) {
        Slider xSlider = LightingUtil.getSlider(-200.0, 200.0, light.getX(), light.xProperty());
        Slider ySlider = LightingUtil.getSlider(-200.0, 200.0, light.getY(), light.yProperty());
        Slider zSlider = LightingUtil.getSlider(-200.0, 200.0, light.getZ(), light.zProperty());

        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.addRow(0, new Label("x:"), xSlider);
        pane.addRow(1, new Label("y:"), ySlider);
        pane.addRow(2, new Label("z:"), zSlider);

        return pane;
    }
}
