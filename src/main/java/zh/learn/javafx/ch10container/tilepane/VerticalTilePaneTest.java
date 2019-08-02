package zh.learn.javafx.ch10container.tilepane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.time.Month;
import java.util.Arrays;

public class VerticalTilePaneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        double hgap = 5.0;
        double vgap = 5.0;
        TilePane root = new TilePane(Orientation.VERTICAL, hgap, vgap);
        root.setPrefRows(3);

        Arrays.stream(Month.values())
                .map(Month::toString)
                .map(Button::new)
                .peek(button -> button.setMaxHeight(Double.MAX_VALUE))
                .peek(button -> button.setMaxWidth(Double.MAX_VALUE))
                .forEach(root.getChildren()::add);

        Aux.style(root);
        Aux.showStage(stage, root, "A Vertical TilePane");
    }
}
