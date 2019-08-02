package zh.learn.javafx.ch12control.tabpane;

import javafx.application.Application;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TabTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ImageView privacyIcon = getImage("privacy_icon.png");
        GeneralTab generalTab = new GeneralTab("General", privacyIcon);

        ImageView addressIcon = getImage("address_icon.png");
        AddressTab addressTab = new AddressTab("Address", addressIcon);

        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(generalTab, addressTab);

        BorderPane root = new BorderPane();
        root.setCenter(tabPane);
        Aux.style(root);

        Aux.showStage(stage, root, "Using TabPane an Tab Controls");
    }

    private ImageView getImage(String fileName) {
        ImageView imgView = null;
        try {
            String imagePath = "picture/" + fileName;
            Image img = new Image(imagePath);
            imgView = new ImageView(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgView;
    }
}
