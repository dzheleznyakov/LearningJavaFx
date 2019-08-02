package zh.learn.javafx.ch10container.flowpane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;


public class FlowPaneRowColAlignment extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        FlowPane fp1 = createFlowPane(Orientation.HORIZONTAL, VPos.TOP, HPos.LEFT);
        FlowPane fp2 = createFlowPane(Orientation.HORIZONTAL, VPos.CENTER, HPos.LEFT);
        FlowPane fp3 = createFlowPane(Orientation.VERTICAL, VPos.CENTER, HPos.RIGHT);

        HBox root = new HBox(fp1, fp2, fp3);
        Aux.showStage(stage, root, "FlowPane Row and Column Alignment");
    }

    private FlowPane createFlowPane(Orientation orientation, VPos rowAlign, HPos colAlign) {
        Text t = new Text();
        if (orientation == Orientation.HORIZONTAL) {
            t.setText(rowAlign.toString());
        } else {
            t.setText(colAlign.toString());
        }

        TextArea ta = new TextArea(orientation.toString());
        ta.setPrefColumnCount(5);
        ta.setPrefRowCount(3);

        FlowPane fp = new FlowPane(orientation, 5, 5);
        fp.setRowValignment(rowAlign);
        fp.setColumnHalignment(colAlign);
        fp.setPrefSize(175, 130);
        fp.getChildren().addAll(t, ta);
        Aux.style(fp);

        return fp;
    }
}
