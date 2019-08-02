package zh.learn.javafx.ch19threedshapes;

import javafx.application.ConditionalFeature;
import javafx.application.Platform;

public class Check3DSupport {
    public static void main(String[] args) {
        boolean supported = Platform.isSupported(ConditionalFeature.SCENE3D);
        if (supported)
            System.out.println("3D is supported on your machine.");
        else
            System.out.println("3D is not supported on your machine");
    }
}
