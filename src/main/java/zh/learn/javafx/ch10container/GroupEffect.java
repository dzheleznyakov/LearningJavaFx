package zh.learn.javafx.ch10container;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

public class GroupEffect extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        okBtn.setLayoutX(10);
        okBtn.setLayoutY(10);
        cancelBtn.setLayoutX(80);
        cancelBtn.setLayoutY(10);

        Group root = new Group();
        root.setEffect(new DropShadow());
        root.setRotate(10);
        root.setOpacity(0.8);

        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Applying Transformation and Effects to a Group");
        stage.show();
    }
}
