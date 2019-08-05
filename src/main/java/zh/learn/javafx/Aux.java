package zh.learn.javafx;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aux {
    public static void style(Node pane) {
        pane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
    }

    public static void translate(Node node, double translateX, double translateY, double translateZ) {
        node.setTranslateX(translateX);
        node.setTranslateY(translateY);
        node.setTranslateZ(translateZ);
    }

    public static void scale(Node node, double scaleX, double scaleY, double scaleZ) {
        node.setScaleX(scaleX);
        node.setScaleY(scaleY);
        node.setScaleZ(scaleZ);
    }

    public static void showStage(Stage stage, Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void showStage(Stage stage, Parent root, String title) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public static void showStage(Stage stage, Parent root, double width, double height, String title) {
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public static void showStage(Stage stage, Parent root, double width, double height, PerspectiveCamera camera, String title) {
        Scene scene = new Scene(root, width, height, true);
        scene.setCamera(camera);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
