package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ReflectionTypeTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text text = new Text();
        text.setText("Chatar");
        text.setFill(Color.RED);
        text.setFont(Font.font(null, FontWeight.BOLD, 72));
        text.setBoundsType(TextBoundsType.VISUAL);

        Rectangle rect = new Rectangle(300, 100);
        rect.setFill(Color.LIGHTGRAY);

        Lighting effect = new Lighting();
        text.setEffect(effect);
        rect.setEffect(effect);

        StackPane sp = new StackPane(rect, text);

        GridPane controllersPane = LightingUtil.getPropertyControllers(effect);
        BorderPane root = new BorderPane();
        root.setCenter(sp);
        root.setRight(controllersPane);
        Aux.style(root);

        Aux.showStage(stage, root, "Controlling Reflection Details");
    }
}
