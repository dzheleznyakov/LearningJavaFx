package zh.learn.javafx.ch10container;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BorderImageTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String imagePath = "picture/border_with_triangles.jpg";
        URL imageUrl = getClass().getClassLoader().getResource(imagePath);
        String imageUrlSting = imageUrl.toExternalForm();

        Pane p1 = this.getCSSStyledPane(imageUrlSting);
        Pane p2 = this.getObjectStyledPane(imageUrlSting);

        p1.setLayoutX(20);
        p1.setLayoutY(20);
        p2.layoutYProperty().bind(p1.layoutYProperty());
        p2.layoutXProperty().bind(p1.layoutXProperty().add(p1.widthProperty()).add(20));

        Pane root = new Pane(p1, p2);
        root.setPrefSize(260, 100);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Strokes and Images as a Border");
        stage.show();
    }

    private Pane getCSSStyledPane(String imageUrl) {
        Pane pane = new Pane();
        pane.setPrefSize(100, 70);
        pane.setStyle("-fx-border-image-source: url('" + imageUrl + "');" +
                "-fx-border-image-repeat: no-repeat;" +
                "-fx-border-image-slice: 9;" +
                "-fx-border-image-width: 9;" +
                "-fx-border-image-insets: 10;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 1;" +
                "-fx-border-style: dashed inside;");
        return pane;
    }

    private Pane getObjectStyledPane(String imageUrl) {
        Pane pane = new Pane();
        pane.setPrefSize(100, 70);
        pane.setBackground(Background.EMPTY);

        BorderWidths regionWidth = new BorderWidths(9);
        BorderWidths sliceWidth = new BorderWidths(9);
        boolean filled = false;
        BorderRepeat repeatX = BorderRepeat.STRETCH;
        BorderRepeat repeatY = BorderRepeat.STRETCH;
        BorderImage borderImage = new BorderImage(new Image(imageUrl),
                regionWidth,
                new Insets(10),
                sliceWidth,
                filled,
                repeatX,
                repeatY);

        List<Double> dashArray = new ArrayList<>();
        dashArray.add(2.0);
        dashArray.add(1.4);
        BorderStrokeStyle blackStrokeStyle = new BorderStrokeStyle(StrokeType.INSIDE,
                StrokeLineJoin.MITER,
                StrokeLineCap.BUTT,
                10,
                0,
                dashArray);
        BorderStroke borderStroke = new BorderStroke(Color.BLACK,
                blackStrokeStyle,
                CornerRadii.EMPTY,
                new BorderWidths(1),
                new Insets(0));

        BorderStroke[] strokes = {borderStroke};
        BorderImage[] images = {borderImage};
        Border border = new Border(strokes, images);

        pane.setBorder(border);

        return pane;
    }
}
