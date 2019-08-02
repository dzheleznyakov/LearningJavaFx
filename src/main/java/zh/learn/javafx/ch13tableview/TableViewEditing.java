package zh.learn.javafx.ch13tableview;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;
import zh.learn.javafx.ch12control.pickers.LocalDateStringConverter;

import java.time.LocalDate;

public class TableViewEditing extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());
        table.setEditable(true);

        addIdColumn(table);
        addFirstNameColumn(table);
        addLastNameColumn(table);
        addBirthDateColumn(table);
        addBabyColumn(table);
        addGenderColumn(table);

        HBox root = new HBox(table);
        Aux.style(root);

        Aux.showStage(stage, root, "Editing Data in a TableView");
    }

    private void addIdColumn(TableView<Person> table) {
        table.getColumns().add(PersonTableUtil.getIdColumn());
    }

    private void addFirstNameColumn(TableView<Person> table) {
        TableColumn<Person, String> fNameCol = PersonTableUtil.getFirstNameColumn();
        fNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        table.getColumns().add(fNameCol);
    }

    private void addLastNameColumn(TableView<Person> table) {
        TableColumn<Person, String> lNameCol = PersonTableUtil.getLastNameColumn();
        lNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        table.getColumns().add(lNameCol);
    }

    private void addBirthDateColumn(TableView<Person> table) {
        TableColumn<Person, LocalDate> birthDateCol = PersonTableUtil.getBirthDateColumn();
        LocalDateStringConverter converter = new LocalDateStringConverter();
        birthDateCol.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        table.getColumns().add(birthDateCol);
    }

    private void addBabyColumn(TableView<Person> table) {
        TableColumn<Person, Boolean> babyCol = new TableColumn<>("Baby?");
        babyCol.setEditable(false);
        babyCol.setCellValueFactory(cellData -> {
            Person p = cellData.getValue();
            boolean v = (p.getAgeCategory() == Person.AgeCategory.BABY);
            return new ReadOnlyBooleanWrapper(v);
        });
        babyCol.setCellFactory(CheckBoxTableCell.forTableColumn(babyCol));
        table.getColumns().add(babyCol);
    }

    private void addGenderColumn(TableView<Person> table) {
        TableColumn<Person, String> genderCol = new TableColumn<>("Gender");
        genderCol.setMinWidth(80);

        genderCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(null));
        genderCol.setCellFactory(ComboBoxTableCell.forTableColumn("Male", "Female"));

        genderCol.setOnEditCommit(e -> {
            int row = e.getTablePosition().getRow();
            Person person = e.getRowValue();
            System.out.println("Gender changed for " +
                    person.getFirstName() + " " + person.getLastName() +
                    " at row " + (row + 1) + " to " + e.getNewValue());
        });

        table.getColumns().add(genderCol);
    }
}
