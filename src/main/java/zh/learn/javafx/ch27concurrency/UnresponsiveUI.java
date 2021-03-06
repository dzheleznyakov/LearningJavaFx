package zh.learn.javafx.ch27concurrency;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class UnresponsiveUI extends Application {
    Label statusLabel = new Label("Not Started...");
    Button startBtn = new Button("Start");
    Button exitBtn = new Button("Exit");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        startBtn.setOnAction(e -> runTask());
        exitBtn.setOnAction(e -> stage.close());

        HBox buttonBox = new HBox(5, startBtn, exitBtn);
        VBox root = new VBox(10, statusLabel, buttonBox);

        Aux.style(root);
        Aux.showStage(stage, root, "An Unresponsive UI");
    }

    private void runTask() {
        for (int i = 0; i <= 10; ++i) {
            try {
                String status = "Processing " + i + " of " + 10;
                statusLabel.setText(status);
                System.out.println(status);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
