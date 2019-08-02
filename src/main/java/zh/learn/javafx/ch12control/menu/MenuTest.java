package zh.learn.javafx.ch12control.menu;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class MenuTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu optionsMenu = new Menu("Options");
        Menu helpMenu = new Menu("Help");

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, optionsMenu, helpMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Menus");
    }
}
