package zh.learn.javafx.ch04stages;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenDetailsApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ObservableList<Screen> screenList = Screen.getScreens();
        System.out.println("Screens Count: " + screenList.size());

        for (Screen screen : screenList) {
            print(screen);
        }

        Platform.exit();
    }

    private void print(Screen s) {
        System.out.println("DPI: " + s.getDpi());

        System.out.println("Screen Bounds: ");
        Rectangle2D bounds = s.getBounds();
        print(bounds);

        System.out.println("Screen Visual Bounds: ");
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);
        System.out.println("-----------------");
    }

    private void print(Rectangle2D r) {
        System.out.printf("minX=%.2f, minY=%.2f, width=%.2f, height=%.2f%n",
                r.getMinX(), r.getMaxY(), r.getWidth(), r.getHeight());
    }
}
