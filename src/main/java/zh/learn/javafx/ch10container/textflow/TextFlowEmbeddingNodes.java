package zh.learn.javafx.ch10container.textflow;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TextFlowEmbeddingNodes extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text tx1 = new Text("I, ");

        RadioButton rb1 = new RadioButton("Mr.");
        RadioButton rb2 = new RadioButton("Ms.");
        rb1.setSelected(true);

        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);

        TextField nameFld = new TextField();
        nameFld.setPromptText("Your Name");

        Text tx2 = new Text(", acknowledge the receipt of this letter... \n\n" +
                "Sincerely,\n\n");

        Button submitFormBtn = new Button("Submit Form");

        TextFlow root = new TextFlow(tx1, rb1, rb2, nameFld, tx2, submitFormBtn);

        root.setPrefWidth(350);
        root.setLineSpacing(5);
        Aux.style(root);

        Aux.showStage(stage, root, "Creating Forms Using TextFlow");
    }
}
