package zh.learn.javafx.ch22animations.transitions;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class ParallelTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(20, 10, Color.RED);
        HBox.setMargin(rect, new Insets(20));

        HBox root = new HBox(rect);
        Aux.showStage(stage, root, "Parallel Transition");

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
        fadeTransition.setFromValue(0.2);
        fadeTransition.setToValue(1.0);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2));
        rotateTransition.setFromAngle(0.0);
        rotateTransition.setToAngle(360.0);
        rotateTransition.setCycleCount(2);
        rotateTransition.setAutoReverse(true);

        ParallelTransition pt = new ParallelTransition();
        pt.setNode(rect);
        pt.getChildren().addAll(fadeTransition, rotateTransition);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.play();
    }
}
