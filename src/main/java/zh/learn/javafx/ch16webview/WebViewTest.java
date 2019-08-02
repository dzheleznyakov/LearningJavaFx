package zh.learn.javafx.ch16webview;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        webEngine.titleProperty().addListener((ObservableValue<? extends String> p, String oldTitle, String newTitle) -> {
            stage.setTitle(newTitle);
        });

        webEngine.load("http://www.google.com");

        VBox root = new VBox(webView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
