package zh.learn.javafx.ch13tableview;

import javafx.application.Application;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;
import zh.learn.javafx.ch12control.pickers.LocalDateStringConverter;

import java.time.LocalDate;

public class CustomTableCellTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());

        table.setEditable(true);

        TableColumn<Person, LocalDate> birthDateCol = PersonTableUtil.getBirthDateColumn();
        StringConverter<LocalDate> converter = new LocalDateStringConverter("MMMM dd, yyyy");
        birthDateCol.setCellFactory(DatePickerTableCell.forTableColumn(converter, false));

        table.getColumns().addAll(PersonTableUtil.getIdColumn(),
                PersonTableUtil.getFirstNameColumn(),
                PersonTableUtil.getLastNameColumn(),
                birthDateCol);

        HBox root = new HBox(table);
        Aux.style(root);

        Aux.showStage(stage, root, "Using a Custom TableCell");
    }
}
