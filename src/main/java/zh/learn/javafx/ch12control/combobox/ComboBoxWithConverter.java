package zh.learn.javafx.ch12control.combobox;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;
import zh.learn.javafx.ch12control.choicebox.PersonStringConverter;

public class ComboBoxWithConverter extends Application {
    Label userSelectionMsgLbl = new Label("Your selection");
    Label userSelectionDataLbl = new Label("");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label personLbl = new Label("Select/Enter Person:");
        ComboBox<Person> persons = new ComboBox<>();
        persons.setEditable(true);
        persons.setConverter(new PersonStringConverter());
        persons.getItems().addAll(
                new Person("John", "Jacobs", null),
                new Person("Donna", "Duncan", null),
                new Person("Layne", "Estes", null),
                new Person("Mason", "Boyd", null)
        );

        persons.getSelectionModel().selectedItemProperty()
                .addListener(this::personChanged);
        persons.getSelectionModel().selectedIndexProperty()
                .addListener(this::indexChanged);


        persons.setOnAction(e -> valueChanged(persons));

        GridPane root = new GridPane();
        root.addRow(0, personLbl, persons);
        root.addRow(1, userSelectionMsgLbl, userSelectionDataLbl);
        Aux.style(root);

        Aux.showStage(stage, root, "Using StringConverter in ComboBox");
    }

    public void valueChanged(ComboBox<Person> list) {
        Person p = list.getValue();
        String name = p.getLastName() + ", " + p.getFirstName();
        userSelectionDataLbl.setText(name);
    }

    public void personChanged(ObservableValue<? extends Person> observable,
                              Person oldValue,
                              Person newValue) {
        System.out.println("Item changed: old = " + oldValue + ", new = " + newValue);
    }

    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue) {
        System.out.println("Index changed: old = " + oldValue + ", " + newValue);
    }
}
