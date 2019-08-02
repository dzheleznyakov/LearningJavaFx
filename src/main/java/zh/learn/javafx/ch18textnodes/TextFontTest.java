package zh.learn.javafx.ch18textnodes;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TextFontTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t1 = new Text();
        t1.setText(t1.getFont().toString());

        Text t2 = new Text();
        t2.setFont(Font.font("Arial", 12));
        t2.setText(t2.getFont().toString());

        Text t3 = new Text();
        t3.setFont(Font.font("Arial", FontWeight.BLACK, 12));
        t3.setText(t3.getFont().toString());

        Text t4 = new Text();
        t4.setFont(Font.font("Arial", FontWeight.THIN, FontPosture.ITALIC, 12));
        t4.setText(t4.getFont().toString());

        VBox root = new VBox(10, t1, t2, t3, t4);
        Aux.style(root);

        Font.getFontNames().forEach(System.out::println);

        Aux.showStage(stage, root, "Setting Fonts for text Nodes");
    }
}
