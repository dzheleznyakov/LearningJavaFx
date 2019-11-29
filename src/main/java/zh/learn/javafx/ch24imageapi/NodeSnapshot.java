package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Callback;
import zh.learn.javafx.Aux;

public class NodeSnapshot extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();

        Label nameLbl = new Label("Name:");
        TextField nameField = new TextField("Prema");

        Button syncSnapshotBtn = new Button("Synchronous Snapshot");
        syncSnapshotBtn.setOnAction(e -> syncSnapshot(nameField));

        Button asyncSnapshotBtn = new Button("Asynchronous Snapshot");
        asyncSnapshotBtn.setOnAction(e -> asyncSnapshot(nameField));

        root.setHgap(10);
        root.addRow(0, nameLbl, nameField, syncSnapshotBtn);
        root.add(asyncSnapshotBtn, 2, 1);

        Aux.showStage(stage, root, "Taking the Snapshot of a Node");
    }

    private void syncSnapshot(Node node) {
        SnapshotParameters params = getParams();
        WritableImage image = node.snapshot(params, null);
        ImageUtil.saveToFile(image);
    }

    private void asyncSnapshot(Node node) {
        Callback<SnapshotResult, Void> callback = result -> {
            WritableImage image = result.getImage();
            ImageUtil.saveToFile(image);
            return null;
        };

        SnapshotParameters params = getParams();
        node.snapshot(callback, params, null);
    }

    private SnapshotParameters getParams() {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.RED);
        Transform tf = new Scale(0.8, 0.8)
                .createConcatenation(new Rotate(10));
        params.setTransform(tf);
        return params;
    }
}
