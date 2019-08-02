package zh.learn.javafx.ch19threedshapes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class MaterialTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Box box = new Box(100, 100, 100);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.TAN);
        box.setMaterial(material);

        Aux.translate(box, 250, 0, 400);

        Box boxWithTexture = new Box(100, 100, 100);
        PhongMaterial textureMaterial = new PhongMaterial();
        Image randomness = new Image("picture/randomness.jpg");
        textureMaterial.setDiffuseMap(randomness);
        boxWithTexture.setMaterial(textureMaterial);

        boxWithTexture.setTranslateX(450);
        boxWithTexture.setTranslateY(-5);
        boxWithTexture.setTranslateZ(400);

        PointLight light = new PointLight();
        Aux.translate(light, 250, 100, 300);

        Group root = new Group(box, boxWithTexture);

        Scene scene = new Scene(root, 300, 100, true);

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(200);
        camera.setTranslateY(-50);
        camera.setTranslateZ(325);
        scene.setCamera(camera);

        stage.setScene(scene);
        stage.setTitle("Using Material Color and Texture for 3D Surface");
        stage.show();
    }
}
