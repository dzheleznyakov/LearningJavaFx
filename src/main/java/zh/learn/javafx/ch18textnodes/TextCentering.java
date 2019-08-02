package zh.learn.javafx.ch18textnodes;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextCentering extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text msg = new Text("A Centered Text Node");

        msg.setTextOrigin(VPos.TOP);

        Group root = new Group();
        root.getChildren().addAll(msg);

        Scene scene = new Scene(root, 200, 50);
        msg.layoutXProperty().bind(scene.widthProperty().subtract(msg.layoutBoundsProperty().get().getWidth()).divide(2));
        msg.layoutYProperty().bind(scene.heightProperty().subtract(msg.layoutBoundsProperty().get().getHeight()).divide(2));

        stage.setTitle("Centring a Text Node in a Scene");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
