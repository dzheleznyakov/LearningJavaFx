package zh.learn.javafx.ch19threedshapes;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class CameraTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Box box = new Box(100, 100, 100);
        box.setCullFace(CullFace.NONE);
        Aux.translate(box, 250, 100, 400);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);

        RotateTransition rt = new RotateTransition(Duration.seconds(2), camera);
        rt.setCycleCount((Animation.INDEFINITE));
        rt.setFromAngle(0);
        rt.setToAngle(90);
        rt.setAutoReverse(true);
        rt.setAxis(Rotate.X_AXIS);
        rt.play();

        PointLight redLight = new PointLight();
        redLight.setColor(Color.RED);
        redLight.setTranslateX(250);
        redLight.setTranslateY(-100);
        redLight.setTranslateZ(250);

        PointLight greenLight = new PointLight();
        greenLight.setColor(Color.GREEN);
        Aux.translate(greenLight, 250, 300, 300);

        Group root = new Group(box, redLight, greenLight);
        root.setRotationAxis(Rotate.X_AXIS);
        root.setRotate(30);

        Aux.showStage(stage, root, 500, 300, camera, "Using Cameras");
    }
}
