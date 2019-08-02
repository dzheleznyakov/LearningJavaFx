package zh.learn.javafx.ch13tableview;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;

import java.util.Arrays;

public class TableViewAddDeleteRows extends Application {
    private final TextField fNameField = new TextField();
    private final TextField lNameField = new TextField();
    private final DatePicker dobField = new DatePicker();

    TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableViewSelectionModel<Person> tsm = table.getSelectionModel();
        tsm.setSelectionMode(SelectionMode.MULTIPLE);

        table.getColumns().addAll(PersonTableUtil.getIdColumn(),
                PersonTableUtil.getFirstNameColumn(),
                PersonTableUtil.getLastNameColumn(),
                PersonTableUtil.getBirthDateColumn());

        GridPane newDataPane = getNewPersonDataPane();

        Button restoreBtn = new Button("Restore Rows");
        restoreBtn.setOnAction(e -> restoreRows());

        Button deleteBtn = new Button("Delete Selected Rows");
        deleteBtn.setOnAction(e -> deleteSelectedRows());

        VBox root = new VBox(newDataPane, new HBox(restoreBtn, deleteBtn), table);
        root.setSpacing(5);
        Aux.style(root);

        Aux.showStage(stage, root, "Adding/Deleting Rows in a TableViews");
    }

    private GridPane getNewPersonDataPane() {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(5);
        pane.addRow(0, new Label("First Name:"), fNameField);
        pane.addRow(1, new Label("Last Name:"), lNameField);
        pane.addRow(2, new Label("Birth Date:"), dobField);

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> addPerson());

        pane.add(addBtn, 2, 0);

        return pane;
    }

    private void deleteSelectedRows() {
        TableViewSelectionModel<Person> tsm = table.getSelectionModel();
        if (tsm.isEmpty()) {
            System.out.println("Please select a row to delete");
            return;
        }

        ObservableList<Integer> list = tsm.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);

        Arrays.sort(selectedIndices);

        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            tsm.clearSelection(selectedIndices[i]);
            table.getItems().remove(selectedIndices[i].intValue());
        }
    }

    private void restoreRows() {
        table.getItems().clear();
        table.getItems().addAll(PersonTableUtil.getPersonList());
    }

    public Person getPerson() {
        return new Person(fNameField.getText(), lNameField.getText(), dobField.getValue());
    }

    private void addPerson() {
        Person p = getPerson();
        table.getItems().add(p);
        clearFields();
    }

    private void clearFields() {
        fNameField.setText(null);
        fNameField.setText(null);
        dobField.setValue(null);
    }
}
