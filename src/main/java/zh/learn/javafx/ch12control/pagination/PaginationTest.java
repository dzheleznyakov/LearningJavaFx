package zh.learn.javafx.ch12control.pagination;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class PaginationTest extends Application {
    private static final int PAGE_COUNT = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pagination pagination = new Pagination(PAGE_COUNT);

        pagination.setPageFactory(this::getPage);

        VBox root = new VBox(pagination);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Pagination Controls");
    }

    public Label getPage(int pageIndex) {
        Label content = null;

        if (pageIndex >= 0 && pageIndex < PAGE_COUNT) {
            content = new Label("Content for page " + (pageIndex + 1));
        }
        return content;
    }
}
