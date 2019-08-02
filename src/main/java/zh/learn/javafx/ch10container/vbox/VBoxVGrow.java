package zh.learn.javafx.ch10container.vbox;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class VBoxVGrow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label descLbl = new Label("Description");
        TextArea desc = new TextArea();
        desc.setPrefColumnCount(10);
        desc.setPrefRowCount(3);

        VBox root = new VBox(10);
        root.getChildren().addAll(descLbl, desc);

        VBox.setVgrow(desc, Priority.ALWAYS);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Vertical Grow Priority in a VBox");
    }
}
