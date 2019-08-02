package zh.learn.javafx.ch12control.listview;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;
import zh.learn.javafx.ch12control.choicebox.PersonStringConverter;

public class ListViewEditing extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ListView<String> breakfasts = getBreakfastListView();
        ListView<Person> persons = getPersonListView();

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.add(new Label("Double click an item to edit."), 0, 0, 2, 1);
        root.addRow(1, new Label("Persons:"), new Label("Breakfasts:"));
        root.addRow(2, persons, breakfasts);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ListView Editing");
    }

    public ListView<Person> getPersonListView() {
        ListView<Person> persons = new ListView<>();
        persons.setPrefSize(200, 120);
        persons.setEditable(true);
        persons.getItems().addAll(
                new Person("John", "Jacobs", null),
                new Person("Donna", "Duncan", null),
                new Person("Layne", "Estes", null),
                new Person("Mason", "Boyd", null)
        );

        StringConverter<Person> converter = new PersonStringConverter();
        Callback<ListView<Person>, ListCell<Person>> cellFactory = TextFieldListCell.forListView(converter);
        persons.setCellFactory(cellFactory);

        return persons;
    }

    public ListView<String> getBreakfastListView() {
        ListView<String> breakfasts = new ListView<>();
        breakfasts.setPrefSize(200, 120);
        breakfasts.setEditable(true);
        breakfasts.getItems().addAll("Apple", "Banana", "Donut", "Hash Brown");

        Callback<ListView<String>, ListCell<String>> cellFactory = TextFieldListCell.forListView();
        breakfasts.setCellFactory(cellFactory);

        return breakfasts;
    }
}
