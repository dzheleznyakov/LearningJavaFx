package zh.learn.javafx.ch26draganddrop;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class DragAndDropTest extends Application {
    TextField sourceFld = new TextField("Source Node");
    TextField targetFld = new TextField("Target Node");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = getUIs();

        adDndEventHandlers();

        Aux.style(root);
        Aux.showStage(stage, root, "Performing a Drag-and-Drop Gesture");
    }

    private GridPane getUIs() {
        sourceFld.setPromptText("Enter text to drag");
        targetFld.setPromptText("Drag the source text here");

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(20);
        pane.add(new Label("Drag and drop the source text field" +
                " onto the target text field."), 0, 0, 2, 1);
        pane.addRow(1, new Label("DnD Gesture Source:"), sourceFld);
        pane.addRow(2, new Label("DnD Gesture Target:"), targetFld);
        return pane;
    }

    private void adDndEventHandlers() {
        sourceFld.setOnDragDetected(this::dragDetected);
        targetFld.setOnDragOver(this::dragOver);
        targetFld.setOnDragDropped(this::dragDropped);
        sourceFld.setOnDragDone(this::dragDone);
    }

    private void dragDetected(MouseEvent e) {
        String sourceText = sourceFld.getText();
        if (sourceText == null || sourceText.trim().equals("")) {
            e.consume();
            return;
        }

        Dragboard dragboard = sourceFld.startDragAndDrop(TransferMode.COPY_OR_MOVE);

        ClipboardContent content = new ClipboardContent();
        content.putString(sourceText);
        dragboard.setContent(content);

        e.consume();
    }

    private void dragOver(DragEvent e) {
        Dragboard dragboard = e.getDragboard();
        if (dragboard.hasString()) {
            e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        e.consume();
    }

    private void dragDropped(DragEvent e) {
        Dragboard dragboard = e.getDragboard();
        if (dragboard.hasString()) {
            String text = dragboard.getString();
            targetFld.setText(text);

            e.setDropCompleted(true);
        } else {
            e.setDropCompleted(false);
        }

        e.consume();
    }

    private void dragDone(DragEvent e) {
        TransferMode modeUsed = e.getTransferMode();
        if (modeUsed == TransferMode.MOVE) {
            sourceFld.setText("");
        }

        e.consume();
    }
}
