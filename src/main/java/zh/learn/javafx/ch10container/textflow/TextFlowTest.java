package zh.learn.javafx.ch10container.textflow;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TextFlowTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text tx1 = new Text("TextFlow layout pane is cool!");
        tx1.setFill(Color.RED);
        tx1.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Text tx2 = new Text(" It supports rich text display");
        tx2.setFill(Color.BLUE);

        Text tx3 = new Text("\nThis is a new paragraph, which was " +
                "created using the \\n newline character.");

        TextFlow root = new TextFlow(tx1, tx2, tx3);

        root.setPrefWidth(300);
        root.setLineSpacing(5);
        Aux.style(root);

        Aux.showStage(stage, root, "Using TextFlow");
    }
}
