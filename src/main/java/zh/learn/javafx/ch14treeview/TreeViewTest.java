package zh.learn.javafx.ch14treeview;

import javafx.application.Application;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TreeViewTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TreeView<String> treeView = TreeViewUtil.getTreeView();
        HBox root = new HBox(treeView);

        Aux.style(root);

        Aux.showStage(stage, root, "Creating a TreeView");
    }
}
