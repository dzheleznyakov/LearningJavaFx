package zh.learn.javafx.ch13tableview;

import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;

public class SimplestTableView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());

        table.getColumns().addAll(PersonTableUtil.getIdColumn(),
                PersonTableUtil.getFirstNameColumn(),
                PersonTableUtil.getLastNameColumn(),
                PersonTableUtil.getBirthDateColumn());

        VBox root = new VBox(table);
        Aux.style(root);

        Aux.showStage(stage, root, "Simplest TableView");
    }
}
