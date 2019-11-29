package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class SaveImage extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/ksharan.jpg";
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);

        Button saveBtn = new Button("Save Image");
        saveBtn.setOnAction(e -> ImageUtil.saveToFile(image));

        VBox root = new VBox(10, imageView, saveBtn);
        Aux.showStage(stage, root, "Saving an Image to a File");
    }
}
