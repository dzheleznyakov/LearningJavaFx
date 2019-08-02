package zh.learn.javafx.ch18textnodes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TextFillAndStroke extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t1 = new Text("Stroke and fill!");
        t1.setStroke(Color.RED);
        t1.setFill(Color.WHITE);
        t1.setFont(new Font(36));

        Text t2 = new Text("Dashed Stroke!");
        t2.setStroke(Color.BLACK);
        t2.setFill(Color.WHITE);
        t2.setFont(new Font(36));
        t2.getStrokeDashArray().addAll(5.0, 5.0);

        HBox root = new HBox(20, t1, t2);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Stroke and Fill for Text Nodes");
    }
}
