package zh.learn.javafx.ch18textnodes;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.net.URL;

public class TextCustomFont extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text t1 = new Text();
        t1.setLineSpacing(10);

        Text t2 = new Text("Another Text node");

        String fontFile = "font/4starfac.ttf";
        URL url = getClass().getClassLoader().getResource(fontFile);
        if (url != null) {
            String urlStr = url.toExternalForm();
            Font customFont = Font.loadFont(urlStr, 16);
            if (customFont != null) {
                t1.setFont(customFont);

                t1.setText("Hello from the custom font!!! \nFont Familiy: " +
                        customFont.getFamily());

                Font font2 = Font.font(customFont.getFamily(), FontWeight.BOLD, FontPosture.ITALIC, 24);
                t2.setFont(font2);
            } else {
                t1.setText("Could not load the custom font from " + urlStr);
            }
        } else {
            t1.setText("Could not find the cusom font file " +
                    fontFile + " in CLASSPATH. Used the default font");
        }

        HBox root = new HBox(20, t1, t2);
        Aux.style(root);

        Aux.showStage(stage, root, "Loading and Using Custom Font");
    }
}
