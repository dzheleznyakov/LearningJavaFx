package zh.learn.javafx.ch21transformations;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TranslateTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect1 = new Rectangle(100, 50, Color.LIGHTGRAY);
        rect1.setStroke(Color.BLACK);

        Rectangle rect2 = new Rectangle(100, 50, Color.YELLOW);
        rect2.setStroke(Color.BLACK);

        Rectangle rect3 = new Rectangle(100, 50, Color.STEELBLUE);
        rect3.setStroke(Color.BLACK);

        Translate translate1 = new Translate(50, 10);
        rect2.getTransforms().addAll(translate1);

        rect3.setTranslateX(180);
        rect3.setTranslateY(20);

        Pane root = new Pane(rect1, rect2, rect3);
        root.setPrefSize(300, 80);

        Aux.showStage(stage, root, "Applying the Translation Transformation");
    }
}
