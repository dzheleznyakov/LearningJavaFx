package zh.learn.javafx.ch10container.vbox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class VBoxTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name");
        TextField nameFld = new TextField();
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        VBox root = new VBox(10);
        root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);
        Aux.style(root);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using VBox");
        stage.show();
    }
}
