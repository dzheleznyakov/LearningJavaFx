package zh.learn.javafx.ch22animations.transitions;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class FillTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(200, 50, Color.RED);
        HBox root = new HBox(rect);
        Aux.showStage(stage, root, "Fill Transition");

        FillTransition fillTransition = new FillTransition(Duration.seconds(2), rect);
        fillTransition.setFromValue(Color.BLUEVIOLET);
        fillTransition.setToValue(Color.AZURE);
        fillTransition.setCycleCount(FillTransition.INDEFINITE);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
    }
}
