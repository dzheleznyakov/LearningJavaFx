package zh.learn.javafx.ch12control;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class LabelTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField fNameFld = new TextField();
        Label fNameLbl = new Label("_First Name:");
        fNameLbl.setLabelFor(fNameFld);
        fNameLbl.setMnemonicParsing(true);

        TextField lNameFld = new TextField();
        Label lNameLbl = new Label("_Last Name:");
        lNameLbl.setLabelFor(lNameFld);
        lNameLbl.setMnemonicParsing(true);

        GridPane root = new GridPane();
        root.addRow(0, fNameLbl, fNameFld);
        root.addRow(1, lNameLbl, lNameFld);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Labels");
    }
}
