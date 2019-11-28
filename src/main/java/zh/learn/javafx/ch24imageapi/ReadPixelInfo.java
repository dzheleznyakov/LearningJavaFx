package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ReadPixelInfo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/ksharan.jpg";
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        HBox root = new HBox(imageView);

        Aux.showStage(stage, root, "Reading Pixels from an Image");

        this.readPixelsInfo(image);
    }

    private void readPixelsInfo(Image image) {
        PixelReader pixelReader = image.getPixelReader();
        if (pixelReader == null) {
            System.out.println("Cannot read pixels from the image");
            return;
        }

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                Color color = pixelReader.getColor(x, y);
                System.out.println("Color at (" + x + ", " + y + ") = " + color);
            }
        }

        PixelFormat format = pixelReader.getPixelFormat();
        PixelFormat.Type formatType = format.getType();
        System.out.println("Pixel format type: " + formatType);
    }
}
