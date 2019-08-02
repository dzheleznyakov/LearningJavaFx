package zh.learn.javafx.ch19threedshapes;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SubSceneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        SubScene ySwing = getSubScene(Rotate.Y_AXIS);
        SubScene xSwing = getSubScene(Rotate.X_AXIS);

        HBox root = new HBox(20, ySwing, xSwing);

        Scene scene = new Scene(root, 500, 300, true);
        stage.setScene(scene);
        stage.setTitle("Using Sub-Scenes");
        stage.show();
    }

    private SubScene getSubScene(Point3D rotationAxis) {
        Box box = new Box(100, 100, 100);
        box.setCullFace(CullFace.NONE);
        box.setTranslateX(250);
        box.setTranslateY(100);
        box.setTranslateZ(400);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);

        RotateTransition rt = new RotateTransition(Duration.seconds(2), camera);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setFromAngle(-10);
        rt.setToAngle(10);

    }
}
