package zh.learn.javafx.ch10container.gridpane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class GridPaneForm extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();

        Label descLbl = new Label("Description");
        TextArea descText = new TextArea();
        descText.setPrefColumnCount(20);
        descText.setPrefRowCount(5);

        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        Label statusBar = new Label("Status: Ready");
        statusBar.setStyle("-fx-background-color: lavender;" +
                "-fx-font-size: 7pt;" +
                "-fx-padding: 10 0 0 0;");

        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: lightgray;");

        root.add(nameLbl, 0, 0, 1, 1);
        root.add(nameFld, 1, 0, 1, 1);
        root.add(descLbl, 0, 1, 3, 1);
        root.add(descText, 0, 2, 2, 1);
        root.add(okBtn, 2, 0, 1, 1);
        root.add(cancelBtn, 2, 1, 1, 1);
        root.add(statusBar, 0, 3, GridPane.REMAINING, 1);

        okBtn.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(nameFld, Priority.ALWAYS);
        GridPane.setVgrow(descText, Priority.ALWAYS);
        statusBar.setMaxWidth(Double.MAX_VALUE);

        Aux.showStage(stage, root, "Creating Forms Using a GridPane");
    }
}
