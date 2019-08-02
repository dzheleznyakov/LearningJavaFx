package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class CombiningShapesTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle c1 = new Circle(0, 0, 20);
        Circle c2 = new Circle(15, 0, 20);

        Shape union = Shape.union(c1, c2);
        union.setStroke(Color.BLACK);
        union.setFill(Color.LIGHTGRAY);

        Shape intersection = Shape.intersect(c1, c2);
        intersection.setStroke(Color.BLACK);
        intersection.setFill(Color.LIGHTGRAY);

        Shape subtraction = Shape.subtract(c1, c2);
        subtraction.setStroke(Color.BLACK);
        subtraction.setFill(Color.LIGHTGRAY);

        HBox root = new HBox(20, union, intersection, subtraction);
        Aux.style(root);

        Aux.showStage(stage, root, "Combining Shapes");
    }
}
