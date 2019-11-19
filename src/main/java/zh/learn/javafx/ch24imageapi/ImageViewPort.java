package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ImageViewPort extends Application {
    private static final double VIEWPORT_WIDTH = 300;
    private static final double VIEWPORT_HEIGHT = 200;
    private double startX;
    private double startY;
    private ImageView imageView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/school_bus.jpg";
        Image image = new Image(imagePath);
        imageView = new ImageView(image);

        Rectangle2D viewport = new Rectangle2D(0, 0, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        imageView.setViewport(viewport);

        imageView.setOnMousePressed(this::handleMousePressed);
        imageView.setOnMouseDragged(this::handleMouseDragged);

        Aux.showStage(stage, new HBox(imageView), "Viewing an Image in a Viewport");
    }

    private void handleMousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    private void handleMouseDragged(MouseEvent e) {
        double draggedDistanceX = e.getX() - startX;
        double draggedDistanceY = e.getY() - startY;

        startX = e.getX();
        startY = e.getY();

        double curMinX = imageView.getViewport().getMinX();
        double curMinY = imageView.getViewport().getMinY();

        double newMinX = curMinX - draggedDistanceX;
        double newMinY = curMinY - draggedDistanceY;

        newMinX = clamp(newMinX, 0, imageView.getImage().getWidth() - VIEWPORT_WIDTH);
        newMinY = clamp(newMinY, 0, imageView.getImage().getHeight() - VIEWPORT_HEIGHT);

        imageView.setViewport(new Rectangle2D(newMinX, newMinY, VIEWPORT_WIDTH, VIEWPORT_HEIGHT));
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}
