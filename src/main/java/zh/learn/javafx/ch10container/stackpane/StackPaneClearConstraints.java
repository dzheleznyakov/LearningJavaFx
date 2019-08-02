package zh.learn.javafx.ch10container.stackpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class StackPaneClearConstraints extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane center = StackPaneAlignmentConstraint.getStackPane();

        Button btnClear = new Button("Clear Constraints");
        btnClear.setOnAction(e -> center.getChildren().forEach(StackPane::clearConstraints));

        BorderPane root = new BorderPane();

        root.setCenter(center);
        root.setBottom(btnClear);

        Insets margin = new Insets(5);
        root.getChildren().forEach(child -> BorderPane.setMargin(child, margin));

        Aux.showStage(stage, root, "StackPane: Clear Constraints");
    }
}
