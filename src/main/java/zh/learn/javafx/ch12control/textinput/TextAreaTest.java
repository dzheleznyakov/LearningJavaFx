package zh.learn.javafx.ch12control.textinput;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TextAreaTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField title = new TextField("Luci");
        title.setPromptText("Your poem title goes here");

        TextArea poem = new TextArea();
        poem.setPromptText("Your poem goes here");
        poem.setPrefColumnCount(20);
        poem.setPrefRowCount(10);
        poem.appendText("I told her this: her laughter light\n" +
                "Is ringing in my ears:\n" +
                "And when I think upon that night\n" +
                "My eyes are dim with tears.");

        Button printBtn = new Button("Print Poem Details");
        printBtn.setOnAction(e -> print(poem));

        VBox root = new VBox(new Label("Title:"), title,
                new Label("Poem:"), poem, printBtn);
        Aux.style(root);

        Aux.showStage(stage, root, "Using TextArea Controls");
    }

    public void print(TextArea poem) {
        System.out.println("Poem Length: " + poem.getLength());
        System.out.println("Poem Text:\n" + poem.getText());
        System.out.println();

        ObservableList<CharSequence> list = poem.getParagraphs();
        int size = list.size();
        System.out.println("Paragraph Count: " + size);
        for (int i = 0; i < size; i++) {
            CharSequence cs = list.get(i);
            System.out.println("Paragraph #" + (i + 1) + ", Characters=" + cs.length());
            System.out.println(cs);
        }
    }
}
