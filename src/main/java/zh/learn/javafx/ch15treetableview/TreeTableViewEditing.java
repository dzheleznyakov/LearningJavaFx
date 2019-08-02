package zh.learn.javafx.ch15treetableview;

import javafx.application.Application;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;
import zh.learn.javafx.ch12control.pickers.LocalDateStringConverter;

import java.time.LocalDate;

public class TreeTableViewEditing extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage stage) {
        TreeItem<Person> rootNode = TreeTableUtil.getModel();
        rootNode.setExpanded(true);

        TreeTableView<Person> treeTable = new TreeTableView<>(rootNode);
        treeTable.setPrefWidth(400);

        treeTable.setPrefWidth(400);
        treeTable.setEditable(true);

        TreeTableColumn<Person, String> fNameCol = TreeTableUtil.getFirstNameColumn();
        fNameCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());

        TreeTableColumn<Person, String> lNameCol = TreeTableUtil.getLastNameColumn();
        lNameCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());

        TreeTableColumn<Person, LocalDate> birthDateCol = TreeTableUtil.getBirthDateColumn();
        LocalDateStringConverter converter = new LocalDateStringConverter();
        birthDateCol.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter));

        treeTable.getColumns().addAll(fNameCol, lNameCol, birthDateCol);

        HBox root = new HBox(treeTable);
        Aux.style(root);

        Aux.showStage(stage, root, "Editing Data in a TreeTableView");
    }
}
