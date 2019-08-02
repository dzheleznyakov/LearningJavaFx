package zh.learn.javafx.ch12control.slider;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SliderCss extends SliderTest {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = getRoot();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/training/sliderstyle.css");
        stage.setScene(scene);
        stage.setTitle("Styling Slider with CSS");
        stage.show();
    }
}
