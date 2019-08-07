package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class EffectTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t1 = new Text("Drop Shadow!");
        t1.setFont(Font.font(24));
        t1.setEffect(new DropShadow());

        Text t2 = new Text("Blur!");
        t2.setFont(Font.font(24));
        t2.setEffect(new BoxBlur());

        Text t3 = new Text("Glow");
        t3.setFont(Font.font(24));
        t3.setEffect(new Glow());

        Text t4 = new Text("Bloom!");t4.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        t4.setFill(Color.WHITE);
        t4.setEffect(new Bloom());

        Rectangle rect = new Rectangle(100, 300, Color.GREEN);
        StackPane spane = new StackPane(rect, t4);

        HBox root = new HBox(20, t1, t2, t3, spane);
        Aux.style(root);

        Aux.showStage(stage, root, "Applying Effects");
    }
}
