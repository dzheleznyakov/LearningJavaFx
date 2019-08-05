package zh.learn.javafx.ch19threedshapes;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class TriangleWithAMesh extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MeshView meshView = createMeshView();
        Aux.translate(meshView, 250, 100, 400);
        Aux.scale(meshView, 10.0, 10.0, 10.0);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        Aux.translate(camera, 100, -50, 300);


        RotateTransition rt = new RotateTransition(Duration.seconds(2), camera);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setFromAngle(-30);
        rt.setToAngle(30);
        rt.setAutoReverse(true);
        rt.setAxis(Rotate.Y_AXIS);
        rt.play();

        PointLight redLight = new PointLight();
        redLight.setColor(Color.RED);
        Aux.translate(redLight, 250, 150, 300);

        PointLight greenLight = new PointLight();
        greenLight.setColor(Color.GREEN);
        Aux.translate(greenLight, 200, 150, 450);

        Group root = new Group(meshView, redLight, greenLight);
        root.setRotationAxis(Rotate.Y_AXIS);
        root.setRotate(90);

        Aux.showStage(stage, root, 400, 300, camera, "Creating a Triangle using a TriangleMesh");
    }

    private MeshView createMeshView() {
        float[] points = {
                50, 0, 0,
                45, 10, 0,
                55, 10, 0
        };

        float[] texCoords = {
                0.5f, 0.5f,
                0.0f, 1.0f,
                1.0f, 1.0f
        };

        int[] faces = {
                0, 0, 2, 2, 1, 1,
                0, 0, 1, 1, 2, 2
        };

        TriangleMesh mesh = new TriangleMesh();
        mesh.getPoints().addAll(points);
        mesh.getTexCoords().addAll(texCoords);
        mesh.getFaces().addAll(faces);

        MeshView meshView = new MeshView();
        meshView.setMesh(mesh);

        return meshView;
    }
}
