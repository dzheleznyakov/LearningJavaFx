package zh.learn.javafx.ch12control.buttons;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ToggleButtonTest extends Application {
    Label userSelectionMsg = new Label("Your selection: None");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ToggleButton springBtn = new ToggleButton("Spring");
        ToggleButton summerBtn = new ToggleButton("Summer");
        ToggleButton fallBtn = new ToggleButton("Fall");
        ToggleButton winterBtn = new ToggleButton("Winter");

        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(springBtn, summerBtn, fallBtn, winterBtn);

        group.selectedToggleProperty().addListener(this::changed);

        Label msg = new Label("Select the season you like:");

        HBox buttonBox = new HBox(springBtn, summerBtn, fallBtn, winterBtn);
        buttonBox.setSpacing(10);

        VBox root = new VBox(userSelectionMsg, msg, buttonBox);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ToggleButtons in a Group");
    }

    public void changed(ObservableValue<? extends Toggle> observable,
                        Toggle oldBtn,
                        Toggle newBtn) {
        String selectedLabel = "None";
        if (newBtn != null) {
            selectedLabel = ((Labeled) newBtn).getText();
        }

        userSelectionMsg.setText("Your selection: " + selectedLabel);
    }
}
