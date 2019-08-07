package zh.learn.javafx.ch20effects;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class InnerShadowTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        InnerShadow is1 = new InnerShadow();
        is1.setOffsetX(3);
        is1.setOffsetY(6);

        Text t1 = new Text("InnerShadow");
        t1.setEffect(is1);
        t1.setFill(Color.RED);
        t1.setFont(Font.font(null, FontWeight.BOLD, 36));

        InnerShadow is2 = new InnerShadow();
        is2.setOffsetX(3);
        is2.setOffsetY(3);
        is2.setColor(Color.GRAY);
        Rectangle rect1 = new Rectangle(100, 50, Color.LIGHTGRAY);
        rect1.setEffect(is2);

        InnerShadow is3 = new InnerShadow();
        is3.setOffsetX(-3);
        is3.setOffsetY(-3);
        is3.setColor(Color.GRAY);
        Rectangle rect2 = new Rectangle(100, 50, Color.LIGHTGRAY);
        rect2.setEffect(is3);

        HBox root = new HBox(10, wrap(t1, is1), wrap(rect1, is2), wrap(rect2, is3));
        Aux.style(root);

        Aux.showStage(stage, root, "Applying InnerShadow Effect");
    }

    private VBox wrap(Shape s, InnerShadow in) {
        Text t = new Text("offsetX=" + in.getOffsetX() + "\n" +
                "offsetY=" + in.getOffsetY());
        t.setFont(Font.font(10));

        VBox box = new VBox(10, s, t);
        box.setAlignment(Pos.CENTER);
        return box;
    }
}
