package zh.learn.javafx.ch12control.scrolling;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ScrollPaneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label poemLbl = new Label("I told her this; her laughter light\n" +
                "Is ringing in my ears;\n" +
                "And when I think upon that night\n" +
                "My eyes are dim with tears.");

        ScrollPane sPane = new ScrollPane(poemLbl);
        sPane.setPannable(true);

        HBox root = new HBox(sPane);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ScrollPane Controls");
    }
}
