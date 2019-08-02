package zh.learn.javafx.ch16webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class BasicWebBrowser extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        webView.getEngine().titleProperty().addListener(
                (p, oldTitle, newTitle) -> stage.setTitle(newTitle));

        String homePageUrl = "http://www.google.com";
        WebOptionsMenu options = new WebOptionsMenu(webView);
        NavigationBar navBar = new NavigationBar(webView, homePageUrl, true);
        BrowserHistory browserHistory = new BrowserHistory(webView);
        navBar.getChildren().add(options);

        VBox root = new VBox(navBar, browserHistory, webView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
