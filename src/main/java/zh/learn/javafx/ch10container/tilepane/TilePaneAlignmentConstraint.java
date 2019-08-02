package zh.learn.javafx.ch10container.tilepane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TilePaneAlignmentConstraint extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button b12 = new Button("One\nTwo");
        Button b3 = new Button("Three");
        Button b4 = new Button("Four");
        Button b5 = new Button("Five");
        Button b6 = new Button("Six");

        TilePane.setAlignment(b3, Pos.BOTTOM_RIGHT);

        TilePane root = new TilePane(b12, b3, b4, b5, b6);
        root.setPrefColumns(3);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Alignment Constraints in TilePane");
    }
}
