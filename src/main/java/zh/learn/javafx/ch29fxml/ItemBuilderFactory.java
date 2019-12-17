package zh.learn.javafx.ch29fxml;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class ItemBuilderFactory implements BuilderFactory {
    private final JavaFXBuilderFactory fxFactory = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Item.class)
            return new ItemBuilder();

        return fxFactory.getBuilder(type);
    }
}
