package zh.learn.javafx.ch19threedshapes;

import javafx.application.Application;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class DepthTestCheck extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle red = new Rectangle(100, 100);
        red.setFill(Color.RED);
        Aux.translate(red, 100, 100, 400);

        Rectangle green = new Rectangle(100, 100);
        green.setFill(Color.GREEN);
        Aux.translate(green, 150, 150, 300);

        Group center = new Group(green, red);

        CheckBox depthTestCbx = new CheckBox("DepthTest for Rectangles");
        depthTestCbx.setSelected(true);
        depthTestCbx.selectedProperty().addListener((prop, oldValue, newValue) -> {
            if (newValue) {
                red.setDepthTest(DepthTest.ENABLE);
                green.setDepthTest(DepthTest.ENABLE);
            } else {
                red.setDepthTest(DepthTest.DISABLE);
                green.setDepthTest(DepthTest.DISABLE);
            }
        });

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: transparent;");
        root.setTop(depthTestCbx);
        root.setCenter(center);

        Scene scene = new Scene(root, 200, 200, true);
        scene.setCamera(new PerspectiveCamera());
        stage.setScene(scene);
        stage.setTitle("Depth Test");
        stage.show();
    }
}
