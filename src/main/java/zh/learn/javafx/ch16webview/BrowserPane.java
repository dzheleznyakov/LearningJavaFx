package zh.learn.javafx.ch16webview;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.Window;

public class BrowserPane extends BorderPane {
    private static String DEFAULT_HOME_PAGE = "http://www.google.com";
    private WebView webView;

    public BrowserPane(Window ownerWindow) {
        this(null, ownerWindow);
    }

    public BrowserPane(String homePageUrl, Window ownerWindow) {
        this(homePageUrl, true, true, true, ownerWindow);
    }

    public BrowserPane(String homePageUrl,
                       boolean enableNavigatorBar,
                       boolean enableStatusBar,
                       boolean enableJSHandlers,
                       Window ownerWindow) {
        webView = new WebView();
        setCenter(webView);

        if (homePageUrl == null)
            homePageUrl = DEFAULT_HOME_PAGE;

        if (enableNavigatorBar)
            addNavigationBar(homePageUrl);

        if (enableStatusBar)
            addStatusBar();

        if (enableJSHandlers)
            addJSHandlers(ownerWindow);
    }

    private void addNavigationBar(String homePageUrl) {
        WebOptionsMenu options = new WebOptionsMenu(webView);
        BrowserHistory historyComponent = new BrowserHistory(webView);
        NavigationBar navBar = new NavigationBar(webView, homePageUrl, true);
        navBar.getChildren().addAll(options, historyComponent);
        setTop(navBar);
    }

    private void addStatusBar() {
        Label statusLbl = new Label();

        statusLbl.setStyle("-fx-background-color: lightgray;");
        statusLbl.prefWidthProperty().bind(webView.widthProperty());

        webView.getEngine().getLoadWorker().messageProperty().addListener(
                (prop, oldMsg, newMsg) -> statusLbl.setText(newMsg));

        webView.getEngine().setOnStatusChanged(
                e -> statusLbl.setText(e.getData()));

        setBottom(statusLbl);
    }

    private void addJSHandlers(Window ownerWindow) {
        webView.getEngine().setPromptHandler(JSHandlers::promptHandler);
        webView.getEngine().setCreatePopupHandler(JSHandlers::popupHandler);
        webView.getEngine().setOnAlert(JSHandlers::alertHandler);
        webView.getEngine().setConfirmHandler(JSHandlers::confirmHandler);

        if (ownerWindow instanceof Stage) {
            Stage stage = (Stage) ownerWindow;

            webView.getEngine().titleProperty().addListener(
                    (prop, oldTitle, newTitle) -> stage.setTitle(newTitle));
        }
    }

    public WebView getWebView() {
        return webView;
    }
}
