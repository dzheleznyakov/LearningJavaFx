package zh.learn.javafx.ch05scenes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunLaterApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init(): " + Thread.currentThread().getName());

        Runnable task = () -> System.out.println("Running the task on the " + Thread.currentThread().getName());
        Platform.runLater(task);
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new Group(), 400, 100));
        stage.setTitle("Using Platform.runLater() Method");
        stage.show();
    }
}
