package zh.learn.javafx.ch12control.menu;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ContextMenuTest extends Application {
    Canvas canvas = new Canvas(200, 200);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        canvas.setOnMouseClicked(e -> showContextMenu(e));

        BorderPane root = new BorderPane();
        root.setTop(new Label("Right click below to display a context menu."));
        root.setCenter(canvas);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Context Menus");
    }

    private void showContextMenu(MouseEvent me) {
        if (me.getButton() == MouseButton.SECONDARY) {
            MenuItem rectItem = new MenuItem("Rectangle");
            MenuItem circleItem = new MenuItem("Circle");
            MenuItem ellipseItem = new MenuItem("Ellipse");
            rectItem.setOnAction(e -> draw("Rectangle"));
            circleItem.setOnAction(e -> draw("Circle"));
            ellipseItem.setOnAction(e -> draw("Ellipse"));
            ContextMenu ctxMenu = new ContextMenu(rectItem, circleItem, ellipseItem);
            ctxMenu.show(canvas, me.getScreenX(), me.getScreenY());
        }
    }

    public void draw(String shapeType) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 200, 200);
        gc.setFill(Color.TAN);

        if (shapeType.equals("Rectangle")) {
            gc.fillRect(0, 0, 200, 200);
        } else if (shapeType.equals("Circle")) {
            gc.fillOval(0, 0, 200, 200);
        } else if (shapeType.equals("Ellipse")) {
            gc.fillOval(10, 40, 180, 120);
        }
    }
}
