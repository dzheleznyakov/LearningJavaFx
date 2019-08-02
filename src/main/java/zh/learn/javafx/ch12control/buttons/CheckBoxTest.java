package zh.learn.javafx.ch12control.buttons;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class CheckBoxTest extends Application {
    Label userSelectionMsg = new Label("Do you agree? No");
    CheckBox agreeCbx;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CheckBox hungryCbx = new CheckBox("Hungry");

        agreeCbx = new CheckBox("I agree");
        agreeCbx.setAllowIndeterminate(true);

        agreeCbx.selectedProperty().addListener(this::changed);
        agreeCbx.indeterminateProperty().addListener(this::changed);

        VBox root = new VBox(userSelectionMsg, hungryCbx, agreeCbx);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, 200, 130, "Using CheckBoxes");
    }

    public void changed(ObservableValue<? extends Boolean> observable,
                        Boolean oldValue,
                        Boolean newValue) {
        String msg;
        if (agreeCbx.isIndeterminate()) {
            msg = "Not sure";
        } else if (agreeCbx.isSelected()) {
            msg = "Yes";
        } else {
            msg = "No";
        }
        this.userSelectionMsg.setText("Do you agree? " + msg);
    }
}
