package zh.learn.javafx.ch26draganddrop;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class FullPressDragRelease extends SimplePressDragRelease {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = getUI();
        addEventHandlers();
        Aux.showStage(stage, root, "A full press-drag-release gesture");
    }

    @Override
    protected void addEventHandlers() {
        sourceFld.setOnMousePressed(e -> {
            sourceFld.setMouseTransparent(true);
            print("Source: Mouse pressed");
        });
        sourceFld.setOnMouseDragged(e -> print("Source: Mouse dragged"));
        sourceFld.setOnDragDetected(e -> {
            sourceFld.startFullDrag();
            print("Source: Mouse dragged detected");
        });
        sourceFld.setOnMouseReleased(e -> {
            sourceFld.setMouseTransparent(false);
            print("Source: Mouse released");
        });

        targetFld.setOnMouseDragEntered(e -> print("Target: drag entered"));
        targetFld.setOnMouseDragOver(e -> print("Target: drag over"));
        targetFld.setOnMouseDragReleased(e -> print("Target: drag released"));
        targetFld.setOnMouseDragExited(e -> print("Target: drag exited"));
    }
}
