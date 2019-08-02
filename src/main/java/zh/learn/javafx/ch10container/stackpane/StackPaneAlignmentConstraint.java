package zh.learn.javafx.ch10container.stackpane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class StackPaneAlignmentConstraint extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane root = getStackPane();
        Aux.showStage(stage, root, "StackPane Alignment Constraint");
    }

    static StackPane getStackPane() {
        Rectangle rect = new Rectangle(200, 60);
        rect.setFill(Color.LAVENDER);

        Text center = new Text("center");

        Text topLeft = new Text("top-left");
        StackPane.setAlignment(topLeft, Pos.TOP_LEFT);

        Text bottomRight = new Text("bottom-right");
        StackPane.setAlignment(bottomRight, Pos.BOTTOM_RIGHT);

        StackPane spane = new StackPane(rect, center, topLeft, bottomRight);
        spane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-borer-color: blue;");
        return spane;
    }
}
