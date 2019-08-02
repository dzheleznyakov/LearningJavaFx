package zh.learn.javafx.ch10container.stackpane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class StackPaneAlignment extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane topLeft = createStackPane(Pos.TOP_LEFT);
        StackPane topRight = createStackPane(Pos.TOP_RIGHT);
        StackPane bottomLeft = createStackPane(Pos.BOTTOM_LEFT);
        StackPane bottomRight = createStackPane(Pos.BOTTOM_RIGHT);
        StackPane center = createStackPane(Pos.CENTER);

        double spacing = 10.0;
        HBox root = new HBox(spacing, topLeft, topRight, bottomLeft, bottomRight, center);
        Aux.showStage(stage, root, "Using StackPane");
    }

    private StackPane createStackPane(Pos alignment) {
        Rectangle rect = new Rectangle(80, 50);
        rect.setFill(Color.LAVENDER);

        Text text = new Text(alignment.toString());
        text.setStyle("-fx-font-size: 7pt;");

        StackPane spane = new StackPane(rect, text);
        spane.setAlignment(alignment);
        spane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-borer-color: blue;");
        return spane;
    }
}
