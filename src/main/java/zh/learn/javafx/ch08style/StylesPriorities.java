package zh.learn.javafx.ch08style;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StylesPriorities extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");

        yesBtn.setStyle("-fx-font-size: 16px");
        yesBtn.setFont(new Font(10));

        noBtn.setFont(new Font(8));

        HBox root = new HBox();
        root.setSpacing(10);
        root.getChildren().addAll(yesBtn, noBtn, cancelBtn);

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll("css/stylespriorities.css");

        stage.setScene(scene);
        stage.setTitle("Styles Priorities");
        stage.show();
    }
}
