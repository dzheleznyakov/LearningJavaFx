package zh.learn.javafx.ch29fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CloseBtnController {
    @FXML
    private Button closeBtn;

    @FXML
    public void initialize() {
        System.out.println("CloseBtnController.initialize()");
    }
}
