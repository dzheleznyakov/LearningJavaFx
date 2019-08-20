package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class DisplacementMapWrap extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        int width = 200;
        int height = 25;

        FloatMap map = new FloatMap(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double u = 100.0 / width;
                map.setSamples(i, j, (float) u, 0.0f);
            }
        }

        Text t1 = new Text("Displaced Text");
        t1.setFont(Font.font(24));
        DisplacementMap effect1 = new DisplacementMap();
        effect1.setMapData(map);
        t1.setEffect(effect1);

        Text t2 = new Text("Displaced Text");
        t2.setFont(Font.font(24));
        DisplacementMap effect2 = new DisplacementMap();
        effect2.setWrap(true);
        effect2.setMapData(map);
        t2.setEffect(effect2);

        VBox root = new VBox(5, t1, t2);
        Aux.style(root);

        Aux.showStage(stage, root, "Using the Wraps Property in Displacement Wrap");
    }
}
