package zh.learn.javafx.ch10container.hbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxAlignment extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        HBox hBox = new HBox(10);
        hBox.setPrefSize(200, 100);
        hBox.getChildren().addAll(okBtn, cancelBtn);

        hBox.setAlignment(Pos.BOTTOM_RIGHT);

        hBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.setTitle("Using HBox Alignment Property");
        stage.show();
    }
}
