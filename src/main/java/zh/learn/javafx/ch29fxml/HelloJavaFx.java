package zh.learn.javafx.ch29fxml;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class HelloJavaFx extends Application {
    private final Label msgLbl = new Label("FXML is cool!");
    private final Button sayHelloBtn = new Button("Say Hello");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        msgLbl.setPrefWidth(150);
        sayHelloBtn.setOnAction(this::sayHello);

        VBox root = new VBox(10);
        root.getChildren().addAll(msgLbl, sayHelloBtn);
        Aux.style(root);
        Aux.showStage(stage, root, "Hello FXML");
    }

    private void sayHello(ActionEvent e) {
        msgLbl.setText("Hello from FXML!");
    }
}
