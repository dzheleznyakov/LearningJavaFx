package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.nio.ByteBuffer;

public class CreatingImage extends Application {
    private static final int RECT_WIDTH = 20;
    private static final int RECT_HEIGHT = 20;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        WritableImage newImage = new WritableImage(350, 100);

        byte[] pixels = getPixelsData();

        writePattern(newImage, pixels);

        ImageView newImageView = new ImageView(newImage);

        HBox root = new HBox(newImageView);
        Aux.showStage(stage, root, "Creating an Image from Scratch");
    }

    private byte[] getPixelsData() {
        byte[] pixels = new byte[RECT_WIDTH * RECT_HEIGHT * 3];
        double ratio = 1.0 * RECT_HEIGHT / RECT_WIDTH;

        for (int y = 0; y < RECT_HEIGHT; ++y) {
            for (int x = 0; x < RECT_WIDTH; ++x) {
                int i = y * RECT_WIDTH * 3 + x * 3;
                if (x <= y / ratio) {
                    pixels[i] = -1;
                    pixels[i + 1] = 0;
                    pixels[i + 2] = 0;
                } else {
                    pixels[i] = 0;
                    pixels[i + 1] = -1;
                    pixels[i + 2] = 0;
                }
            }
        }
        return pixels;
    }

    private void writePattern(WritableImage newImage, byte[] pixels) {
        PixelWriter pixelWriter = newImage.getPixelWriter();
        PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();

        int spacing = 5;
        int imageWith = (int) newImage.getWidth();
        int imageHeight = (int) newImage.getHeight();

        int rows = imageHeight / (RECT_HEIGHT + spacing);
        int columns = imageWith / (RECT_WIDTH + spacing);

        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < columns; ++x) {
                int xPos = x * (RECT_WIDTH + spacing);
                int yPos = y * (RECT_HEIGHT + spacing);

                pixelWriter.setPixels(xPos, yPos,
                        RECT_WIDTH, RECT_HEIGHT,
                        pixelFormat,
                        pixels, 0,
                        RECT_WIDTH * 3);
            }
        }
    }
}
