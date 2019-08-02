package zh.learn.javafx.ch12control.buttons;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class SplitMenuButtonTest extends Application {
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

        SplitMenuButton splitBtn = new SplitMenuButton();
        splitBtn.setText("Home");

        splitBtn.getItems().addAll(jdojo, yahoo, google);

        splitBtn.setOnAction(e -> loadPage("http://www.jdojo.com"));

        BorderPane root = new BorderPane();
        root.setTop(splitBtn);
        BorderPane.setAlignment(splitBtn, Pos.TOP_RIGHT);
        root.setCenter(webView);

        Aux.showStage(stage, root, "Using SplitMenuButton Controls");
    }

    public void loadPage(String url) {
        webView.getEngine().load(url);
    }
}
