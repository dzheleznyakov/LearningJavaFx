package zh.learn.javafx.ch09event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MouseTransparency extends Application {
    private CheckBox mouseTransparentCbx = new CheckBox("Mouse Transparent");
    private Circle circle = new Circle(50, 50, 50, Color.LIGHTGRAY);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.RED);

        Group group = new Group();
        group.getChildren().addAll(rect, circle);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(group, mouseTransparentCbx);

        circle.setOnMouseClicked(this::handleMouseClicked);
        rect.setOnMouseClicked(this::handleMouseClicked);

        mouseTransparentCbx.setOnAction(this::handleActionEvent);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Mouse Transparency");
        stage.show();
    }

    private void handleMouseClicked(MouseEvent e) {
        String target = e.getTarget().getClass().getSimpleName();
        String type = e.getEventType().getName();
        System.out.println(type + " on " + target);
    }

    private void handleActionEvent(ActionEvent e) {
        circle.setMouseTransparent(mouseTransparentCbx.isSelected());
    }
}
