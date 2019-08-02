package zh.learn.javafx.ch12control.choicebox;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import zh.learn.javafx.Aux;

public class ChoiceBoxTestWithNulls extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label seasonLbl = new Label("Select a Season:");
        ChoiceBox<String> seasons = new ChoiceBox<>();
        seasons.getItems().addAll(null, "Spring", "Summer", "Fall", "Winter");

        seasons.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String string) {
                return (string == null) ? "[None]" : string;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        });

        seasons.getSelectionModel().selectFirst();

        seasons.getSelectionModel().selectedItemProperty()
                .addListener(this::itemChanged);
        seasons.getSelectionModel().selectedIndexProperty()
                .addListener(this::indexChanged);

        Label selectionMsgLbl = new Label("Your Selection:");
        Label selectedValueLbl = new Label("None");

        selectedValueLbl.textProperty().bind(seasons.valueProperty());

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0, seasonLbl, seasons);
        root.addRow(1, selectionMsgLbl, selectedValueLbl);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ChoiceBox Controls");
    }

    public void itemChanged(ObservableValue<? extends String> observable,
                            String oldValue,
                            String newValue) {
        System.out.println("Item changed: old = " + oldValue + ", new = " + newValue);
    }

    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue) {
        System.out.println("Index changed: old = " + oldValue + ", new = " + newValue);
    }
}
