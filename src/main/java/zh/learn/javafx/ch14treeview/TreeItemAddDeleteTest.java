package zh.learn.javafx.ch14treeview;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TreeItemAddDeleteTest extends Application {
    private final TreeView<String> treeView = new TreeView<>();
    private final TextArea msgLogFld = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        treeView.getSelectionModel().selectFirst();

        TreeItem<String> depts = new TreeItem<>("Departments");
        depts.addEventHandler(TreeItem.branchExpandedEvent(), this::branchExpanded);
        depts.addEventHandler(TreeItem.branchCollapsedEvent(), this::branchCollapsed);
        depts.addEventHandler(TreeItem.childrenModificationEvent(), this::childrenModification);

        treeView.setRoot(depts);

        VBox rightPane = getRightPane();

        HBox root = new HBox(treeView, rightPane);
        root.setSpacing(20);
        Aux.style(root);

        Aux.showStage(stage, root, "Creating a TreeView");
    }

    private VBox getRightPane() {
        TextField itemFld = new TextField();

        Button addItemBtn = new Button("Add");
        addItemBtn.setOnAction(e -> addItem(itemFld.getText()));

        Button removeItemBtn = new Button("Remove Selected Item");
        removeItemBtn.setOnAction(e -> removeItem());

        msgLogFld.setPrefRowCount(15);
        msgLogFld.setPrefColumnCount(25);
        VBox box = new VBox(new Label("Select an item to add to or remove."),
                new HBox(new Label("Item:"), itemFld, addItemBtn),
                removeItemBtn,
                new Label("Message Log:"),
                msgLogFld);
        box.setSpacing(10);
        return box;
    }

    private void addItem(String value) {
        if (value == null || value.trim().equals("")) {
            logMsg("Item cannot be empty.");
            return;
        }

        TreeItem<String> parent = treeView.getSelectionModel().getSelectedItem();
        if (parent == null) {
            logMsg("Select a node to add this item to.");
            return;
        }

        for (TreeItem<String> child : parent.getChildren()) {
            if (child.getValue().equals(value)) {
                logMsg(value + " already exists under " + parent.getValue());
                return;
            }
        }

        TreeItem<String> newItem = new TreeItem<>(value);
        parent.getChildren().add(newItem);
        if (!parent.isExpanded()) {
            parent.setExpanded(true);
        }
    }

    private void removeItem() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        if (item == null) {
            logMsg("Select a node to remove.");
            return;
        }

        TreeItem<String> parent = item.getParent();
        if (parent == null) {
            logMsg("Cannot remove the root node");
        } else {
            parent.getChildren().remove(item);
        }
    }

    private void branchExpanded(TreeItem.TreeModificationEvent<String> e) {
        String nodeValue = e.getSource().getValue();
        logMsg("Event: " + nodeValue + " expanded.");
    }

    private void branchCollapsed(TreeItem.TreeModificationEvent<String> e) {
        String nodeValue = e.getSource().getValue();
        logMsg("Event: " + nodeValue + " expanded.");
    }

    private void childrenModification(TreeItem.TreeModificationEvent<String> e) {
        if (e.wasAdded()) {
            for (TreeItem<String> item : e.getAddedChildren()) {
                logMsg("Event " + item.getValue() + " has been added.");
            }
        }

        if (e.wasRemoved()) {
            for (TreeItem<String> item : e.getRemovedChildren()) {
                logMsg("Event: " + item.getValue() + " has been removed.");
            }
        }
    }

    private void logMsg(String msg) {
        msgLogFld.appendText(msg + "\n");
    }
}
