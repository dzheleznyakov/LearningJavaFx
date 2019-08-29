package zh.learn.javafx.ch22animations;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HoppingTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text msg = new Text("Hopping text!");
        msg.setTextOrigin(VPos.TOP);
        msg.setFont(Font.font(24));

        Pane root = new Pane(msg);
        root.setPrefSize(500, 70);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hopping Txt");
        stage.show();

        double start = scene.getWidth();
        double end = -1.0 * msg.getLayoutBounds().getWidth();

        KeyFrame[] frames = new KeyFrame[11];
        for (int i = 0; i <= 10; i++) {
            double pos = start - (start - end) * i / 10.0;
            double duration = i / 5.0;
            KeyValue keyValue = new KeyValue(msg.translateXProperty(), pos, Interpolator.DISCRETE);
            frames[i] = new KeyFrame(Duration.seconds(duration), keyValue);
        }

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(frames);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();
    }
}
