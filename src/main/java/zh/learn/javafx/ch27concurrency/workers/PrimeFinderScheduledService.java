package zh.learn.javafx.ch27concurrency.workers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

import static javafx.concurrent.Worker.State.RUNNING;
import static javafx.concurrent.Worker.State.SCHEDULED;

public class PrimeFinderScheduledService extends Application {
    Button startBtn = new Button("Start");
    Button cancelBtn = new Button("Cancel");
    Button resetBtn = new Button("Reset");
    Button exitBtn = new Button("Exit");
    boolean onceStarted = false;

    ScheduledService<ObservableList<Long>> service = new ScheduledService<ObservableList<Long>>() {
        @Override
        protected Task<ObservableList<Long>> createTask() {
            return new PrimeFinderTask();
        }
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        service.setDelay(Duration.seconds(5));
        service.setPeriod(Duration.seconds(30));
        service.setMaximumFailureCount(5);

        addEventHandlers();
        bindButtonState();

        GridPane pane = new WorkerStateUI(service);
        HBox buttonBox = new HBox(5, startBtn, cancelBtn, resetBtn, exitBtn);
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(buttonBox);
        Aux.style(root);
        Aux.showStage(stage, root, "A Prim Number Finder Scheduled Service");
    }

    private void addEventHandlers() {
        startBtn.setOnAction(e -> {
            if (onceStarted) {
                service.restart();
            } else {
                service.start();
                onceStarted = true;
                startBtn.setText("Restart");
            }
        });

        cancelBtn.setOnAction(e -> service.cancel());
        resetBtn.setOnAction(e -> service.reset());
        exitBtn.setOnAction(e -> Platform.exit());
    }

    private void bindButtonState() {
        cancelBtn.disableProperty().bind(service.stateProperty().isNotEqualTo(RUNNING));
        resetBtn.disableProperty().bind(
                Bindings.or(service.stateProperty().isEqualTo(RUNNING),
                           service.stateProperty().isEqualTo(SCHEDULED)));
    }
}
