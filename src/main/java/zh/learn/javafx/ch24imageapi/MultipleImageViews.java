package zh.learn.javafx.ch24imageapi;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class MultipleImageViews extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/school_bus.jpg";
        Image image = new Image(imagePath);

        ImageView view1 = getImageView(image, 100.0, 50.0, false);
        ImageView view2 = getImageView(image, 100.0, 50.0, true);
        ImageView view3 = getImageView(image, 100.0, 100.0, true);

        HBox root = new HBox(10, view1, view2, view3);
        Aux.showStage(stage, root, "Multiple Views of an Image");
    }

    private ImageView getImageView(Image image, double fitWidth, double fitHeight, boolean preserveRatio) {
        ImageView view = new ImageView(image);
        view.setFitWidth(fitWidth);
        view.setFitHeight(fitHeight);
        view.setPreserveRatio(preserveRatio);
        view.setSmooth(true);
        return view;
    }
}
