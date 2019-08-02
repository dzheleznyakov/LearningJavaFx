package zh.learn.javafx.ch09event.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CopyPasteCircle extends Application {
    private Point2D insertionPoint = new Point2D(50, 50);
    private Node buffer = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(50, 50, 50, Color.OLIVE);

        Pane root = new Pane();
        root.setPadding(new Insets(20));
        root.getChildren().addAll(circle);

        root.addEventHandler(MouseEvent.MOUSE_CLICKED, this::saveInsertionPoint);
        root.addEventHandler(KeyEvent.KEY_RELEASED, this::paste);

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, this::requestFocus);
        circle.addEventHandler(KeyEvent.KEY_RELEASED, this::cut);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Copy and Paste Circle");
        stage.show();
    }

    private void saveInsertionPoint(MouseEvent e) {
        insertionPoint = new Point2D(e.getX(), e.getY());
        System.out.println("New Insertion Point: " + insertionPoint);
    }

    private void paste(KeyEvent e) {
        if (e.isMetaDown() && e.getCode() == KeyCode.V && buffer != null) {
            Circle circle = (Circle) buffer;
            circle.setCenterX(insertionPoint.getX());
            circle.setCenterY(insertionPoint.getY());
            Pane pane = (Pane) e.getSource();
            pane.getChildren().add(circle);
            circle.requestFocus();
        }
    }

    private void requestFocus(MouseEvent e) {
        Node source = (Node) e.getSource();
        source.requestFocus();
        System.out.println("Focus requested for " + source.getClass().getSimpleName());
    }

    private void cut(KeyEvent e) {
        if (e.isMetaDown() && e.getCode() == KeyCode.X) {
            Circle circle = (Circle) e.getSource();
            Pane pane = (Pane) circle.getParent();
            pane.getChildren().removeAll(circle);
            buffer = circle;
            pane.requestFocus();
        }
    }
}
