package zh.learn.javafx.ch10container.gridpane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class GridPaneHValignment extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setStyle("-fx-padding: 10;");
        root.setGridLinesVisible(true);

        Button b1 = new Button("One");
        Button b2 = new Button("Two");
        Button b3 = new Button("Three");
        root.addColumn(0, b1, b2, b3);

        ColumnConstraints cc1 = new ColumnConstraints(100);
        cc1.setHalignment(HPos.RIGHT);
        root.getColumnConstraints().add(cc1);

        RowConstraints rc1 = new RowConstraints(40);
        rc1.setValignment(VPos.TOP);

        RowConstraints rc2 = new RowConstraints(40);
        rc2.setValignment(VPos.TOP);

        RowConstraints rc3 = new RowConstraints(40);
        root.getRowConstraints().addAll(rc1, rc2, rc3);

        GridPane.setHalignment(b2, HPos.CENTER);
        GridPane.setValignment(b1, VPos.BOTTOM);

        Aux.showStage(stage, root, "halignment and valignment Constraints");
    }
}
