package zh.learn.javafx.ch12control.buttons;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class MenuButtonTest extends Application {
    private WebView webView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        webView = new WebView();

        MenuItem jdojo = new MenuItem("JDojo");
        jdojo.setOnAction(e -> loadPage("http://www.jdojo.com"));

        MenuItem yahoo = new MenuItem("Yahoo!");
        yahoo.setOnAction(e -> loadPage("http://www.yahoo.com"));

        MenuItem google = new MenuItem("Google");
        google.setOnAction(e -> loadPage("http://www.google.com"));

        MenuButton links = new MenuButton("Visit");
        links.getItems().addAll(jdojo, yahoo, google);

        BorderPane root = new BorderPane();
        root.setTop(links);
        BorderPane.setAlignment(links, Pos.TOP_RIGHT);
        root.setCenter(webView);

        Aux.showStage(stage, root, "Using MenuButton Controls");
    }

    public void loadPage(String url) {
        webView.getEngine().load(url);
    }
}
