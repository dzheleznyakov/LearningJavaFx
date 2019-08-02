package zh.learn.javafx.ch12control.pickers;

import javafx.application.Application;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import zh.learn.javafx.Aux;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DatePickerTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        DatePicker birthDate = new DatePicker();
        birthDate.setEditable(false);

        birthDate.setOnAction(e -> System.out.println("New Date: " + birthDate.getValue()));

        String pattern = "MM/dd/yyyy";
        birthDate.setConverter(new LocalDateStringConverter(pattern));
        birthDate.setPromptText(pattern.toLowerCase());

        Callback<DatePicker, DateCell> dayCellFactory = datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (item.isAfter(LocalDate.now())) {
                    this.setDisable(true);
                }

                DayOfWeek day = DayOfWeek.from(item);
                if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                    this.setTextFill(Color.BLUE);
                }
            }
        };

        birthDate.setDayCellFactory(dayCellFactory);

        HBox root = new HBox(new Label("Birth Date:"), birthDate);
        Aux.style(root);

        Aux.showStage(stage, root, "Using DatePicker Control");
    }
}
