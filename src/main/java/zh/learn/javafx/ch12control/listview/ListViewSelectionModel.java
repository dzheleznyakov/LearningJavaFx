package zh.learn.javafx.ch12control.listview;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ListViewSelectionModel extends Application {
    protected ListView<String> seasons;
    private final Label selectedItemsLbl = new Label("[None]");
    private final Label lastSelectedItemLbl = new Label("[None]");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = getRoot();

        Aux.showStage(stage, root, "Using ListView Selection Model");
    }

    protected GridPane getRoot() {
        Label seasonsLbl = new Label("Select Seasons:");
        seasons = new ListView<>();
        seasons.setPrefSize(120, 120);
        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");

        seasons.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        seasons.getSelectionModel()
                .selectedItemProperty()
                .addListener(this::selectionChanged);

        Button selectAllBtn = new Button("Select All");
        selectAllBtn.setOnAction(e -> seasons.getSelectionModel().selectAll());

        Button clearAllBtn = new Button("Clear All");
        clearAllBtn.setOnAction(e -> seasons.getSelectionModel().clearSelection());

        Button selectFirstBtn = new Button("Select First");
        selectFirstBtn.setOnAction(e -> seasons.getSelectionModel().selectFirst());

        Button selectLastBtn = new Button("Select Last");
        selectLastBtn.setOnAction(e -> seasons.getSelectionModel().selectLast());

        Button selectNextBtn = new Button("Select Next");
        selectNextBtn.setOnAction(e -> seasons.getSelectionModel().selectNext());

        Button selectPreviousBtn = new Button("Select Previous");
        selectPreviousBtn.setOnAction(e -> seasons.getSelectionModel().selectPrevious());

        selectAllBtn.setMaxWidth(Double.MAX_VALUE);
        clearAllBtn.setMaxWidth(Double.MAX_VALUE);
        selectFirstBtn.setMaxWidth(Double.MAX_VALUE);
        selectLastBtn.setMaxWidth(Double.MAX_VALUE);
        selectNextBtn.setMaxWidth(Double.MAX_VALUE);
        selectPreviousBtn.setMaxWidth(Double.MAX_VALUE);

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);

        VBox singleSelectionButtons = new VBox(selectFirstBtn, selectNextBtn, selectPreviousBtn, selectLastBtn);
        VBox allSelectionButtons = new VBox(selectAllBtn, clearAllBtn);
        root.addColumn(0, seasonsLbl, seasons);
        root.add(singleSelectionButtons, 1, 1, 1, 1);
        root.add(allSelectionButtons, 2, 1, 1, 1);

        Label selectionLbl = new Label("Your selection:");
        root.add(selectionLbl, 0 , 2);
        root.add(selectedItemsLbl, 1, 2, 2, 1);

        Label lastSelectionLbl = new Label("Last selection:");
        root.add(lastSelectionLbl, 0, 3);
        root.add(lastSelectedItemLbl, 1, 3, 2, 1);

        Aux.style(root);

        return root;
    }

    public void selectionChanged(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        String lastItem = newValue == null ? "[None]" : "[" + newValue + "]";
        lastSelectedItemLbl.setText(lastItem);

        ObservableList<String> selectedItems = seasons.getSelectionModel().getSelectedItems();
        String selectedValues = selectedItems.isEmpty() ? "[None]" : selectedItems.toString();
        selectedItemsLbl.setText(selectedValues);
    }
}
