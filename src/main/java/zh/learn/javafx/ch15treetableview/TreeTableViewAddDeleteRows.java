package zh.learn.javafx.ch15treetableview;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableView.TreeTableViewSelectionModel;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;
import zh.learn.javafx.ch12control.pickers.LocalDateStringConverter;

import java.time.LocalDate;

public class TreeTableViewAddDeleteRows extends Application {
    private final TreeTableView<Person> treeTable = new TreeTableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage stage) {
        TreeItem<Person> rootNode = TreeTableUtil.getModel();
        rootNode.setExpanded(true);
        treeTable.setRoot(rootNode);
        treeTable.setPrefWidth(400);
        treeTable.setEditable(true);
        treeTable.getSelectionModel().selectFirst();

        TreeTableColumn<Person, String> fNameCol = TreeTableUtil.getFirstNameColumn();
        fNameCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());

        TreeTableColumn<Person, String> lNameCol = TreeTableUtil.getLastNameColumn();
        lNameCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());

        TreeTableColumn<Person, LocalDate> birthDateCol = TreeTableUtil.getBirthDateColumn();
        LocalDateStringConverter converter = new LocalDateStringConverter();
        birthDateCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter));

        treeTable.getColumns().addAll(fNameCol, lNameCol, birthDateCol);

        treeTable.setPlaceholder(new Label("Click the Add button to add a row."));

        Label msgLbl = new Label("Please select a row to add/delete");
        HBox buttons = getButtons();
        VBox root = new VBox(msgLbl, buttons, treeTable);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Adding/Deleting Rows in a TreeTableView");
    }

    private HBox getButtons() {
        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> addRow());

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> deleteRow());

        return new HBox(20, addBtn, deleteBtn);
    }

    private void addRow() {
        if (treeTable.getExpandedItemCount() == 0) {
            addNewRootItem();
        } else if (treeTable.getSelectionModel().isEmpty()) {
            System.out.println("Select a row to add.");
        } else {
            addNewChildItem();
        }
    }

    private void addNewRootItem() {
        TreeItem<Person> item = new TreeItem<>(new Person("New", "New", null));
        treeTable.setRoot(item);

        editItem(item);
    }

    private void addNewChildItem() {
        TreeItem<Person> item = new TreeItem<>(new Person("New", "New", null));

        TreeTableViewSelectionModel<Person> sm = treeTable.getSelectionModel();

        int rowIndex = sm.getSelectedIndex();
        TreeItem<Person> selectedItem = sm.getModelItem(rowIndex);
        selectedItem.getChildren().add(item);
        selectedItem.setExpanded(true);

        editItem(item);
    }

    private void editItem(TreeItem<Person> item) {
        int newRowIndex = treeTable.getRow(item);
        treeTable.scrollTo(newRowIndex);

        TreeTableColumn<Person, ?> firstCol = treeTable.getColumns().get(0);
        treeTable.getSelectionModel().select(item);
        treeTable.getFocusModel().focus(newRowIndex, firstCol);
        treeTable.edit(newRowIndex, firstCol);
    }

    private void deleteRow() {
        TreeTableViewSelectionModel<Person> sm = treeTable.getSelectionModel();
        if (sm.isEmpty()) {
            System.out.println("Select a row to delete");
            return;
        }

        int rowIndex = sm.getSelectedIndex();
        TreeItem<Person> selectedItem = sm.getModelItem(rowIndex);

        TreeItem<Person> parent = selectedItem.getParent();
        if (parent != null) {
            parent.getChildren().remove(selectedItem);
        } else {
            treeTable.setRoot(null);
        }
    }
}
