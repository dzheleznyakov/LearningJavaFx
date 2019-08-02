package zh.learn.javafx.ch10container.gridpane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class GridPaneChildrenList extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button b1 = new Button("One One One One One");
        Button b2 = new Button("Two Two Two");
        Button b3 = new Button("Three");

        GridPane root = new GridPane();

        root.getChildren().addAll(b1, b2, b3);
        Aux.style(root);
        Aux.showStage(stage, root, "Adding Children to a GridPane");
    }
}
