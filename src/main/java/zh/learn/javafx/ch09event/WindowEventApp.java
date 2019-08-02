package zh.learn.javafx.ch09event;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class WindowEventApp extends Application {
    private CheckBox canCloseCbx = new CheckBox("Can Close Window");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> stage.close());

        Button hideBtn = new Button("Hide");
        hideBtn.setOnAction(e -> {
            showDialog(stage);
            stage.hide();
        });

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(canCloseCbx, closeBtn, hideBtn);

        stage.setOnShowing(this::handle);
        stage.setOnShown(this::handle);
        stage.setOnHiding(this::handle);
        stage.setOnHidden(this::handle);
        stage.setOnCloseRequest(this::handle);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Window Events");
        stage.show();
    }

    private void handle(WindowEvent e) {
        EventType<WindowEvent> type = e.getEventType();
        if (type == WINDOW_CLOSE_REQUEST && !canCloseCbx.isSelected()) {
            e.consume();
        }
        System.out.println(type + ": Consumed=" + e.isConsumed());
    }

    private void showDialog(Stage mainWindow) {
        Stage popup = new Stage();

        Button closeBtn = new Button("Click to Show Main Window");
        closeBtn.setOnAction(e -> {
            popup.close();
            mainWindow.show();
        });

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(closeBtn);

        Scene scene = new Scene(root);
        popup.setScene(scene);
        popup.setTitle("Popup");
        popup.show();
    }
}
