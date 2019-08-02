package zh.learn.javafx.ch09event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EventRegistration extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.CORAL);

        EventHandler<MouseEvent> mouseEventFilter = e -> System.out.println("Mouse event filter has been called.");
        EventHandler<MouseEvent> mouseEventHandler = e -> System.out.println("Mouse event handler has been called.");

        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);

        HBox root = new HBox();
        root.getChildren().add(circle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Registering Event Filters and Handlers");
        stage.show();
        stage.sizeToScene();
    }
}
