package zh.learn.javafx.ch26draganddrop;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class SimplePressDragRelease extends Application {
    TextField sourceFld = new TextField("Source Node");
    TextField targetFld = new TextField("Target Node");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = getUI();

        addEventHandlers();

        Aux.showStage(stage, root, "A Simple press-drag-release Gesture");
    }

    protected GridPane getUI() {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(20);
        pane.addRow(0, new Label("Source Node:"), sourceFld);
        pane.addRow(1, new Label("Target Node:"), targetFld);
        return pane;
    }

    protected void addEventHandlers() {
        sourceFld.setOnMousePressed(e -> print("Source: pressed"));
        sourceFld.setOnMouseDragged(e -> print("Source: dragged"));
        sourceFld.setOnDragDetected(e -> print("Source: dragged detected"));
        sourceFld.setOnMouseReleased(e -> print("Source: released"));

        targetFld.setOnMouseDragEntered(e -> print("Target: drag entered"));
        targetFld.setOnMouseDragOver(e -> print("Target: drag over"));
        targetFld.setOnMouseDragReleased(e -> print("Target: drag released"));
        targetFld.setOnMouseDragExited(e -> print("Target: drag exited"));
    }

    protected void print(String msg) {
        System.out.println(msg);
    }
}
