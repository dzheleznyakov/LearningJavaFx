package zh.learn.javafx.ch12control.listview;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;

public class ListViewDomainObjects extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ListView<Person> persons = new ListView<>();
        persons.setPrefSize(150, 120);

        persons.getItems().addAll(
                new Person("John", "Jacobs", null),
                new Person("Donna", "Duncan", null),
                new Person("Layne", "Estes", null),
                new Person("Mason", "Boyd", null)
        );

        persons.setCellFactory(listView -> new ListCell<Person>() {
                    @Override
                    protected void updateItem(Person item, boolean empty) {
                        super.updateItem(item, empty);

                        int index = this.getIndex();
                        String name = null;

                        if (item != null && !empty) {
                            name = (index + 1) + ". " +
                                    item.getLastName() +
                                    item.getFirstName();
                        }
                        setText(name);
                        setGraphic(null);
                    }
                }
        );

        HBox root = new HBox(new Label("Persons:"), persons);
        root.setSpacing(20);
        Aux.style(root);

        Aux.showStage(stage, root, "Using ListView Cell Factory");
    }
}
