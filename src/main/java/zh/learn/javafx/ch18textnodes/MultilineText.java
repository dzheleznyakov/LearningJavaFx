package zh.learn.javafx.ch18textnodes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class MultilineText extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String text = "Strange fits of passion have I known: \n" +
                "And I will dare to tell, \n" +
                "But in the lover's ear alone, \n" +
                "What once to me befell.";

        Text t1 = new Text(text);
        t1.setLineSpacing(5);

        Text t2 = new Text(text);
        t2.setTextAlignment(TextAlignment.RIGHT);

        Text t3 = new Text(text);
        t3.setWrappingWidth(100);

        HBox root = new HBox(20, t1, t2, t3);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Multiline Text Nodes");
    }
}
