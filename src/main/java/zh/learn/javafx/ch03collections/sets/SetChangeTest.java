package zh.learn.javafx.ch03collections.sets;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.util.HashSet;
import java.util.Set;

public class SetChangeTest {
    public static void main(String[] args) {
        ObservableSet<String> set = FXCollections.observableSet("one", "two");
        set.addListener(SetChangeTest::onChanged);

        set.add("three");
        set.add("one");

        Set<String> s = new HashSet<>();
        s.add("four");
        s.add("five");
        set.addAll(s);

        s.remove("one");
        set.clear();
    }

    private static void onChanged(SetChangeListener.Change<? extends String> change) {
        if (change.wasAdded()) {
            System.out.print("Added: " + change.getElementAdded());
        } else if (change.wasRemoved()) {
            System.out.print("Removed: " + change.getElementRemoved());
        }
        System.out.println(", Set after the change: " + change.getSet());
    }
}
