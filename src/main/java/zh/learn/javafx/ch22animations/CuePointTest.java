package zh.learn.javafx.ch22animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import zh.learn.javafx.Aux;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CuePointTest extends Application {
    Text msg = new Text("JavaFX animation is cool!");
    Pane pane;
    ListView<String> cuePointsListView;
    Timeline timeline;
    Label info;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        msg.setTextOrigin(VPos.TOP);
        msg.setFont(Font.font(24));

        BorderPane root = new BorderPane();
        root.setPrefSize(600, 150);

        cuePointsListView = new ListView<>();
        cuePointsListView.setPrefSize(100, 150);
        pane = new Pane(msg);
        info = new Label();

        root.setCenter(pane);
        root.setLeft(cuePointsListView);
        root.setBottom(info);

        Aux.showStage(stage, root, "Cue Points");

        setupAnimation();
        addCuePoints();
    }

    private void setupAnimation() {
        double paneWidth = pane.getWidth();
        double msgWidth = msg.getLayoutBounds().getWidth();

        KeyValue initKeyValue = new KeyValue(msg.translateXProperty(), paneWidth);
        KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

        KeyValue midKeyValue = new KeyValue(msg.translateXProperty(), paneWidth / 2);
        KeyFrame midFrame = new KeyFrame(Duration.seconds(5), "midway", midKeyValue);

        KeyValue endKeyValue = new KeyValue(msg.translateXProperty(), -1.0 * msgWidth);
        KeyFrame endFrame = new KeyFrame(Duration.seconds(10), endKeyValue);

        timeline = new Timeline(initFrame, midFrame, endFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void addCuePoints() {
        timeline.getCuePoints().put("3 seconds", Duration.seconds(3));
        timeline.getCuePoints().put("7 seconds", Duration.seconds(7));

        SortedMap<String, Duration> smap = getSortedCuePoints(timeline.getCuePoints());
        cuePointsListView.getItems().addAll(smap.keySet());

        cuePointsListView.getItems().add(0, "Start");
        cuePointsListView.getItems().addAll("End");

        cuePointsListView.getSelectionModel().selectedItemProperty().addListener((prop, oldValue, newValue) -> {
            timeline.jumpTo(newValue);
        });
    }

    private SortedMap<String, Duration> getSortedCuePoints(Map<String, Duration> map) {
        Comparator<String> comparator = Comparator.comparing(map::get);
        SortedMap<String, Duration> smap = new TreeMap<>(comparator);
        smap.putAll(map);
        return smap;
    }
}
