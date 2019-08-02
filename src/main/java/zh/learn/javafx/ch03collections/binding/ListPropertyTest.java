package zh.learn.javafx.ch03collections.binding;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ListPropertyTest {
    public static void main(String[] args) {
        ListProperty<String> lp = new SimpleListProperty<>(FXCollections.observableArrayList());
        lp.addListener(ListPropertyTest::invalidated);
        lp.addListener(ListPropertyTest::changed);
        lp.addListener(ListPropertyTest::onChanged);

        System.out.println("Before addAll()");
        lp.addAll("one", "two", "three");
        System.out.println("After addAll()");

        System.out.println("\nBefore set()");
        lp.setValue(FXCollections.observableArrayList("two", "three"));
        System.out.println("After set()");

        System.out.println("\nBefore remove()");
        lp.remove("two");
        System.out.println("After remove()");
    }

    private static void invalidated(Observable list) {
        System.out.println("List property is invalid");
    }

    private static void changed(ObservableValue<? extends ObservableList<String>> observable, ObservableList<String> oldList, ObservableList<String> newList) {
        System.out.print("List Property has changed");
        System.out.print(" Old list: " + oldList);
        System.out.println(", New List: " + newList);
    }

    private static void onChanged(ListChangeListener.Change<? extends String> change) {
        while (change.next()) {
            String action = change.wasPermutated() ? "Permutated"
                    : change.wasUpdated() ? "Updated"
                    : change.wasRemoved() && change.wasAdded() ? "Replaced"
                    : change.wasRemoved() ? "Removed" : "Added";
            System.out.print("Action taken on the list: " + action);
            System.out.print(". Removed: " + change.getRemoved());
            System.out.println(", Added: " + change.getAddedSubList());
        }
    }
}
