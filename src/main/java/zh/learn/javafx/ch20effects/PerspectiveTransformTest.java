package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class PerspectiveTransformTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PerspectiveTransform effect = new PerspectiveTransform();
        effect.setUlx(0.0);
        effect.setUly(0.0);
        effect.setUrx(250.0);
        effect.setUry(20.0);
        effect.setLrx(310.0);
        effect.setLry(60.0);
        effect.setLlx(20.0);
        effect.setLly(60.0);

        Rectangle rect1 = new Rectangle(200, 60, Color.LIGHTGRAY);
        Rectangle rect2 = new Rectangle(200, 60, Color.LIGHTGRAY);

        Text text1 = new Text();
        text1.setX(20);
        text1.setY(40);
        text1.setText("Welcome");
        text1.setFill(Color.RED);
        text1.setFont(Font.font(null, FontWeight.BOLD, 36));

        System.out.println(text1.getLayoutBounds());

        Text text2 = new Text();
        text2.setX(20);
        text2.setY(40);
        text2.setText("Welcome");
        text2.setFill(Color.RED);
        text2.setFont(Font.font(null, FontWeight.BOLD, 36));

        Group group1 = new Group(rect1, text1);

        Group group2 = new Group(rect2, text2);
        group2.setEffect(effect);
        group2.setCache(true);

        HBox root = new HBox(20, group1, group2);
        Aux.style(root);

        Aux.showStage(stage, root, "Applying the PerspectiveTransform Effect");
    }
}
