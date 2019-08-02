package zh.learn.javafx.ch16webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.net.URL;

public class JavaFXToJavaScript extends Application {
    private final String HOME_PAGE = "html/javafx_to_javascript.html";
    private Integer jsTimerId = null;
    private WebEngine webEngine;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String homePageUrl = getHomePageUrl();
        BrowserPane browser = new BrowserPane(homePageUrl, stage);

        webEngine = browser.getWebView().getEngine();

        Button startTimeBtn = new Button("Start Showing Time");
        startTimeBtn.setOnAction(e -> startJSTimer());

        Button stopTimeBtn = new Button("Stop Showing Time");
        stopTimeBtn.setOnAction(e -> stopJSTime());

        HBox buttons = new HBox(10, startTimeBtn, stopTimeBtn);
        VBox root = new VBox(10, buttons, browser);
        Aux.showStage(stage, root);
    }

    private void startJSTimer() {
        try {
            jsTimerId = (Integer) webEngine.executeScript("startShowingTime()");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void stopJSTime() {
        if (jsTimerId != null) {
            String script = "stopShowingTime(" + jsTimerId + ")";
            webEngine.executeScript(script);
            jsTimerId = null;
        }
    }

    private String getHomePageUrl() {
        String pageUrl = null;
        URL url = getClass().getClassLoader().getResource(HOME_PAGE);
        if (url == null) {
            System.out.println("Could not find " + HOME_PAGE + " in CLASSPATH." +
                    " Use the Open button in the navigation bar to open it.");
        } else {
            pageUrl = url.toExternalForm();
        }
        return pageUrl;
    }
}
