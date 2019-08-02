package zh.learn.javafx.ch12control.choicebox;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ChoiceBoxTestWithSeparators extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label fruitLbl = new Label("Select a Fruit:");
        ChoiceBox breakfasts = new ChoiceBox<>();
        breakfasts.getItems().addAll("Apple", "Banana", "Strawberry",
                new Separator(),
                "Apple Pie", "Donut", "HashBrown");

        breakfasts.getSelectionModel().selectFirst();

        breakfasts.getSelectionModel().selectedItemProperty()
                .addListener(this::itemChanged);
        breakfasts.getSelectionModel().selectedIndexProperty()
                .addListener(this::indexChanged);

        Label selectionMsgLbl = new Label("Your Selection:");
        Label selectedValueLbl = new Label("None");

        selectedValueLbl.textProperty().bind(breakfasts.valueProperty());

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0, fruitLbl, breakfasts);
        root.addRow(1, selectionMsgLbl, selectedValueLbl);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ChoiceBox Controls");
    }

    public void itemChanged(ObservableValue<? extends Object> observable,
                            Object oldValue,
                            Object newValue) {
        System.out.println("Item changed: old = " + oldValue + ", new = " + newValue);
    }

    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue) {
        System.out.println("Index changed: old = " + oldValue + ", new = " + newValue);
    }
}
