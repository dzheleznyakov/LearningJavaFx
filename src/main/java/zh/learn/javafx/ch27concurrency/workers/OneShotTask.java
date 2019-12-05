package zh.learn.javafx.ch27concurrency.workers;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import static javafx.concurrent.Worker.State.READY;
import static javafx.concurrent.Worker.State.RUNNING;

public class OneShotTask extends Application {
    Button startBtn = new Button("Start");
    Button cancelBtn = new Button("Canceled");
    Button exitBtn = new Button("Exit");

    PrimeFinderTask task = new PrimeFinderTask();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        startBtn.setOnAction(e -> startTask());
        cancelBtn.setOnAction(e -> task.cancel());
        exitBtn.setOnAction(e -> stage.close());

        startBtn.disableProperty().bind(task.stateProperty().isNotEqualTo(READY));
        cancelBtn.disableProperty().bind(task.stateProperty().isNotEqualTo(RUNNING));
        GridPane pane = new WorkerStateUI(task);
        HBox buttonBox = new HBox(5, startBtn, cancelBtn, exitBtn);
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(buttonBox);
        Aux.style(root);
        Aux.showStage(stage, root, "A Prime Number Finder Task");
    }

    private void startTask() {
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }
}
