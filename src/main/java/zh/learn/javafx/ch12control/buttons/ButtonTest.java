package zh.learn.javafx.ch12control.buttons;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ButtonTest extends Application {
    Label msgLbl = new Label("Press Enter or Esc key to see the message");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button newBtn = new Button("New");
        newBtn.setOnAction(e -> newDocument());

        Button saveBtn = new Button("Save");
        saveBtn.setDefaultButton(true);
        saveBtn.setOnAction(e -> save());

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setCancelButton(true);
        cancelBtn.setOnAction(e -> cancel());

        HBox buttonBox = new HBox(newBtn, saveBtn, cancelBtn);
        buttonBox.setSpacing(15);
        VBox root = new VBox(msgLbl, buttonBox);
        root.setSpacing(15);
        Aux.style(root);

        Aux.showStage(stage, root, "Command Buttons");
    }

    public void newDocument() {
        msgLbl.setText("Creating a new document...");
    }

    public void save() {
        msgLbl.setText("Saving...");
    }

    public void cancel() {
        msgLbl.setText("Cancelling...");
    }
}
