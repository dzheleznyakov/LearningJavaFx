package zh.learn.javafx.ch02binding;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Locale;

public class BindingsClassTest {
    public static void main(String[] args) {
        DoubleProperty radius = new SimpleDoubleProperty(7.0);
        DoubleProperty area = new SimpleDoubleProperty(0.0);

        area.bind(Bindings.multiply(Bindings.multiply(radius, radius), Math.PI));
        StringExpression desc = Bindings.format(Locale.US, "Radius = %.2f, Area = %.2f", radius, area);
        System.out.println(desc.get());

        radius.set(14.0);
        System.out.println(desc.get());
    }
}
