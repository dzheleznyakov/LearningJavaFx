package zh.learn.javafx.ch17twodshapes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ArcTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Arc arc1 = new Arc(0, 0, 50, 100, 0, 90);
        arc1.setFill(Color.LIGHTGRAY);

        Arc arc2 = new Arc(0, 0, 50, 100, 0, 90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.BLACK);

        Arc arc3 = new Arc(0, 0, 50, 100, 0, 90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.BLACK);
        arc3.setType(ArcType.CHORD);

        Arc arc4 = new Arc(0, 0, 50, 100, 0, 90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.BLACK);
        arc4.setType(ArcType.ROUND);

        Arc arc5 = new Arc(0, 0, 50, 100, 0, 90);
        arc5.setFill(Color.GRAY);
        arc5.setStroke(Color.BLACK);
        arc5.setType(ArcType.ROUND);

        HBox root = new HBox(10, arc1, arc2, arc3, arc4, arc5);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Arcs");
    }
}
