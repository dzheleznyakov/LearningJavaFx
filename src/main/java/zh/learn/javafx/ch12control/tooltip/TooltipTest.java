package zh.learn.javafx.ch12control.tooltip;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TooltipTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        Button saveBtn = new Button("Save");
        Button closeBtn = new Button("Close");

        closeBtn.setOnAction(e -> stage.close());

        nameFld.setTooltip(new Tooltip("Enter your name\nMax. 10 chars"));
        saveBtn.setTooltip(new Tooltip("Saves the data"));

        Tooltip closeBtnTip = new Tooltip("Closes the window");
        closeBtnTip.setStyle("-fx-background-color: yellow; " +
                "-fx-text-fill: black;");

        closeBtnTip.setContentDisplay(ContentDisplay.TOP);

        Label closeTipIcon = new Label("X");
        closeTipIcon.setStyle("-fx-text-fill: red;");
        closeBtnTip.setGraphic(closeTipIcon);

        closeBtn.setTooltip(closeBtnTip);

        HBox root = new HBox(nameLbl, nameFld, saveBtn, closeBtn);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Tooltip Controls");
    }
}
