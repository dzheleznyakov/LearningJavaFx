package zh.learn.javafx.ch12control.chooser;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileChooserTest extends Application {
    private Stage primaryStage;
    private HTMLEditor resumeEditor;
    private final FileChooser fileDialog = new FileChooser();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        resumeEditor = new HTMLEditor();
        resumeEditor.setPrefSize(600, 300);


        fileDialog.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("HTML Files", "*.html", "*.html"));

        Button openBtn = new Button("Open");
        Button saveBtn = new Button("Save");
        Button closeBtn = new Button("Close");
        openBtn.setOnAction(e -> openFile());
        saveBtn.setOnAction(e -> saveFile());
        closeBtn.setOnAction(e -> stage.close());

        HBox buttons = new HBox(20, openBtn, saveBtn, closeBtn);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        VBox root = new VBox(resumeEditor, buttons);
        root.setSpacing(20);
        Aux.style(root);

        Aux.showStage(stage, root, "Editing Resume in HTML Format");
    }

    private void openFile() {
        fileDialog.setTitle("Open Resume");
        File file = fileDialog.showOpenDialog(primaryStage);
        if (file == null) {
            return;
        }

        try {
            byte[] resume = Files.readAllBytes(file.toPath());
            resumeEditor.setHtmlText(new String(resume));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
        fileDialog.setTitle("Save Resume");
        fileDialog.setInitialFileName("untitled.htm");
        File file = fileDialog.showSaveDialog(primaryStage);
        if (file == null) {
            return;
        }

        try {
            String html = resumeEditor.getHtmlText();
            Files.write(file.toPath(), html.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
