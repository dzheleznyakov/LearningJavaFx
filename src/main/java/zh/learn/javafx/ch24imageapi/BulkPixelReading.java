package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.nio.ByteBuffer;

public class BulkPixelReading extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/ksharan.jpg";
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);

        HBox root = new HBox(imageView);
        Aux.showStage(stage, root, "Reading Pixels in Bulk");

        this.readPixelsInfo(image);
    }

    private void readPixelsInfo(Image image) {
        PixelReader pixelReader = image.getPixelReader();
        if (pixelReader == null) {
            System.out.println("Cannot read pixels from the image");
            return;
        }

        int x = 0;
        int y = 0;
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        int offset = 0;
        int scanlineStride = width * 4;
        byte[] buffer = new byte[width * height * 4];

        WritablePixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteBgraInstance();

        pixelReader.getPixels(x, y,
                width, height,
                pixelFormat,
                buffer,
                offset,
                scanlineStride);

        int blue = (buffer[0] & 0xff);
        int green = (buffer[1] & 0xff);
        int red = (buffer[2] & 0xff);
        int alpha = (buffer[3] & 0xff);
        System.out.println("red=" + red + ", green=" + green + ", blue=" + blue + ", alpha=" + alpha);

        Color c = pixelReader.getColor(0, 0);
        System.out.println("red=" + (int)(c.getRed() * 255) +
                ", green=" + (int)(c.getGreen() * 255) +
                ", blue=" + (int)(c.getBlue() * 255) +
                ", alpha=" + (int)(c.getOpacity() * 255));
    }
}
