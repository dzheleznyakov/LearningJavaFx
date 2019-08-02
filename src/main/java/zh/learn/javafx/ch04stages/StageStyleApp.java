package zh.learn.javafx.ch04stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.stage.StageStyle.*;

public class StageStyleApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label styleLabel = new Label("Stage Style");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(styleLabel, closeButton);
        Scene scene = new Scene(root, 100, 70);
        stage.setScene(scene);

        stage.setTitle("The Style of a Stage");

        show(stage, styleLabel, DECORATED);
//        show(stage, styleLabel, UNDECORATED);
//        show(stage, styleLabel, TRANSPARENT);
//        show(stage, styleLabel, UNIFIED);
//        show(stage, styleLabel, UTILITY);
    }

    private void show(Stage stage, Label styleLabel, StageStyle style) {
        styleLabel.setText(style.toString());
        stage.initStyle(style);

        if (style == TRANSPARENT) {
            stage.getScene().setFill(null);
            stage.getScene().getRoot().setStyle("-fx-background-color: transparent");
        } else if (style == UNIFIED) {
            stage.getScene().setFill(Color.TRANSPARENT);
        }

        stage.show();
    }
}
