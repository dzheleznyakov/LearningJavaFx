package zh.learn.javafx.ch16webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.net.URL;

public class JSCommandTest extends Application {
    private final String DEFAULT_HOME_PAGE = "html/jshandlers.html";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String homePageUrl = getDefaultHomePageUrl();
        BrowserPane root = new BrowserPane(homePageUrl, stage);

        Aux.showStage(stage, root);
    }

    private String getDefaultHomePageUrl() {
        String pageUrl = "http://www.google.com";
        URL url = getClass().getClassLoader().getResource(DEFAULT_HOME_PAGE);

        if (url == null)
            System.out.println("Could not find " + DEFAULT_HOME_PAGE + " in CLASSPATH. " +
                    "Using " + pageUrl + " as the default home page.");
        else
            pageUrl = url.toExternalForm();
        return pageUrl;
    }
}
