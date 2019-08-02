package zh.learn.javafx.ch14treeview;

import javafx.application.Application;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TreeViewEditingData extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TreeView<String> treeView = TreeViewUtil.getTreeView();

        treeView.setEditable(true);

        treeView.setCellFactory(TextFieldTreeCell.forTreeView());

        treeView.setOnEditStart(this::editStart);
        treeView.setOnEditCommit(this::editCommit);
        treeView.setOnEditCancel(this::editCancel);

        HBox root = new HBox(treeView);
        Aux.style(root);

        Aux.showStage(stage, root, "A Editing Cells in a TreeView");
    }

    private void editStart(TreeView.EditEvent<String> e) {
        System.out.println("Started editing: " + e.getTreeItem());
    }

    private void editCommit(TreeView.EditEvent<String> e) {
        System.out.println(e.getTreeItem() + " changed." +
                " old = " + e.getOldValue() +
                ", new = " + e.getNewValue());
    }

    private void editCancel(TreeView.EditEvent<String> e) {
        System.out.println("Cancelled editing: " + e.getTreeItem());
    }
}
