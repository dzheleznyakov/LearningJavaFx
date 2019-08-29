package zh.learn.javafx.ch22animations.transitions;

import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class StrokeTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(200, 50, Color.WHITE);
        rect.setStrokeWidth(5);
        HBox.setMargin(rect, new Insets(5));
        HBox root = new HBox(rect);
        root.setPadding(new Insets(5));
        Aux.showStage(stage, root, "Stroke Transition");

        StrokeTransition strokeTransition = new StrokeTransition(Duration.seconds(2), rect);
        strokeTransition.setFromValue(Color.RED);
        strokeTransition.setToValue(Color.BLUE);
        strokeTransition.setCycleCount(StrokeTransition.INDEFINITE);
        strokeTransition.setAutoReverse(true);
        strokeTransition.play();
    }
}
