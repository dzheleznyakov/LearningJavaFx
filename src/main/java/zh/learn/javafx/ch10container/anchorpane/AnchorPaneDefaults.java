package zh.learn.javafx.ch10container.anchorpane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class AnchorPaneDefaults extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button bigBtn = new Button("This is a big button");
        Button smallBtn = new Button("Small button");

        AnchorPane root = new AnchorPane(bigBtn, smallBtn);

        Aux.showStage(stage, root, "Using Defaults in Anchor Pane");
    }
}
