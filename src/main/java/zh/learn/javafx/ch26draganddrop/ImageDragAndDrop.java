package zh.learn.javafx.ch26draganddrop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.List;

public class ImageDragAndDrop extends Application {
    ImageView imageView = new ImageView();
    Button clearBtn = new Button("Clear Image");
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = getUIs();
        scene = new Scene(root);
        stage.setScene(scene);

        addDndEventHandlers();

        Aux.style(root);
        stage.setTitle("Performing a Drag-and-Drop Gesture");
        stage.show();
    }

    private VBox getUIs() {
        Label msgLbl = new Label("Drag and drop an image, an image file, or an image URL below.");

        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        imageView.setSmooth(true);
        imageView.setPreserveRatio(true);

        clearBtn.setOnAction(e -> imageView.setImage(null));

        return new VBox(20, msgLbl, imageView, clearBtn);
    }

    private void addDndEventHandlers() {
        scene.setOnDragOver(this::dragOver);
        scene.setOnDragDropped(this::dragDropped);
    }

    private void dragOver(DragEvent e) {
        Dragboard dragboard = e.getDragboard();
        if (dragboard.hasImage() || dragboard.hasFiles() || dragboard.hasUrl()) {
            e.acceptTransferModes(TransferMode.ANY);
        }
        e.consume();
    }

    private void dragDropped(DragEvent e) {
        boolean isCompleted = false;

        Dragboard dragboard = e.getDragboard();
        if (dragboard.hasImage()) {
            transferImage(dragboard.getImage());
            isCompleted = true;
        } else if (dragboard.hasFiles()) {
            isCompleted = transferImageFile(dragboard.getFiles());
        } else if (dragboard.hasUrl()) {
            isCompleted = transferImageUrl(dragboard.getUrl());
        } else {
            System.out.println("Dragboard does not contain an image" +
                    " in the expected format: Image, File, URL");
        }
        e.setDropCompleted(isCompleted);
        e.consume();
    }

    private void transferImage(Image image) {
        imageView.setImage(image);
    }

    private boolean transferImageFile(List<File> files) {
        for (File file : files) {
            String mimeType;
            try {
                mimeType = Files.probeContentType(file.toPath());
                if (mimeType != null && mimeType.startsWith("image/")) {
                    transferImageUrl(file.toURI().toURL().toExternalForm());
                    return true;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    private boolean transferImageUrl(String imageUrl) {
        try {
            imageView.setImage(new Image(imageUrl));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
