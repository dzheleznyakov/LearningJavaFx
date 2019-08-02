package zh.learn.javafx.ch06nodes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NodeSizes extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button btn = new Button("Hello JavaFX!");

        HBox root = new HBox();
        root.getChildren().addAll(btn);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sizes of a Node");
        stage.show();

        System.out.println("Before changing button properties:");
        printSizes(btn);

        btn.setWrapText(true);
        btn.setPrefWidth(80);
        stage.sizeToScene();

        System.out.println("\nAfter changing button properties:");
        printSizes(btn);
    }

    private void printSizes(Button btn) {
        System.out.println("btn.getContentBias() = " + btn.getContentBias());
        System.out.println("btn.getPrefWidth() = " + btn.getPrefWidth());
        System.out.println("btn.getPrefHeight() = " + btn.getPrefHeight());
        System.out.println("btn.getMinWidth() = " + btn.getMinWidth());
        System.out.println("btn.getMinHeight() = " + btn.getMinHeight());
        System.out.println("btn.getMaxWidth() = " + btn.getMaxWidth());
        System.out.println("btn.getMaxHeight() = " + btn.getMaxHeight());

        double prefWidth = btn.prefWidth(-1);
        System.out.println("btn.prefWidth(-1) = " + prefWidth + ", btn.prefHeight(prefWidth) = " + btn.prefHeight(prefWidth));

        double minWidth = btn.minWidth(-1);
        System.out.println("btn.minWidth(-1) = " + minWidth + ", btn.minHeight(minWidth) = " + btn.minHeight(minWidth));

        double maxWidth = btn.maxWidth(-1);
        System.out.println("btn.maxWidth(-1) = " + maxWidth + ", btn.maxHeight(maxWidth) = " + btn.maxHeight(maxWidth));

        System.out.println("btn.getWidth() = " + btn.getWidth());
        System.out.println("btn.getHeight() = " + btn.getHeight());
    }
}
