package zh.learn.javafx.ch12control.accordion;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class AccordionTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TitledPane generalPane = this.getGeneralPane();
        TitledPane addressPane = this.getAddressPane();
        TitledPane phonePane = this.getPhonePane();

        Accordion root = new Accordion();
        root.getPanes().addAll(generalPane, addressPane, phonePane);
        root.setExpandedPane(generalPane);
        Aux.style(root);

        Aux.showStage(stage, root, "Using Accordion Controls");
    }

    private TitledPane getGeneralPane() {
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("First Name:"), new TextField());
        grid.addRow(1, new Label("Last Name:"), new TextField());
        grid.addRow(2, new Label("DOB:"), new DatePicker());

        return new TitledPane("General", grid);
    }

    private TitledPane getAddressPane() {
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("Street:"), new TextField());
        grid.addRow(1, new Label("City:"), new TextField());
        grid.addRow(2, new Label("State:"), new TextField());
        grid.addRow(3, new Label("ZIP:"), new TextField());

        return new TitledPane("Address", grid);
    }

    private TitledPane getPhonePane() {
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("Home:"), new TextField());
        grid.addRow(1, new Label("Work:"), new TextField());
        grid.addRow(2, new Label("Cell:"), new TextField());

        return new TitledPane("Phone", grid);
    }
}
