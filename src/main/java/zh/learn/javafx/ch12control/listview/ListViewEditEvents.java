package zh.learn.javafx.ch12control.listview;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ListViewEditEvents extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ListView<String> breakfasts = new ListView<>();
        breakfasts.setPrefSize(200, 120);
        breakfasts.getItems().addAll("Apple", "Banana", "Donut", "Hash Brown");
        breakfasts.setEditable(true);
        breakfasts.setCellFactory(TextFieldListCell.forListView());

        breakfasts.setOnEditStart(this::editStart);
        breakfasts.setOnEditCommit(this::editCommit);
        breakfasts.setOnEditCancel(this::editCancel);

        HBox root = new HBox(new Label("Breakfast:"), breakfasts);
        root.setSpacing(20);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ListView Edit Events");
    }

    public void editStart(ListView.EditEvent<String> e) {
        System.out.println("Edit Start: Index=" + e.getIndex() +
                ", Item=" + e.getNewValue());
    }

    public void editCommit(ListView.EditEvent<String> e) {
        System.out.println("Edit Commit: Index=" + e.getIndex() +
                ", Item=" + e.getNewValue());;
    }

    public void editCancel(ListView.EditEvent<String> e) {
        System.out.println("Edit Cancel: Index=" + e.getIndex() +
                ", Item=" + e.getNewValue());;
    }
}
