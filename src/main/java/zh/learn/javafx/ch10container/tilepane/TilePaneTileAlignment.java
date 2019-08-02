package zh.learn.javafx.ch10container.tilepane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TilePaneTileAlignment extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TilePane tileAlignCenter = createTilePane(Pos.CENTER);
        TilePane tileAlignTopRight = createTilePane(Pos.TOP_LEFT);

        HBox root = new HBox(tileAlignCenter, tileAlignTopRight);
        root.setFillHeight(false);
        Aux.showStage(stage, root, "The tileAlignment Property for TilePane");
    }

    private TilePane createTilePane(Pos tileAlignment) {
        Button[] buttons = new Button[] {
                new Button("Tiles"),
                new Button("are"),
                new Button("aligned"),
                new Button("at"),
                new Button(tileAlignment.toString())
        };

        TilePane tpane = new TilePane(5, 5, buttons);
        tpane.setTileAlignment(tileAlignment);
        tpane.setPrefColumns(3);
        Aux.style(tpane);
        return tpane;
    }
}
