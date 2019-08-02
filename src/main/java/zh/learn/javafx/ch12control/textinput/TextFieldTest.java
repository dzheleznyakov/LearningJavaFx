package zh.learn.javafx.ch12control.textinput;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TextFieldTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();

        firstNameFld.setPrefColumnCount(15);
        lastNameFld.setPrefColumnCount(15);

        firstNameFld.textProperty().addListener(this::changed);
        lastNameFld.textProperty().addListener(this::changed);

        ContextMenu cm = new ContextMenu();
        MenuItem dummyItem = new MenuItem("Context menu is disabled");
        cm.getItems().add(dummyItem);
        firstNameFld.setContextMenu(cm);

        firstNameFld.setOnAction(e -> nameChanged("First Name"));
        lastNameFld.setOnAction(e -> nameChanged("Last Name"));

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.addRow(0, new Label("First Name:"), firstNameFld);
        root.addRow(1, new Label("Last Name:"), lastNameFld);
        Aux.style(root);

        Aux.showStage(stage, root, "Using TextField Controls");
    }

    public void nameChanged(String fieldName) {
        System.out.println("Action event fired on " + fieldName);
    }

    public void changed(ObservableValue<? extends String> prop,
                        String oldValue,
                        String newValue) {
        System.out.println("Old = " + oldValue + ", new = " + newValue);
    }
}
