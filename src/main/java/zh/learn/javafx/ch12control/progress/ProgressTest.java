package zh.learn.javafx.ch12control.progress;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ProgressTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ProgressIndicator indeterminateInd = new ProgressIndicator();
        ProgressIndicator determinateInd = new ProgressIndicator(0);

        ProgressBar indeterminateBar = new ProgressBar();
        ProgressBar determinateBar = new ProgressBar(0);

        Button completeIndBtn = new Button("Complete Task");
        completeIndBtn.setOnAction(e -> indeterminateInd.setProgress(1.0));

        Button completeBarBtn = new Button("Complete Task");
        completeBarBtn.setOnAction(e -> indeterminateBar.setProgress(1.0));

        Button makeProgressIndBtn = new Button("Make Progress");
        makeProgressIndBtn.setOnAction(e -> makeProgress(determinateInd));

        Button makeProgressBarBtn = new Button("Make Progress");
        makeProgressBarBtn.setOnAction(e -> makeProgress(determinateBar));

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);
        root.addRow(0, new Label("Indeterminate Progress:"), indeterminateInd, completeIndBtn);
        root.addRow(1, new Label("Determinate Progress:"), determinateInd, makeProgressIndBtn);
        root.addRow(2, new Label("Indeterminate Progress:"), indeterminateBar, completeBarBtn);
        root.addRow(3, new Label("Determinate Progress:"), determinateBar, makeProgressBarBtn);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ProgressIndicator and ProgressBar Controls");
    }

    public void makeProgress(ProgressIndicator p) {
        double progress = p.getProgress();
        if (progress <= 0) {
            progress = 0.1;
        } else {
            progress += 0.1;
            if (progress >= 1.0) {
                progress = 1.0;
            }
        }
        p.setProgress(progress);
    }
}
