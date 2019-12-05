package zh.learn.javafx.ch27concurrency;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ResponsiveUI extends Application {
    Label statusLabel = new Label("Not Started...");
    Button startBtn = new Button("Start");
    Button exitBtn = new Button("Exit");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        startBtn.setOnAction(e -> startTask());
        exitBtn.setOnAction(e -> stage.close());

        HBox buttonBox = new HBox(5, startBtn, exitBtn);
        VBox root = new VBox(10, statusLabel, buttonBox);

        Aux.style(root);
        Aux.showStage(stage, root, "A Responsive UI");
    }

    private void startTask() {
        Runnable task = () -> runTask();
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    private void runTask() {
        for (int i = 0; i <= 10; ++i) {
            try {
                String status = "Processing " + i + " of " + 10;
                Platform.runLater(() -> statusLabel.setText(status));
                System.out.println(status);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
