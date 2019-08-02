package zh.learn.javafx.ch19threedshapes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class DrawModeTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Box box = new Box(100, 100, 100);
        box.setDrawMode(DrawMode.LINE);
        box.setTranslateX(150);
        box.setTranslateY(0);
        box.setTranslateZ(400);

        Sphere sphere = new Sphere(50, 20);
        sphere.setDrawMode(DrawMode.LINE);
        sphere.setTranslateX(300);
        sphere.setTranslateY(-5);
        sphere.setTranslateZ(400);

        Cylinder cylinder = new Cylinder(40, 120, 5);
        cylinder.setDrawMode(DrawMode.LINE);
        cylinder.setTranslateX(500);
        cylinder.setTranslateY(-25);
        cylinder.setTranslateZ(600);

        PointLight light = new PointLight();
        light.setTranslateX(350);
        light.setTranslateY(100);
        light.setTranslateZ(300);

        Group root = new Group(box, sphere, cylinder, light);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(100);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);

        Aux.showStage(stage, root, 300, 100, camera, "Drawing Only Lines");
    }
}
