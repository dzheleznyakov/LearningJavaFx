package zh.learn.javafx.ch02binding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CleanupListener {
    public static IntegerProperty counter = new SimpleIntegerProperty(100);

    public static void main(String[] args) {
        ChangeListener<Number> listener = CleanupListener::changed;
        counter.addListener(listener);

        counter.set(200);

        counter.removeListener(listener);

        counter.set(300);
    }

    private static void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
        System.out.print("Counter changed: ");
        System.out.println("Old: " + oldValue + ", new: " + newValue);
    }
}
