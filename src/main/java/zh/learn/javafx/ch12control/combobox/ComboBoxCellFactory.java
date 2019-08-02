package zh.learn.javafx.ch12control.combobox;

import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ComboBoxCellFactory extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label shapeLbl = new Label("Shape:");
        ComboBox<String> shapes = new ComboBox<>();
        shapes.getItems().addAll("Line", "Rectangle", "Circle");

        shapes.setCellFactory(new ShapeCellFactory());

        shapes.setButtonCell(new StringShapeCell());

        HBox root = new HBox(shapeLbl, shapes);
        Aux.style(root);

        Aux.showStage(stage, root, "Using CellFactory in ComboBox");
    }
}
