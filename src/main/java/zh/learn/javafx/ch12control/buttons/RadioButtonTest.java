package zh.learn.javafx.ch12control.buttons;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class RadioButtonTest extends Application {
    Label userSelectionMsg = new Label("Your selection: None");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        RadioButton springBtn = new RadioButton("Spring");
        RadioButton summerBtn = new RadioButton("Summer");
        RadioButton fallBtn = new RadioButton("Fall");
        RadioButton winterBtn = new RadioButton("Winter");

        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(springBtn, summerBtn, fallBtn, winterBtn);

        group.selectedToggleProperty().addListener(this::changed);

        summerBtn.setSelected(true);

        Label msg = new Label("Select the season you like the most:");

        HBox buttonBox = new HBox(springBtn, summerBtn, fallBtn, winterBtn);
        buttonBox.setSpacing(10);

        VBox root = new VBox(userSelectionMsg, msg, buttonBox);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using RadioButtons in a Group");
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
