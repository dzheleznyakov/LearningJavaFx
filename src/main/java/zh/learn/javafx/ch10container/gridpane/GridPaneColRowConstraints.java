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

public class GridPaneColRowConstraints extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setStyle("-fx-padding: 10;");
        root.setGridLinesVisible(true);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button b = new Button(col + " " + row);
                root.add(b, col, row);
            }
        }

        ColumnConstraints cc1 = new ColumnConstraints(100);

        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setPercentWidth(35);
        cc2.setHalignment(HPos.CENTER);

        ColumnConstraints cc3 = new ColumnConstraints();
        cc3.setPercentWidth(35);

        root.getColumnConstraints().addAll(cc1, cc2, cc3);

        RowConstraints rc1 = new RowConstraints();
        rc1.setPercentHeight(35);
        rc1.setValignment(VPos.TOP);

        RowConstraints rc2 = new RowConstraints();
        rc2.setPercentHeight(35);
        rc2.setValignment(VPos.BOTTOM);

        root.getRowConstraints().addAll(rc1, rc2);

        Aux.showStage(stage, root, "Setting Column/Row Constraint");
    }
}
