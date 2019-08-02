package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class RectangleTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect1 = new Rectangle(100, 50, Color.LIGHTGRAY);

        Rectangle rect2 = new Rectangle(120, 20, 100, 50);
        rect2.setFill(Color.WHITE);
        rect2.setStroke(Color.BLACK);
        rect2.setArcWidth(10);
        rect2.setArcHeight(10);

        Pane root = new Pane();
        root.getChildren().addAll(rect1, rect2);

        Aux.showStage(stage, root, "Using Rectangles");
    }
}
