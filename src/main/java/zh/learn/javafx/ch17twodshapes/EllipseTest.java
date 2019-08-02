package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class EllipseTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Ellipse e1 = new Ellipse(50, 30);
        e1.setFill(Color.LIGHTGRAY);

        Ellipse e2 = new Ellipse(60, 30);
        e2.setFill(Color.YELLOW);
        e2.setStroke(Color.BLACK);
        e2.setStrokeWidth(2.0);

        Ellipse e3 = new Ellipse(30, 30);
        e3.setFill(Color.YELLOW);
        e3.setStroke(Color.BLACK);
        e3.setStrokeWidth(2.0);

        HBox root = new HBox(10, e1, e2, e3);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Ellipses");
    }
}
