package zh.learn.javafx.ch21transformations;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class RotateTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect1 = new Rectangle(100, 50, Color.LIGHTGRAY);
        rect1.setStroke(Color.BLACK);

        Rectangle rect2 = new Rectangle(100, 50, Color.LIGHTGRAY);
        rect2.setStroke(Color.BLACK);
        rect2.setOpacity(0.5);

        Rotate rotate = new Rotate(30, 0, 0);
        rect2.getTransforms().addAll(rotate);

        Pane root = new Pane(rect1, rect2);
        root.setPrefSize(300, 80);
        Aux.showStage(stage, root, "Applying the Rotation Transformation");
    }
}
