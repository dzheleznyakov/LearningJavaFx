package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class PathFillRule extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PathElement[] pathElements1 = {
                new MoveTo(50, 0),
                new LineTo(0, 50),
                new LineTo(100, 50),
                new LineTo(50, 0),
                new MoveTo(90, 15),
                new LineTo(40, 65),
                new LineTo(140, 65),
                new LineTo(90, 15)
        };

        PathElement[] pathElements2 = {
                new MoveTo(50, 0),
                new LineTo(0, 50),
                new LineTo(100, 50),
                new LineTo(50, 0),
                new MoveTo(90, 15),
                new LineTo(140, 65),
                new LineTo(40, 65),
                new LineTo(90, 15)
        };

        Path p1 = new Path(pathElements1);
        p1.setFill(Color.LIGHTGRAY);

        Path p2 = new Path(pathElements2);
        p2.setFill(Color.LIGHTGRAY);

        Path p3 = new Path(pathElements1);
        p3.setFill(Color.LIGHTGRAY);
        p3.setFillRule(FillRule.EVEN_ODD);

        Path p4 = new Path(pathElements2);
        p4.setFill(Color.LIGHTGRAY);
        p4.setFillRule(FillRule.EVEN_ODD);

        HBox root = new HBox(10, p1, p2, p3, p4);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Fill Rules for Paths");
    }
}
