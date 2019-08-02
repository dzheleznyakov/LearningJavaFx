package zh.learn.javafx.ch12control.menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ToolBarTest extends Application {
    Canvas canvas = new Canvas(200, 200);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button rectBtn = new Button("", new Rectangle(0, 0, 16, 16));
        Button circleBtn = new Button("", new Circle(0, 0, 8));
        Button ellipseBtn = new Button("", new Ellipse(8, 8, 8, 6));
        Button exitBtn = new Button("Exit");

        rectBtn.setTooltip(new Tooltip("Draws a rectangle"));
        circleBtn.setTooltip(new Tooltip("Draws a circle"));
        ellipseBtn.setTooltip(new Tooltip("Draws an ellipse"));
        exitBtn.setTooltip(new Tooltip("Exits application"));

        rectBtn.setOnAction(e -> draw("Rectangle"));
        circleBtn.setOnAction(e -> draw("Circle"));
        ellipseBtn.setOnAction(e -> draw("Ellipse"));
        exitBtn.setOnAction(e -> Platform.exit());

        ToolBar toolBar = new ToolBar(rectBtn, circleBtn, ellipseBtn, new Separator(), exitBtn);

        BorderPane root = new BorderPane();
        root.setTop(new VBox(new Label("Click a shape to draw."), toolBar));
        root.setCenter(canvas);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ToolBar Controls");
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
