package zh.learn.javafx.ch13tableview;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class TableViewDataTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage stage) {
        TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());

        TableColumn<Person, String> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(cellData -> {
            Person p = cellData.getValue();
            LocalDate dob = p.getBirthDate();
            String ageInYear = "Unknown";

            if (dob != null) {
                long years = YEARS.between(dob, LocalDate.now());
                if (years == 0) {
                    ageInYear = "< 1 year";
                } else if (years == 1) {
                    ageInYear = years + " year";
                } else {
                    ageInYear = years + " years";
                }
            }
            return new ReadOnlyStringWrapper(ageInYear);
        });

        TableColumn<Person, Person.AgeCategory> ageCategoryCol = new TableColumn<>("Age Category");
        ageCategoryCol.setCellValueFactory(new PropertyValueFactory<>("ageCategory"));

        table.getColumns().addAll(PersonTableUtil.getIdColumn(),
                PersonTableUtil.getFirstNameColumn(),
                PersonTableUtil.getLastNameColumn(),
                PersonTableUtil.getBirthDateColumn(),
                ageCol,
                ageCategoryCol);

        HBox root = new HBox(table);
        Aux.style(root);

        Aux.showStage(stage, root, "Populating TableViews");
    }
}
