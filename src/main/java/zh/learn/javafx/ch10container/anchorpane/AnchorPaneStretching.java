package zh.learn.javafx.ch10container.anchorpane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class AnchorPaneStretching extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button leftRight = new Button("A button");
        AnchorPane.setTopAnchor(leftRight, 10.0);
        AnchorPane.setLeftAnchor(leftRight, 10.0);
        AnchorPane.setRightAnchor(leftRight, 10.0);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(leftRight);
        Aux.style(root);

        Aux.showStage(stage, root, "Stretching Children in an AnchorPane");
    }
}
