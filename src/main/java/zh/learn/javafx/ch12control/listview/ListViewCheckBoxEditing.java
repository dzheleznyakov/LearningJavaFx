package zh.learn.javafx.ch12control.listview;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import zh.learn.javafx.Aux;

import java.util.HashMap;
import java.util.Map;

public class ListViewCheckBoxEditing extends Application {
    Map<String, ObservableValue<Boolean>> map = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        map.put("Apple", new SimpleBooleanProperty(false));
        map.put("Banana", new SimpleBooleanProperty(false));
        map.put("Donut", new SimpleBooleanProperty(false));
        map.put("Hash Brown", new SimpleBooleanProperty(false));

        ListView<String> breakfasts = new ListView<>();
        breakfasts.setPrefSize(200, 120);
        breakfasts.setEditable(true);
        breakfasts.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        breakfasts.getItems().addAll(map.keySet());

        Callback<String, ObservableValue<Boolean>> itemToBoolean = map::get;

        breakfasts.setCellFactory(CheckBoxListCell.forListView(itemToBoolean));

        Button printBtn = new Button("Print Selection");
        printBtn.setOnAction(e -> printSelection());

        VBox root = new VBox(new Label("Breakfasts:"), breakfasts, printBtn);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ListView Cell Factory");
    }

    public void printSelection() {
        System.out.println("Selected items:");
        map.keySet().stream()
                .filter(key -> map.get(key).getValue())
                .forEach(System.out::println);
        System.out.println();
    }
}
