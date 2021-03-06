package zh.learn.javafx.ch04stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import static javafx.stage.Modality.APPLICATION_MODAL;
import static javafx.stage.Modality.NONE;
import static javafx.stage.Modality.WINDOW_MODAL;

public class StageModalityApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button ownedNoneButton = new Button("Owned None");
        ownedNoneButton.setOnAction(e -> showDialog(stage, NONE));

        Button nonOwnedNoneButton = new Button("Non-owned None");
        nonOwnedNoneButton.setOnAction(e -> showDialog(null, NONE));

        Button ownedWinButton = new Button("Owned Window Modal");
        ownedWinButton.setOnAction(e -> showDialog(stage, WINDOW_MODAL));

        Button nonOwnedWinButton = new Button("Non-owned Window Modal");
        nonOwnedWinButton.setOnAction(e -> showDialog(null, WINDOW_MODAL));

        Button ownedAppButton = new Button("Owned Application Modal");
        ownedAppButton.setOnAction(e -> showDialog(stage, APPLICATION_MODAL));

        Button nonOwnedAppButton = new Button("Non-owned Application modal");
        nonOwnedAppButton.setOnAction(e -> showDialog(null, APPLICATION_MODAL));

        VBox root = new VBox();
        root.getChildren().addAll(
                ownedNoneButton, nonOwnedNoneButton,
                ownedWinButton, nonOwnedWinButton,
                ownedAppButton, nonOwnedAppButton);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("The Primary Stage");
        stage.show();
    }

    private void showDialog(Window owner, Modality modality) {
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label modalityLabel = new Label(modality.toString());
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(modalityLabel, closeButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("A Dialog Box");
        stage.show();
    }
}
