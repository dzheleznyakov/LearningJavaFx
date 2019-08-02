package zh.learn.javafx.ch12control.buttons;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class HyperlinkTest extends Application {
    private WebView webView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        webView = new WebView();
        Hyperlink jdojoLink = new Hyperlink("JDojo");
        jdojoLink.setOnAction(e -> loadPage("http://www.jdojo.com"));

        Hyperlink yahooLink = new Hyperlink("Yahoo!");
        yahooLink.setOnAction(e -> loadPage("http://www.yahoo.com"));

        Hyperlink googleLink = new Hyperlink("Google");
        googleLink.setOnAction(e -> loadPage("http://www.google.com"));

        HBox linkBox = new HBox(jdojoLink, yahooLink, googleLink);
        linkBox.setSpacing(10);
        linkBox.setAlignment(Pos.TOP_RIGHT);

        BorderPane root = new BorderPane();
        root.setTop(linkBox);
        root.setCenter(webView);

        Aux.showStage(stage, root, "Using Hyperlink Controls");
    }

    public void loadPage(String url) {
        webView.getEngine().load(url);
    }
}
