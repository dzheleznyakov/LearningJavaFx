package zh.learn.javafx.ch02binding;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BooleanExpressionTest {
    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        IntegerProperty z = new SimpleIntegerProperty(3);

        BooleanExpression condition = x.greaterThan(y).and(y.isNotEqualTo(z));
        System.out.println(condition.get());

        x.set(3);
        System.out.println(condition.get());
    }
}
