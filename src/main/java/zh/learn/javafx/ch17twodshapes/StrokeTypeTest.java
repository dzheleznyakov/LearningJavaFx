package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class StrokeTypeTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle r1 = new Rectangle(50, 50);
        r1.setFill(Color.LIGHTGRAY);

        Rectangle r2 = new Rectangle(50, 50);
        r2.setFill(Color.LIGHTGRAY);
        r2.setStroke(Color.BLACK);
        r2.setStrokeWidth(4);
        r2.setStrokeType(StrokeType.INSIDE);

        Rectangle r3 = new Rectangle(50, 50);
        r3.setFill(Color.LIGHTGRAY);
        r3.setStroke(Color.BLACK);
        r3.setStrokeWidth(4);

        Rectangle r4 = new Rectangle(50, 50);
        r4.setFill(Color.LIGHTGRAY);
        r4.setStroke(Color.BLACK);
        r4.setStrokeWidth(4);
        r4.setStrokeType(StrokeType.OUTSIDE);

        HBox root = new HBox(r1, r2, r3, r4);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Different Stroke Types for Shapes");
    }
}
