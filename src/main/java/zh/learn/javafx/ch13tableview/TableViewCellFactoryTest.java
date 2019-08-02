package zh.learn.javafx.ch13tableview;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TableViewCellFactoryTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage stage) {
        TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());

        TableColumn<Person, LocalDate> birthDateCol = PersonTableUtil.getBirthDateColumn();

        birthDateCol.setCellFactory(col -> new TableCell<Person, LocalDate>() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                this.setText(null);
                this.setGraphic(null);

                if (!empty) {
                    String formattedDob = DateTimeFormatter.ofPattern("MM/dd/yyyy")
                            .format(item);
                    this.setText(formattedDob);
                }
            }
        });

        TableColumn<Person, Boolean> babyCol = new TableColumn<>("Baby?");
        babyCol.setCellValueFactory(cellData -> {
            Person p = cellData.getValue();
            boolean v = (p.getAgeCategory() == Person.AgeCategory.BABY);
            return new ReadOnlyBooleanWrapper(v);
        });
        babyCol.setCellFactory(CheckBoxTableCell.forTableColumn(babyCol));

        table.getColumns().addAll(PersonTableUtil.getIdColumn(),
                PersonTableUtil.getFirstNameColumn(),
                PersonTableUtil.getLastNameColumn(),
                birthDateCol,
                babyCol);

        HBox root = new HBox(table);
        Aux.style(root);

        Aux.showStage(stage, root, "Using a Custom Cell Factory for a TableColumn");
    }
}
