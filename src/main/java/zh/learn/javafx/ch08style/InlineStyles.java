package zh.learn.javafx.ch08style;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InlineStyles extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");

        yesBtn.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        Button openBtn = new Button("Open");
        Button saveBtn = new Button("Save");
        Button closeBtn = new Button("Close");

        VBox vb1 = new VBox();
        vb1.setPadding(new Insets(10, 10, 10, 10));
        vb1.getChildren().addAll(yesBtn, noBtn, cancelBtn);

        VBox vb2 = new VBox();
        vb2.setPadding(new Insets(10, 10, 10, 10));
        vb2.getChildren().addAll(openBtn, saveBtn, closeBtn);

        vb1.setStyle("-fx-border-width: 4.0; -fx-border-color: blue;");
        vb2.setStyle("-fx-border-width: 4.0; -fx-border-color: blue;");

        HBox root = new HBox();
        root.setSpacing(20);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().addAll(vb1, vb2);

        root.setStyle("-fx-border-width: 10.0; -fx-border-color: navy;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Inline Styles");
        stage.show();
    }
}
