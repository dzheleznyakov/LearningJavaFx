package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class PolygonTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Polygon triangle1 = new Polygon();
        triangle1.getPoints().addAll(50.0, 0.0,
                0.0, 50.0,
                100.0, 50.0);
        triangle1.setFill(Color.WHITE);
        triangle1.setStroke(Color.RED);

        Polygon parallelogram = new Polygon();
        parallelogram.getPoints().addAll(30.0, 0.0,
                130.0, 0.0,
                100.0, 50.0,
                0.0, 50.0);
        parallelogram.setFill(Color.YELLOW);
        parallelogram.setStroke(Color.BLACK);

        Polygon hexagon = new Polygon(100.0, 0.0,
                120.0, 20.0,
                120.0, 40.0,
                100.0, 60.0,
                80.0, 40.0,
                80.0, 20.0);
        hexagon.setFill(Color.WHITE);
        hexagon.setStroke(Color.BLACK);

        HBox root = new HBox(10, triangle1, parallelogram, hexagon);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Polygons");
    }
}
