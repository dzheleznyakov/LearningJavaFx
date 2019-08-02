package zh.learn.javafx.ch10container.gridpane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class GridPaneHgapVgap extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label fnameLbl = new Label("First Name");
        TextField fnameFld = new TextField();
        Label lnameLbl = new Label("Last Name");
        TextField lnameFld = new TextField();
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        okBtn.setMaxWidth(Double.MAX_VALUE);

        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        root.setHgap(10);
        root.setVgap(5);
        root.setStyle("-fx-padding: 10;-fx-background-color: lightgray;");
        root.addRow(0, fnameLbl, fnameFld, okBtn);
        root.addRow(1, lnameLbl, lnameFld, cancelBtn);

        Aux.showStage(stage, root, "Using hgap and vgap Properties for a GridPane");
    }
}
