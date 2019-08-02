package zh.learn.javafx.ch09event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.scene.input.MouseEvent.*;

public class MouseEnteredExitedTarget extends Application {
    private CheckBox consumeCbx = new CheckBox("Consume Events");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(50, 50, 50);
        circle.setFill(Color.GRAY);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, consumeCbx);

        EventHandler<MouseEvent> circleHandler = this::handleCircle;
        EventHandler<MouseEvent> circleTargetHandler = this::handleCircleTarget;
        EventHandler<MouseEvent> hBoxTargetHandler = this::handleHBoxTarget;

        root.addEventFilter(MOUSE_ENTERED_TARGET, hBoxTargetHandler);
        root.addEventFilter(MOUSE_EXITED_TARGET, hBoxTargetHandler);

        circle.addEventHandler(MOUSE_ENTERED_TARGET, circleTargetHandler);
        circle.addEventHandler(MOUSE_EXITED_TARGET, circleTargetHandler);

        circle.addEventHandler(MOUSE_ENTERED, circleHandler);
        circle.addEventHandler(MOUSE_EXITED, circleHandler);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Mouse Entered Target and Exited Target Events");
        stage.show();
    }

    private void handleCircle(MouseEvent e) {
        print(e, "Circle Handler");
    }

    private void handleCircleTarget(MouseEvent e) {
        print(e, "Circle Target Handler");
    }

    private void handleHBoxTarget(MouseEvent e) {
        print(e, "HBox Target Filter");
        if (consumeCbx.isSelected()) {
            e.consume();
            System.out.println("HBox consumed the " + e.getEventType() + " event");
        }
    }

    private void print(MouseEvent e, String msg) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        System.out.println(msg + ": Type=" + type + ", Target=" + target + ", Source=" + source);
    }
}
