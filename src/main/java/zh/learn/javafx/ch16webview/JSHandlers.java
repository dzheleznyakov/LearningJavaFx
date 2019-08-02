package zh.learn.javafx.ch16webview;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.PromptData;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import zh.learn.javafx.Aux;

public class JSHandlers {
    public static void alertHandler(WebEvent<String> e) {
        Stage stage = new Stage();
        stage.setTitle("Alert");

        Label msg = new Label(e.getData());
        Button okBtn = new Button("OK");
        okBtn.setOnAction(e2 -> stage.close());

        VBox root = new VBox(20, msg, okBtn);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static String promptHandler(PromptData pData) {
        Stage stage = new Stage();
        stage.setTitle("Prompt");

        Label msgLbl = new Label(pData.getMessage());
        TextField dataFld = new TextField();
        dataFld.setText(pData.getDefaultValue());
        Button okBtn = new Button("OK");
        okBtn.setOnAction(e -> stage.close());

        VBox root = new VBox(20, msgLbl, dataFld, okBtn);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        return dataFld.getText();
    }

    public static WebEngine popupHandler(PopupFeatures pFeatures) {
        Stage stage = new Stage();
        stage.setTitle("Popup");

        WebView popupView = new WebView();
        VBox root = new VBox(popupView);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        return popupView.getEngine();
    }

    public static Boolean confirmHandler(String msg) {
        Stage stage = new Stage();
        stage.setTitle("Confirm");

        Label msgLbl = new Label(msg);
        Button okBtn = new Button("OK");
        okBtn.setOnAction(e -> {
            okBtn.getProperties().put("userPressed", true);
            stage.close();
        });

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(e -> stage.close());

        HBox buttons = new HBox(20, okBtn, cancelBtn);
        buttons.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, msgLbl, buttons);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        Boolean userSelection = (Boolean) okBtn.getProperties()
                .get("userPressed");
        return userSelection != null;
    }
}
