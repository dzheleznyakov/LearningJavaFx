package zh.learn.javafx.ch11mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;
import zh.learn.javafx.ch11mvc.model.Person;
import zh.learn.javafx.ch11mvc.view.PersonPresenter;
import zh.learn.javafx.ch11mvc.view.PersonView;

public class PersonApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Person model = new Person();
        String dateFormat = "MM/dd/yyyy";
        PersonView view = new PersonView(model, dateFormat);

        Scene scene = new Scene(view);

        PersonPresenter presenter = new PersonPresenter(model, view);
        Aux.style(view);

        stage.setScene(scene);
        stage.setTitle("Person Management");
        stage.show();
    }
}
