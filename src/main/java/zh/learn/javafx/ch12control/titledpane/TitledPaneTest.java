package zh.learn.javafx.ch12control.titledpane;

import javafx.application.Application;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.net.URL;

public class TitledPaneTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField firstNameFld = new TextField();
        firstNameFld.setPrefColumnCount(8);

        TextField lastNameFld = new TextField();
        lastNameFld.setPrefColumnCount(8);

        DatePicker dob = new DatePicker();
        dob.setPrefWidth(150);

        GridPane grid = new GridPane();
        grid.addRow(0, new Label("First Name:"), firstNameFld);
        grid.addRow(1, new Label("Last Name:"), lastNameFld);
        grid.addRow(2, new Label("DOB:"), dob);

        TitledPane infoPane = new TitledPane();
        infoPane.setText("Personal Info");
        infoPane.setContent(grid);

        String imageStr = "picture/privacy_icon.png";
        URL imageUrl = getClass().getClassLoader().getResource(imageStr);
        Image img = new Image(imageUrl.toExternalForm());
        ImageView imgView = new ImageView(img);
        infoPane.setGraphic(imgView);

        HBox root = new HBox(infoPane);
        root.setSpacing(10);
        Aux.style(root);

        Aux.showStage(stage, root, "Using TitledPane Controls");
    }
}
