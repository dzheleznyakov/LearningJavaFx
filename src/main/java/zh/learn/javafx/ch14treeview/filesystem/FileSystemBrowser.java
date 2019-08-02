package zh.learn.javafx.ch14treeview.filesystem;

import javafx.application.Application;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemBrowser extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PathTreeItem rootNode = new PathTreeItem(Paths.get("."));
        TreeView<Path> treeView = new TreeView<>(rootNode);
        treeView.setShowRoot(false);

        treeView.setCellFactory(tv -> new TreeCell<Path>() {
            @Override
            public void updateItem(Path item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !empty) {
                    Path fileName = item.getFileName();
                    setText(fileName == null ? item.toString() : fileName.toString());
                    setGraphic(getTreeItem().getGraphic());
                } else {
                    setText(null);
                    setGraphic(null);
                }
            }
        });

        HBox root = new HBox(treeView);
        Aux.style(root);

        Aux.showStage(stage, root, "File System Browser");
    }
}
