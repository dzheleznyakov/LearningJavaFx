package zh.learn.javafx.ch03collections.lists;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import java.util.List;

public class ListUpdateTest {
    public static void main(String[] args) {
        Callback<IntegerProperty, Observable[]> extractor = p -> {
            System.out.println("The extractor is called for " + p);
            return new Observable[]{p};
        };

        ObservableList<IntegerProperty> list = FXCollections.observableArrayList(extractor);
        System.out.println("Before adding two elements");
        IntegerProperty p1 = new SimpleIntegerProperty(10);
        IntegerProperty p2 = new SimpleIntegerProperty(20);
        list.addAll(p1, p2);
        System.out.println("After adding two elements");

        list.addListener(ListUpdateTest::onChanged);

        p1.set(100);
    }

    private static void onChanged(ListChangeListener.Change<? extends IntegerProperty> change) {
        System.out.println("List is " + change.getList());

        while (change.next()) {
            if (change.wasUpdated()) {
                System.out.println("An update is detected");

                int start = change.getFrom();
                int end = change.getTo();
                System.out.println("Update range: [" + start + ", " + end + "]");

                List<? extends IntegerProperty> updatedElementList = change.getList().subList(start, end);
                System.out.println("Updated elements: " + updatedElementList);
            }
        }
    }
}
