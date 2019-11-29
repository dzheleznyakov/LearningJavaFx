package zh.learn.javafx.ch25drawingoncanvas;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.nio.ByteBuffer;

public class CanvasTest extends Application {
    private static final int RECT_WIDTH = 20;
    private static final int RECT_HEIGHT = 20;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(400, 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setLineWidth(2.0);
        gc.setFill(Color.RED);

        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);

        gc.fillOval(70, 10, 50, 20);

        gc.strokeText("Hello Canvas", 10, 85);

        String imagePath = "picture/ksharan.jpg";
        Image image = new Image(imagePath);
        gc.drawImage(image, 130, 10, 60, 80);

        writPixels(gc);

        Pane root = new Pane();
        root.getChildren().add(canvas);
        Aux.showStage(stage, root, "Drawing on Canvas");
    }

    private void writPixels(GraphicsContext gc) {
        byte[] pixels = getPixelsData();
        PixelWriter pixelWriter = gc.getPixelWriter();
        PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();

        int spacing = 5;
        int imageWith = 200;
        int imageHeight = 100;

        int rows = imageHeight / (RECT_HEIGHT + spacing);
        int columns = imageWith / (RECT_WIDTH + spacing);

        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < columns; ++x) {
                int xPos = 200 + x * (RECT_WIDTH + spacing);
                int yPos = y * (RECT_HEIGHT + spacing);
                pixelWriter.setPixels(xPos, yPos,
                        RECT_WIDTH, RECT_HEIGHT,
                        pixelFormat,
                        pixels, 0,
                        RECT_WIDTH * 3);
            }
        }
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
}
