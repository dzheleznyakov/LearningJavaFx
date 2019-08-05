package zh.learn.javafx.ch19threedshapes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class Tetrahedron extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MeshView meshView = createMeshView();
        Aux.translate(meshView,250, 50, 400);
        Aux.scale(meshView, 10.0, 20.0, 10.0);

        PerspectiveCamera camera = new PerspectiveCamera();
        Aux.translate(camera, 100, 0, 100);

        PointLight redLight = new PointLight();
        redLight.setColor(Color.RED);
        Aux.translate(redLight, 150, -100, 250);

        Group root = new Group(meshView, redLight);
        root.setRotationAxis(Rotate.Y_AXIS);
        root.setRotate(45);

        Aux.showStage(stage, root, 200, 150, camera, "A Tetrahedron using a TriangleMesh");
    }

    private MeshView createMeshView() {
        float[] points = {
                10, 10, 10,
                20, 20, 0,
                0, 20, 0,
                10, 20, 20
        };

        float[] texCoords = {
                0.50f, 0.33f,
                0.25f, 0.75f,
                0.50f, 1.00f,
                0.66f, 0.66f,
                1.00f, 0.35f,
                0.90f, 0.00f,
                0.10f, 0.00f,
                0.00f, 0.35f
        };

        int[] faces = {
                0, 0, 2, 1, 1, 3,
                0, 0, 1, 3, 2, 1,
                0, 0, 1, 4, 3, 5,
                0, 0, 3, 5, 1, 4,
                0, 0, 3, 6, 2, 7,
                0, 0, 2, 7, 3, 6,
                1, 3, 3, 2, 2, 1,
                1, 3, 2, 1, 3, 2
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
