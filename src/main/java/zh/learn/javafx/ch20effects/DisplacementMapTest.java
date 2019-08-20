package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class DisplacementMapTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        int width = 250;
        int height = 50;
        FloatMap map = new FloatMap(width, height);

        double xDisplacement = 1.0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double u = xDisplacement;
                if (j < height / 2) {
                    u = -1.0 * (u * xDisplacement / width);
                } else {
                    u = u * xDisplacement / width;
                }
                map.setSamples(i, j, (float) u, 0.0f);
            }
        }

        Text t1 = new Text("Displaced Text");
        t1.setFont(Font.font(36));
        DisplacementMap effect1 = new DisplacementMap();
        effect1.setMapData(map);
        t1.setEffect(effect1);

        HBox root = new HBox(t1);
        Aux.style(root);

        Aux.showStage(stage, root, "Applying the DisplacementMap Effect");
    }
}
