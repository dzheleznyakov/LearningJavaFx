package zh.learn.javafx.ch16webview;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import zh.learn.javafx.Aux;

import java.net.URL;

public class JavaScriptToJavaFX extends Application {
    public class FXAdder {
        public double add(double n1, double n2) {
            return n1 + n2;
        }
    }

    private String HOME_PAGE = "html/javascript_to_javafx.html";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String homePageUrl = getHomePageUrl();
        BrowserPane browser = new BrowserPane(homePageUrl, stage);

        VBox root = new VBox(browser);
        Aux.showStage(stage, root);

        WebEngine webEngine = browser.getWebView().getEngine();
        webEngine.getLoadWorker().stateProperty().addListener(
                (prop, oldState, newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        JSObject jsWindow = (JSObject) webEngine.executeScript("window");
                        jsWindow.setMember("fxAdder", new FXAdder());
                    }
                });
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
