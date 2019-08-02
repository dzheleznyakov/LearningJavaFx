package zh.learn.javafx.ch10container;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NodesLayoutInGroup extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        okBtn.setLayoutX(10);
        okBtn.setLayoutY(10);

        NumberBinding layoutXBinding = okBtn.layoutXProperty().add(okBtn.widthProperty().add(10));
        cancelBtn.layoutXProperty().bind(layoutXBinding);
        cancelBtn.layoutYProperty().bind(okBtn.layoutYProperty());

        Group root = new Group();
        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Positioning Nodes in a Group");
        stage.show();
    }
}
