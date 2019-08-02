package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class LineTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Line line1 = new Line();

        Line line2 = new Line(0, 0, 50, 0);
        line2.setStrokeWidth(1.0);

        Line line3 = new Line(0, 50, 50, 0);
        line3.setStrokeWidth(2.0);
        line3.setStroke(Color.RED);

        Line line4 = new Line(0, 0, 50, 50);
        line4.setStrokeWidth(5.0);
        line4.setStroke(Color.BLUE);

        HBox root = new HBox(10, line1, line2, line3, line4);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Lines");
    }
}
