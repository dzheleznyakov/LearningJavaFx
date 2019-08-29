package zh.learn.javafx.ch22animations.transitions;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class FadeTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
            Rectangle rect = new Rectangle(200, 50, Color.RED);
            HBox root = new HBox(rect);
            Aux.showStage(stage, root, "Fade-in and Fade-out");

        FadeTransition fadeInOut = new FadeTransition(Duration.seconds(2), rect);
        fadeInOut.setFromValue(1.0);
        fadeInOut.setToValue(0.20);
        fadeInOut.setCycleCount(FadeTransition.INDEFINITE);
        fadeInOut.setAutoReverse(true);
        fadeInOut.play();
    }
}
