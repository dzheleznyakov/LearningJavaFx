package zh.learn.javafx.ch15treetableview;

import javafx.application.Application;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;

public class TreeTableViewTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TreeItem<Person> rootNode = TreeTableUtil.getModel();
        rootNode.setExpanded(true);

        TreeTableView<Person> treeTable = new TreeTableView<>(rootNode);
        treeTable.setPrefWidth(400);

        treeTable.getColumns().addAll(TreeTableUtil.getFirstNameColumn(),
                TreeTableUtil.getLastNameColumn(),
                TreeTableUtil.getBirthDateColumn(),
                TreeTableUtil.getAgeCategoryColumn());

        HBox root = new HBox(treeTable);
        Aux.style(root);

        Aux.showStage(stage, root, "Using a TreeTableView");
    }
}
