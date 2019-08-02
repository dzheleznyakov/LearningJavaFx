package zh.learn.javafx.ch03collections.lists;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class SimpleListChangeTest {
    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addListener(SimpleListChangeTest::onChanged);

        list.add("one");
        list.add("two");
        FXCollections.sort(list);
        list.clear();
    }

    private static void onChanged(ListChangeListener.Change<? extends String> change) {
        System.out.println("List has changed: " + change);
    }
}
