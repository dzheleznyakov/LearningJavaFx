package zh.learn.javafx.ch22animations.transitions;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class PathTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(20, 10, Color.RED);

        Circle path = new Circle(100, 100, 100);
        path.setFill(null);
        path.setStroke(Color.BLACK);

        Group root = new Group(rect, path);
        Aux.showStage(stage, root, "Path Transition");

        PathTransition pt = new PathTransition(Duration.seconds(2), path, rect);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
    }
}
