package zh.learn.javafx.ch12control.tabpane;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TabSelection extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GeneralTab generalTab = new GeneralTab("General", null);
        AddressTab addressTab = new AddressTab("Address", null);

        generalTab.setOnSelectionChanged(this::tabSelectedChanged);
        addressTab.setOnSelectionChanged(this::tabSelectedChanged);

        TabPane tabPane = new TabPane();

        tabPane.getSelectionModel().selectedItemProperty()
                .addListener(this::selectionChanged);

        tabPane.getTabs().addAll(generalTab, addressTab);

        HBox root = new HBox(tabPane);
        Aux.style(root);

        Aux.showStage(stage, root, "TabPane Selection Model");
    }

    public void selectionChanged(ObservableValue<? extends Tab> prop,
                                 Tab oldTab,
                                 Tab newTab) {
        String oldTabText = oldTab == null ? "None" : oldTab.getText();
        String newTabText = newTab == null ? "None" : newTab.getText();
        System.out.println("Selection changed in TabPane: old = " +
                oldTabText + ", new = " + newTabText);
    }

    public void tabSelectedChanged(Event e) {
        Tab tab = (Tab) e.getSource();
        System.out.println("Selection changed event for " + tab.getText() +
                " tab, selected = " + tab.isSelected());
    }
}
