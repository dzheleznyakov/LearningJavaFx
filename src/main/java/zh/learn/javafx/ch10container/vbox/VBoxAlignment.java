package zh.learn.javafx.ch10container.vbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class VBoxAlignment extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        VBox vbox = new VBox(10);
        vbox.setPrefSize(200, 100);
        vbox.getChildren().addAll(okBtn, cancelBtn);

        vbox.setAlignment(Pos.BOTTOM_RIGHT);
        Aux.style(vbox);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Using VBox Alignment Property");
        stage.show();
    }
}
