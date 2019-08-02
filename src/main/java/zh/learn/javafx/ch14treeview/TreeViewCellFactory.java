package zh.learn.javafx.ch14treeview;

import javafx.application.Application;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TreeViewCellFactory extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TreeView<String> treeView = TreeViewUtil.getTreeView();

        treeView.setCellFactory( tv -> {
            TreeCell<String> cell = new TreeCell<String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        this.setText(null);
                        this.setGraphic(null);
                    } else {
                        String value = this.getTreeItem().getValue();
                        this.setText(this.getIndex() + ". " + value);
                    }
                }
            };
            return cell;
        });

        HBox root = new HBox(treeView);
        root.setSpacing(20);
        Aux.style(root);

        Aux.showStage(stage, root, "Using a Cell Factory in a TreeView");
    }
}
