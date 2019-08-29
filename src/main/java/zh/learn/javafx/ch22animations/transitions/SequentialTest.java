package zh.learn.javafx.ch22animations.transitions;

import javafx.animation.FillTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

import static javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT;

public class SequentialTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(20, 10, Color.RED);

        Circle path = new Circle(100, 100, 100);
        path.setFill(null);
        path.setStroke(Color.BLACK);

        Pane root = new Pane(rect, path);
        root.setPrefSize(200, 200);
        Aux.showStage(stage, root, "Sequential Transition");

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1));
        scaleTransition.setFromX(1.0);
        scaleTransition.setToX(2.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToY(2.0);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        FillTransition fillTransition = new FillTransition(Duration.seconds(1));
        fillTransition.setFromValue(Color.RED);
        fillTransition.setToValue(Color.BLUE);
        fillTransition.setCycleCount(2);
        fillTransition.setAutoReverse(true);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(200));
        pauseTransition.setOnFinished(e -> System.out.println("Ready to circle..."));

        PathTransition pathTransition = new PathTransition(Duration.seconds(2), path);
        pathTransition.setOrientation(ORTHOGONAL_TO_TANGENT);

        SequentialTransition st = new SequentialTransition();
        st.setNode(rect);
        st.getChildren().addAll(scaleTransition, fillTransition, pauseTransition, pathTransition);
        st.setCycleCount(PathTransition.INDEFINITE);
        st.play();
    }
}
