package zh.learn.javafx.ch14treeview;

import javafx.application.Application;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TreeViewCheckBoxTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CheckBoxTreeItem<String> depts = new CheckBoxTreeItem<>("Departments");

        CheckBoxTreeItem<String> isDept = new CheckBoxTreeItem<>("IS");
        CheckBoxTreeItem<String> claimsDept = new CheckBoxTreeItem<>("Claims");
        CheckBoxTreeItem<String> underwritingDept = new CheckBoxTreeItem<>("Underwriting");
        depts.getChildren().addAll(isDept, claimsDept, underwritingDept);

        isDept.getChildren().addAll(new CheckBoxTreeItem<>("Doug Dyer"),
                new CheckBoxTreeItem<>("Jim Beeson"),
                new CheckBoxTreeItem<>("Simon Ng"));
        claimsDept.getChildren().addAll(new CheckBoxTreeItem<>("Lael Boyd"),
                new CheckBoxTreeItem<>("Janet Biddle"));

        underwritingDept.getChildren().addAll(new CheckBoxTreeItem<>("Ken McEwen"),
                new CheckBoxTreeItem<>("Ken Mann"),
                new CheckBoxTreeItem<>("Lola Ng"));

        claimsDept.setIndependent(true);

        TreeView<String> treeView = new TreeView<>(depts);
        treeView.setCellFactory(CheckBoxTreeCell.forTreeView());

        HBox root = new HBox(treeView);
        root.setSpacing(20);
        Aux.style(root);

        Aux.showStage(stage, root, "Using CheckBoxTreeItem");
    }
}
