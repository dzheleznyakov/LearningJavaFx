package zh.learn.javafx.ch10container.stackpane;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class StackPaneOverlayTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane textOverRect = createStackPane("Hello", 1.0, true);
        StackPane rectOverText = createStackPane("Hello", 1.0, false);
        StackPane transparentRectOverText = createStackPane("Hello", 0.5, false);
        StackPane rectOverBigText = createStackPane("A bigger text", 1.0, false);
        StackPane transparentRectOverBigText = createStackPane("A bigger text", 0.5, false);

        HBox root = new HBox(textOverRect, rectOverText, transparentRectOverText, rectOverBigText, transparentRectOverBigText);
        Aux.showStage(stage, root, "Overlaying Rules in StackPane");
    }

    private StackPane createStackPane(String str, double rectOpacity, boolean rectFirst) {
        Rectangle rect = new Rectangle(60, 50);
        rect.setStyle("-fx-fill: lavender;" +
                "-fx-opacity: " + rectOpacity + ";");

        Text text = new Text(str);

        StackPane spane = new StackPane();
        if (rectFirst) {
            spane.getChildren().addAll(rect, text);
        } else {
            spane.getChildren().addAll(text, rect);
        }

        spane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-borer-color: blue;");
        return spane;
    }
}
