package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class CircleTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle c1 = new Circle(0, 0, 40);
        c1.setFill(Color.LIGHTGRAY);

        Circle c2 = new Circle(10, 10, 40, Color.YELLOW);
        c2.setStroke(Color.BLACK);
        c2.setStrokeWidth(2.0);

        HBox root = new HBox(c1, c2);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Circle");
    }
}
