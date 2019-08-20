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

public class DistantLightTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Light.Distant light = new Light.Distant(45, 60, Color.WHITE);

        Lighting effect = new Lighting();
        effect.setLight(light);
        effect.setSurfaceScale(8.0);

        Text text = new Text();
        text.setText("Distant");
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 72));
        text.setBoundsType(TextBoundsType.VISUAL);

        Rectangle rect = new Rectangle(300, 100);
        rect.setFill(Color.LIGHTGRAY);

        text.setEffect(effect);
        rect.setEffect(effect);

        StackPane sp = new StackPane(rect, text);
        BorderPane.setMargin(sp, new Insets(5));
        GridPane lightDirectionController = getDistantLightUI(light);
        GridPane controllersPane = LightingUtil.getPropertyControllers(effect);

        BorderPane root = new BorderPane();
        root.setCenter(sp);
        root.setRight(controllersPane);
        root.setBottom(lightDirectionController);
        Aux.style(root);

        Aux.showStage(stage, root, "Configuring a Distant Light");
    }

    private GridPane getDistantLightUI(Light.Distant light) {
        Slider azimuthSlider = LightingUtil.getSlider(0, 360, light.getAzimuth(), light.azimuthProperty());
        Slider elevationSlider = LightingUtil.getSlider(0, 360, light.getElevation(), light.elevationProperty());

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.addRow(0, new Label("Azimuth:"), azimuthSlider);
        pane.addRow(1, new Label("Elevation:"), elevationSlider);

        return pane;
    }
}
