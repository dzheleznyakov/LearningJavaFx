package zh.learn.javafx.ch12control.menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class MenuItemTest extends Application {
    Canvas canvas = new Canvas(200, 200);

    RadioMenuItem rectItem = new RadioMenuItem("_Rectangle");
    RadioMenuItem circleItem = new RadioMenuItem("_Circle");
    RadioMenuItem ellipseItem = new RadioMenuItem("_Ellipse");

    CheckMenuItem strokeItem = new CheckMenuItem("Draw_Stroke");
    Slider strokeWidthSlider = new Slider(1, 10, 1);
    CustomMenuItem strokeWidthItem = new CustomMenuItem(strokeWidthSlider, false);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Menu fileMenu = getFileMenu();
        Menu optionsMenu = getOptionsMenu();

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, optionsMenu);

        this.draw();

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(canvas);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Different Types of Menu Items");
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 200, 200);

        gc.setFill(Color.TAN);
        gc.setStroke(Color.RED);
        gc.setLineWidth(strokeWidthSlider.getValue());

        String shapeType = getSelectedShape();
        switch (shapeType) {
            case "Rectangle":
                gc.fillRect(0, 0, 200, 200);
                if (strokeItem.isSelected()) {
                    gc.strokeRect(0, 0, 200, 200);
                }
                break;
            case "Circle":
                gc.fillOval(10, 10, 180, 180);
                if (strokeItem.isSelected()) {
                    gc.strokeOval(10, 10, 180, 180);
                }
                break;
            case "Ellipse":
                gc.fillOval(10, 10, 180, 150);
                if (strokeItem.isSelected()) {
                    gc.strokeOval(10, 10, 180, 150);
                }
                break;
            default:
                clear();
        }
    }

    private void clear() {
        canvas.getGraphicsContext2D().clearRect(0, 0, 200, 200);
        this.rectItem.setSelected(false);
        this.circleItem.setSelected(false);
        this.ellipseItem.setSelected(false);
    }

    private Menu getFileMenu() {
        Menu fileMenu = new Menu("_File");

        rectItem.setSelected(true);

        KeyCodeCombination kr = new KeyCodeCombination(KeyCode.R, KeyCombination.ALT_DOWN);
        KeyCodeCombination kc = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN);
        KeyCodeCombination ke = new KeyCodeCombination(KeyCode.E, KeyCombination.ALT_DOWN);
        rectItem.setAccelerator(kr);
        circleItem.setAccelerator(kc);
        ellipseItem.setAccelerator(ke);

        rectItem.setOnAction(e -> draw());
        circleItem.setOnAction(e -> draw());
        ellipseItem.setOnAction(e -> draw());

        ToggleGroup shapeGroup = new ToggleGroup();
        shapeGroup.getToggles().addAll(rectItem, circleItem, ellipseItem);

        MenuItem clearItem = new MenuItem("Cle_ar");
        clearItem.setOnAction(e -> clear());

        MenuItem exitItem = new MenuItem("E_xit");
        exitItem.setOnAction(e -> Platform.exit());

        fileMenu.getItems().addAll(rectItem, circleItem, ellipseItem,
                new SeparatorMenuItem(),
                clearItem,
                new SeparatorMenuItem(),
                exitItem);
        return fileMenu;
    }

    private Menu getOptionsMenu() {
        strokeItem.setSelected(true);

        strokeItem.setOnAction(e -> syncStroke());

        strokeWidthSlider.setShowTickLabels(true);
        strokeWidthSlider.setShowTickMarks(true);
        strokeWidthSlider.setMajorTickUnit(2);
        strokeWidthSlider.setSnapToPixel(true);
        strokeWidthSlider.valueProperty().addListener(this::strokeWidthChanged);

        Menu optionsMenu = new Menu("_Options");
        optionsMenu.getItems().addAll(strokeItem, this.strokeWidthItem);

        return optionsMenu;
    }

    public void strokeWidthChanged(ObservableValue<? extends  Number> prop,
                                   Number oldValue,
                                   Number newValue) {
        draw();
    }

    private String getSelectedShape() {
        if (rectItem.isSelected()) {
            return "Rectangle";
        } else if (circleItem.isSelected()) {
            return "Circle";
        } else if (ellipseItem.isSelected()) {
            return "Ellipse";
        } else {
            return "";
        }
    }

    public void syncStroke() {
        strokeWidthSlider.setDisable(!strokeItem.isSelected());
        draw();
    }
}
