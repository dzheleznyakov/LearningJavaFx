package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class CopyingImage extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/ksharan.jpg";
        Image image = new Image(imagePath, 200, 100, true, true);

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage darkerImage = new WritableImage(width, height);
        WritableImage brighterImage = new WritableImage(width, height);
        WritableImage semiTransparentImage = new WritableImage(width, height);
        WritableImage invertedImage = new WritableImage(width, height);

        createImages(image,
                darkerImage,
                brighterImage,
                semiTransparentImage,
                invertedImage,
                width,
                height);

        ImageView imageView = new ImageView(image);
        ImageView darkerView = new ImageView(darkerImage);
        ImageView brighterView = new ImageView(brighterImage);
        ImageView semiTransparentView = new ImageView(semiTransparentImage);
        ImageView invertedView = new ImageView(invertedImage);


        HBox root = new HBox(10,
                new VBox(imageView, new Text("Original")),
                new VBox(darkerView, new Text("Darker")),
                new VBox(brighterView, new Text("Brighter")),
                new VBox(semiTransparentView, new Text("Semi-Transparent")),
                new VBox(invertedView, new Text("Inverted")));

        Aux.showStage(stage, root, "Writing Pixels to an Image");
    }

    private void createImages(Image image,
                              WritableImage darkerImage,
                              WritableImage brighterImage,
                              WritableImage semiTransparentImage,
                              WritableImage invertedImage,
                              int width, int height)
    {
        PixelReader pixelReader = image.getPixelReader();
        PixelWriter darkerWriter = darkerImage.getPixelWriter();
        PixelWriter brighterWriter = brighterImage.getPixelWriter();
        PixelWriter semiTransparentWriter = semiTransparentImage.getPixelWriter();
        PixelWriter invertedWriter = invertedImage.getPixelWriter();

        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                Color color = pixelReader.getColor(x, y);
                darkerWriter.setColor(x, y, color.darker());
                brighterWriter.setColor(x, y, color.brighter());
                semiTransparentWriter.setColor(x, y, Color.color(color.getRed(),
                        color.getGreen(),
                        color.getBlue(),
                        0.5));
                invertedWriter.setColor(x, y, color.invert());
            }
        }
    }
}
