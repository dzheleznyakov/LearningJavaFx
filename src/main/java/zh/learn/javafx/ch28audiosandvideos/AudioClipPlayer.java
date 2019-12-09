package zh.learn.javafx.ch28audiosandvideos;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.net.URL;

public class AudioClipPlayer extends Application {
    private AudioClip audioClip;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        URL mediaUrl = this.getClass()
                           .getClassLoader()
                           .getResource("media/chimes.wav");

        audioClip = new AudioClip(mediaUrl.toExternalForm());
    }

    @Override
    public void start(Stage stage) {
        Button playBtn = new Button("Play");
        Button stopBtn = new Button("Stop");

        playBtn.setOnAction(e -> audioClip.play());
        stopBtn.setOnAction(e -> audioClip.stop());

        HBox root = new HBox(5, playBtn, stopBtn);
        root.setStyle("-fx-padding: 10;");
        Aux.showStage(stage, root, "Playing Short Audio Clips");
    }
}
