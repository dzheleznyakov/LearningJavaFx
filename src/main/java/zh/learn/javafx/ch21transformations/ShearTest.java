package zh.learn.javafx.ch21transformations;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ShearTest extends Application {
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

        Shear shear = new Shear(0.5, 0.5);
        rect2.getTransforms().addAll(shear);

        Group root = new Group(rect1, rect2);
        Aux.showStage(stage, root, "Applying the Shear Transformation");
    }
}
