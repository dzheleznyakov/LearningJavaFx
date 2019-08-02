package zh.learn.javafx.ch10container.stackpane;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class StackPaneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(200, 50);
        rect.setStyle("-fx-fill: lavender;" +
                "-fx-stroke-type: inside;" +
                "-fx-stroke-dash-array: 5 5;" +
                "-fx-stroke-width: 1;" +
                "-fx-stroke: black;" +
                "-fx-stroke-radius: 5;");

        Text text = new Text("A Rectangle");

        StackPane root = new StackPane(rect, text);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Aux.showStage(stage, root, "Using StackPane");
    }
}
