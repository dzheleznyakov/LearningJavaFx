package zh.learn.javafx.ch09event;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HandlersOrder extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(50, 50, 50);
        circle.setFill(Color.CORAL);

        HBox root = new HBox();
        root.getChildren().addAll(circle);
        Scene scene = new Scene(root);

        circle.addEventHandler(MouseEvent.ANY, this::handleAnyMouseEvent);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> handleMouseClicked("addEventHandler()", e));

        circle.setOnMouseClicked(e -> handleMouseClicked("setOnMouseClicked()", e));

        stage.setScene(scene);
        stage.setTitle("Execution Order of Event Handlers of a Node");
        stage.show();
    }

    private void handleMouseClicked(String registrationMethod, MouseEvent e) {
        System.out.println(registrationMethod + ": MOUSE_CLICKED handler detected a mouse click.");
    }

    private void handleAnyMouseEvent(MouseEvent e) {
        if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println("MouseEvent.ANY handler detected a mouse click.");
        }
    }
}
