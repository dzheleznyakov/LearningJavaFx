package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class CubicCurveTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CubicCurve cc1 = new CubicCurve(0, 50, 20, 0, 50, 80, 50, 0);
        cc1.setFill(Color.TRANSPARENT);
        cc1.setStroke(Color.BLACK);

        CubicCurve cc2 = new CubicCurve(0, 50, 20, 0, 50, 80, 50, 0);
        cc2.setFill(Color.LIGHTGRAY);

        HBox root = new HBox(10, cc1, cc2);
        Aux.style(root);

        Aux.showStage(stage, root, "Using CubicCurves");
    }
}
