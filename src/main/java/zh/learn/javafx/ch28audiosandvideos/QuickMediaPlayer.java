package zh.learn.javafx.ch28audiosandvideos;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import zh.learn.javafx.Aux;

import java.net.URL;

import static javafx.scene.media.MediaPlayer.Status.PLAYING;

public class QuickMediaPlayer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        String mediaPath = "media/gopro.mp4";
        URL mediaUrl = this.getClass()
                           .getClassLoader()
                           .getResource(mediaPath);
        String mediaStringUrl = mediaUrl.toExternalForm();

        Media media = new Media(mediaStringUrl);
        MediaPlayer player = new MediaPlayer(media);

        player.setAutoPlay(true);

        MediaView mediaView = new MediaView(player);
        mediaView.setFitWidth(800);
        mediaView.setFitHeight(600);

        Button playBtn = new Button("Play");
        playBtn.setOnAction(e -> {
            if (player.getStatus() == PLAYING) {
                player.stop();
                player.play();
            } else {
                player.play();
            }
        });

        Button stopBtn = new Button("Stop");
        stopBtn.setOnAction(e -> player.stop());

        Label status = new Label("");
        status.textProperty().bind(player.statusProperty().asString());

        player.setOnError(() -> System.out.println(player.getError().getMessage()));

        HBox controlBox = new HBox(5, playBtn, stopBtn);

        VBox interactionBox = new VBox(5, controlBox);

        player.setOnReady(() -> {
            Slider duration = getDurationSlider(player, media);
            interactionBox.getChildren().add(duration);
        });

        BorderPane root = new BorderPane();

        root.setTop(status);
        root.setCenter(mediaView);
        root.setBottom(interactionBox);

        Aux.style(root);
        Aux.showStage(stage, root, "Playing Media");
    }

    private Slider getDurationSlider(MediaPlayer player, Media media) {
        Slider slider = new Slider(0.0, media.getDuration().toSeconds(), 0.0);
        slider.setMajorTickUnit(60.0);
        slider.setShowTickLabels(true);

        DoubleProperty durationProperty = slider.valueProperty();
        player.currentTimeProperty().addListener((prop, oldValue, newValue) -> {
            if (newValue == null || Duration.UNKNOWN.equals(newValue))
                durationProperty.set(0.0);
            else
                durationProperty.set(newValue.toSeconds());
        });
        slider.setLabelFormatter(new TimeLabelFormatter());
        return slider;
    }

    private static class TimeLabelFormatter extends StringConverter<Double> {
        @Override
        public String toString(Double durationInSecs) {
            int duration = durationInSecs.intValue();
            int minutes = duration / 60;
            int seconds = duration % 60;
            if (seconds == 0)
                return minutes + " min";
            return minutes + " min " + seconds + " sec";
        }

        @Override
        public Double fromString(String string) {
            return null;
        }
    }
}
