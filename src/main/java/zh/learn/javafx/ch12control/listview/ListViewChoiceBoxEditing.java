package zh.learn.javafx.ch12control.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ListViewChoiceBoxEditing extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ListView<String> breakfasts = new ListView<>();
        breakfasts.setPrefSize(200, 120);
        breakfasts.setEditable(true);
        breakfasts.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        breakfasts.getItems().addAll("[Double click to select]",
                "[Double click to select]",
                "[Double click to select]",
                "[Double click to select]");

        ObservableList<String> items = FXCollections.observableArrayList(
                "Apple", "Banana", "Donut", "Hash Brown");

        breakfasts.setCellFactory(ChoiceBoxListCell.forListView(items));

        VBox root = new VBox(new Label("Double click an item to select."),
                new Label("Breakfasts:"),
                breakfasts);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ListView Cell Factory");
    }
}
