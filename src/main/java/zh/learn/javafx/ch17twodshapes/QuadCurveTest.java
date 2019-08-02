package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class QuadCurveTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        QuadCurve qc1 = new QuadCurve(0, 100, 20, 0, 150, 100);
        qc1.setFill(Color.TRANSPARENT);
        qc1.setStroke(Color.BLACK);

        QuadCurve qc2 = new QuadCurve(0, 100, 20, 0, 150, 100);
        qc2.setFill(Color.LIGHTGRAY);

        HBox root = new HBox(10, qc1, qc2);
        Aux.style(root);

        Aux.showStage(stage, root, "Using QuadCurves");
    }
}
