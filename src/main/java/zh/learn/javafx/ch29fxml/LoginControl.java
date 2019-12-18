package zh.learn.javafx.ch29fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    public LoginControl() {
        URL fxmlUrl = getClass()
                .getClassLoader()
                .getResource("fxml/login.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlUrl);
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initialize() {
        System.out.println("LoginControl.initialize()");
    }

    @FXML
    private void okClicked() {
        System.out.println("OK clicked");
    }

    @FXML
    private void cancelClicked() {
        System.out.println("Cancel clicked");
    }

    public String getUserId() {
        return userId.getText();
    }

    public String getPassword() {
        return pwd.getText();
    }
}
