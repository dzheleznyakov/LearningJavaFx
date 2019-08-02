package zh.learn.javafx.ch12control.choicebox;

import javafx.application.Application;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;

public class ChoiceBoxOnDomainObjectsTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label personLbl = new Label("Select a Person:");
        ChoiceBox<Person> persons = new ChoiceBox<>();

        persons.setConverter(new PersonStringConverter());

        persons.getItems().addAll(
                new Person("John", "Jacobs", null),
                new Person("Donna", "Duncan", null),
                new Person("Layne", "Estes", null),
                new Person("Mason", "Boyd", null)
        );

        persons.getSelectionModel().selectFirst();

        Label selectionMsgLbl = new Label("Your Selection:");
        Label selectedValueLbl = new Label("None");

        selectedValueLbl.textProperty().bind(persons.valueProperty().asString());

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0, personLbl, persons);
        root.addRow(1, selectionMsgLbl, selectedValueLbl);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ChoiceBox Controls on Domain Objects");
    }
}
