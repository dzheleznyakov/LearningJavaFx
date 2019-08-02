package zh.learn.javafx.ch12control.combobox;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class ComboBoxTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label seasonsLbl = new Label("Season:");
        ComboBox<String> seasons = new ComboBox<>();
        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");

        Label breakfastsLbl = new Label("Breakfast:");
        ComboBox<String> breakfasts = new ComboBox<>();
        breakfasts.getItems().addAll("Apple", "Banana", "Strawberry");
        breakfasts.setEditable(true);

        Label selectionLbl = new Label();
        StringProperty str = new SimpleStringProperty("Your selection: ");
        selectionLbl.textProperty().bind(str.concat("Season=")
                .concat(seasons.valueProperty())
                .concat(", Breakfast=")
                .concat(breakfasts.valueProperty()));

        HBox row1 = new HBox(seasonsLbl, seasons, breakfastsLbl, breakfasts);
        row1.setSpacing(10);
        VBox root = new VBox(row1, selectionLbl);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ComboBox Controls");
    }
}
