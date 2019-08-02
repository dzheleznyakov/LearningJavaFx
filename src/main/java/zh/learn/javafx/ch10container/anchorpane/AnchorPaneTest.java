package zh.learn.javafx.ch10container.anchorpane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class AnchorPaneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button topLeft = new Button("Top Left");
        AnchorPane.setTopAnchor(topLeft, 10.0);
        AnchorPane.setLeftAnchor(topLeft, 10.0);

        Button bottomRight = new Button("Bottom Right");
        AnchorPane.setBottomAnchor(bottomRight, 10.0);
        AnchorPane.setRightAnchor(bottomRight, 10.0);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(topLeft, bottomRight);
        Aux.style(root);

        Aux.showStage(stage, root, "Using an Anchor Pane");
    }
}
