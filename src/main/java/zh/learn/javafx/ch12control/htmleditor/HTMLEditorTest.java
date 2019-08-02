package zh.learn.javafx.ch12control.htmleditor;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class HTMLEditorTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        HTMLEditor editor = new HTMLEditor();
        editor.setPrefSize(600, 300);

        TextArea html = new TextArea();
        html.setPrefSize(600, 300);
        html.setStyle("-fx-font-size:10pt; -fx-font-family: \"Courier New\";");

        Button htmlToText = new Button("Convert HTML to Text");
        Button textToHtml = new Button("Convert Text to HTML");
        htmlToText.setOnAction(e -> editor.setHtmlText(html.getText()));
        textToHtml.setOnAction(e -> html.setText(editor.getHtmlText()));

        HBox buttons = new HBox(htmlToText, textToHtml);
        buttons.setSpacing(10);

        VBox root = new VBox(editor, buttons, html);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using an HTMLEditor");
    }
}
