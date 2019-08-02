package zh.learn.javafx.ch12control.listview;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListViewCss extends ListViewSelectionModel {
    private ListView<String> seasons;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = getRoot();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("css/training/listviewstyle.css");

        stage.setScene(scene);
        stage.setTitle("Styling ListView with CSS");
        stage.show();
    }
}
