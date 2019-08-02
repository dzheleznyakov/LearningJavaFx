package zh.learn.javafx.ch02binding;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class BindNestedProperty {
    public static void main(String[] args) {
        ObjectProperty<Person> p = new SimpleObjectProperty<>(new Person());

        StringBinding zipBinding = Bindings.selectString(p, "addr", "zip");
        System.out.println(zipBinding.get());

        p.get().addrProperty().get().zipProperty().set("35217");
        System.out.println(zipBinding.get());

        ObjectBinding<Object> stateBinding = Bindings.select(p, "addr", "state");
        System.out.println(stateBinding.get());
    }
}
