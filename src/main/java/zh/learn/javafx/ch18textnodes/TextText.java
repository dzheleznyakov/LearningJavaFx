package zh.learn.javafx.ch18textnodes;

import javafx.application.Application;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TextText extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t1 = new Text("Hello Text Node!");

        Text t2 = new Text("Bold and Big");
        t2.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        Text t3 = new Text("Reflection");
        t3.setEffect(new Reflection());
        t3.setStroke(Color.BLACK);
        t3.setFill(Color.WHITE);
        t3.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        HBox root = new HBox(20, t1, t2, t3);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Text Nodes");
    }
}
