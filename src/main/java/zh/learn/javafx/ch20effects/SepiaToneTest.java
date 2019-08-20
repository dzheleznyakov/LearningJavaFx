package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class SepiaToneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t = new Text("SepiaTone");
        t.setFill(Color.WHITE);
        t.setFont(Font.font(null, FontWeight.BOLD, 24));
        SepiaTone sepiaTone = new SepiaTone(0.5);
        t.setEffect(sepiaTone);

        Rectangle rect = new Rectangle(150, 50, Color.BLACK);

        StackPane spane = new StackPane(rect, t);

        GridPane sliders = getSliders(sepiaTone);

        BorderPane root = new BorderPane();
        root.setCenter(spane);
        root.setBottom(sliders);
        Aux.style(root);

        Aux.showStage(stage, root, 400, 200, "Using the SepiaTone Effect");
    }

    private GridPane getSliders(SepiaTone sepiaTone) {
        Slider levelSlider = Aux.getSlider(0, 1, 0.1, sepiaTone.levelProperty());

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.addRow(0, new Label("Level:"), levelSlider);
        return grid;
    }
}
