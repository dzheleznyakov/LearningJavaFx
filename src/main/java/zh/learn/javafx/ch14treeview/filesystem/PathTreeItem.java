package zh.learn.javafx.ch14treeview.filesystem;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathTreeItem extends TreeItem<Path> {
    private boolean childrenLoaded = false;
    private boolean leafPropertyComputed = false;
    private boolean leafNode = false;

    public PathTreeItem(Path path) {
        super(path);
        ImageView icon = Files.isDirectory(path)
                ? getFolderIcon("folder.jpg")
                : getFolderIcon("file.jpg");
        this.setGraphic(icon);
    }

    @Override
    public ObservableList<TreeItem<Path>> getChildren() {
        if (!childrenLoaded) {
            childrenLoaded = true;
            populateChildren(this);
        }
        return super.getChildren();
    }

    @Override
    public boolean isLeaf() {
        if (!leafPropertyComputed) {
            leafPropertyComputed = true;
            Path path = this.getValue();
            leafNode = !Files.isDirectory(path);
        }
        return leafNode;
    }

    private void populateChildren(TreeItem<Path> item) {
        item.getChildren().clear();
        if (item.getParent() == null) {
            for (Path path : FileSystems.getDefault().getRootDirectories()) {
                item.getChildren().add(new PathTreeItem(path));
            }
        } else {
            Path path = item.getValue();
            if (Files.isDirectory(path)) {
                try {
                    Files.list(path).forEach(p -> item.getChildren().add(new PathTreeItem(p)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ImageView getFolderIcon(String fileName) {
        ImageView imgView = null;
        try {
            String imagePath = "picture/" + fileName;
            Image img = new Image(imagePath);
            imgView = new ImageView(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgView;
    }
}
