package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SceneSnapshot extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        Label nameLbl = new Label("Name:");
        TextField nameField = new TextField("Prema");

        Button syncSnapshotBtn = new Button("Synchronous Snapshot");
        syncSnapshotBtn.setOnAction(e -> syncSnapshot(scene));

        Button asyncSnapshotBtn = new Button("Asynchronous Snapshot");
        asyncSnapshotBtn.setOnAction(e -> asyncSnapshot(scene));

        root.setHgap(10);
        root.addRow(0, nameLbl, nameField, syncSnapshotBtn);
        root.add(asyncSnapshotBtn, 2, 1);

        stage.setScene(scene);
        stage.setTitle("Taking the Snapshot of a Scene");
        stage.show();
    }

    private void syncSnapshot(Scene scene) {
        WritableImage image = scene.snapshot(null);
        ImageUtil.saveToFile(image);
    }

    private void asyncSnapshot(Scene scene) {
        Callback<SnapshotResult, Void> callback = result -> {
            WritableImage image = result.getImage();
            ImageUtil.saveToFile(image);
            return null;
        };
        scene.snapshot(callback, null);
    }
}
