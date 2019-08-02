package zh.learn.javafx.ch10container.flowpane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class FlowPaneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        double hgap = 5;
        double vgap = 10;
        FlowPane root = new FlowPane(hgap, vgap);
        for (int i = 1; i <= 10; i++) {
            root.getChildren().add(new Button("Button " + i));
        }

        Aux.style(root);

        Aux.showStage(stage, root, "A Horizontal FlowPan");
    }
}
