package zh.learn.javafx.ch02binding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeTest {
    public static void main(String[] args) {
        IntegerProperty counter = new SimpleIntegerProperty(100);

        counter.addListener(ChangeTest::changed);

        System.out.println("\nBefore changing the counter value-1");
        counter.set(101);
        System.out.println("After changing the counter value-1");

        System.out.println("\nBefore changing the counter value-2");
        counter.set(102);
        System.out.println("After changing the counter value-2");

        System.out.println("\nBefore changing the counter value-3");
        counter.set(102);
        System.out.println("After changing the counter value-3");

        System.out.println("\nBefore changing the counter value-4");
        counter.set(103);
        System.out.println("After changing the counter value-4");
    }

    private static void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
        System.out.print("Counter changed: ");
        System.out.println("Old: " + oldValue + ", new: " + newValue);
    }
}
