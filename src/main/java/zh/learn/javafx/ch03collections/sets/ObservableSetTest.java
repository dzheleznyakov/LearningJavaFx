package zh.learn.javafx.ch03collections.sets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.HashSet;
import java.util.Set;

public class ObservableSetTest {
    public static void main(String[] args) {
        ObservableSet<String> s1 = FXCollections.observableSet("one", "two", "three");
        System.out.println("s1: " + s1);

        Set<String> s2 = new HashSet<>();
        s2.add("one");
        s2.add("two");
        System.out.println("s2: " + s2);

        ObservableSet<String> s3 = FXCollections.observableSet(s2);
        s3.add("three");
        System.out.println("s3: " + s3);
    }
}
