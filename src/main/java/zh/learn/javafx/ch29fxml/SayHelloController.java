package zh.learn.javafx.ch29fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SayHelloController {
    @FXML
    private Label msgLbl;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    public SayHelloController() {
    }

    @FXML
    private void initialize() {
        System.out.println("Initializing SayHelloController...");
        System.out.println("Location = " + location);
        System.out.println("Resources = " + resources);
    }

    @FXML
    private void sayHello() {
        msgLbl.setText("Hello from FXML!");
    }
}
