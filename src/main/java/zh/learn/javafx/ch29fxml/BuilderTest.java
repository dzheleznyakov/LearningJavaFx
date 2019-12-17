package zh.learn.javafx.ch29fxml;

import javafx.fxml.FXMLLoader;
import javafx.util.BuilderFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class BuilderTest {
    public static void main(String[] args) throws IOException {
        loadItems(new ItemBuilderFactory());

        loadItems(new ItemBuilderFactoryMap());
    }

    private static void loadItems(BuilderFactory builderFactory) throws IOException {
        URL fxmlUrl = BuilderTest.class
                .getClassLoader()
                .getResource("fxml/items.fxml");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlUrl);
        loader.setBuilderFactory(builderFactory);
        ArrayList<Item> items = loader.load();
        System.out.println("List: " + items);
    }
}
