package zh.learn.javafx.ch03collections.maps;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class MapInvalidationTest {
    public static void main(String[] args) {
        ObservableMap<String, Integer> map = FXCollections.observableHashMap();
        map.addListener(MapInvalidationTest::invalidated);

        System.out.println("Before adding (\"one\", 1)");
        map.put("one", 1);
        System.out.println("After adding (\"one\", 1)");

        System.out.println("\nBefore adding (\"two\", 2)");
        map.put("two", 2);
        System.out.println("After adding (\"two\", 2)");

        System.out.println("\nBefore adding (\"one\", 1)");
        map.put("one", 1);
        System.out.println("After adding (\"one\", 1)");

        System.out.println("\nBefore adding (\"one\", 100)");
        map.put("one", 100);
        System.out.println("After adding (\"one\", 100)");

        System.out.println("\nBefore calling clear()");
        map.clear();
        System.out.println("After calling clear()");
    }

    private static void invalidated(Observable map) {
        System.out.println("Map is invalid");
    }
}
