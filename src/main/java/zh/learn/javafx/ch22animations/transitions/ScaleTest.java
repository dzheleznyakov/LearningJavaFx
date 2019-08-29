package zh.learn.javafx.ch22animations.transitions;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

public class ScaleTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Rectangle rect = new Rectangle(200, 50, Color.RED);
        HBox root = new HBox(rect);
        Aux.showStage(stage, root, "Scale Transition");

        ScaleTransition st = new ScaleTransition(Duration.seconds(2), rect);
        st.setFromX(1.0);
        st.setToX(0.2);
        st.setFromY(1.0);
        st.setToY(0.2);
        st.setCycleCount(ScaleTransition.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
    }
}
