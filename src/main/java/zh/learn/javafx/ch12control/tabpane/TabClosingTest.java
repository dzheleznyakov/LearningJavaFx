package zh.learn.javafx.ch12control.tabpane;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

public class TabClosingTest extends Application {
    GeneralTab generalTab = new GeneralTab("General", null);
    AddressTab addressTab = new AddressTab("Address", null);
    TabPane tabPane = new TabPane();

    CheckBox allowClosingTabsFlag = new CheckBox("Are tabs closable?");
    Button restoreTabBtn = new Button("Restore Tabs");
    ChoiceBox<TabPane.TabClosingPolicy> tabClosingPolicyChoices = new ChoiceBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        tabPane.getTabs().addAll(generalTab, addressTab);

        generalTab.setOnCloseRequest(this::tabClosingRequested);
        addressTab.setOnCloseRequest(this::tabClosingRequested);

        generalTab.setOnClosed(this::tabClosed);
        addressTab.setOnClosed(this::tabClosed);

        restoreTabBtn.setOnAction(e -> restoreTabs());

        tabClosingPolicyChoices.getItems()
                .addAll(TabPane.TabClosingPolicy.ALL_TABS,
                        TabPane.TabClosingPolicy.SELECTED_TAB,
                        TabPane.TabClosingPolicy.UNAVAILABLE);

        tabClosingPolicyChoices.setValue(tabPane.getTabClosingPolicy());

        tabPane.tabClosingPolicyProperty().bind(
                tabClosingPolicyChoices.valueProperty());

        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-padding: 10;");
        grid.addRow(0, allowClosingTabsFlag, restoreTabBtn);
        grid.addRow(1, new Label("Tab Closing Policy:"), tabClosingPolicyChoices);
        root.setTop(grid);
        root.setCenter(tabPane);
        Aux.style(root);

        Aux.showStage(stage, root, "Closing Tabs");
    }

    public void tabClosingRequested(Event e) {
        if (!allowClosingTabsFlag.isSelected()) {
            e.consume();
        }
    }

    public void tabClosed(Event e) {
        Tab tab = (Tab)e.getSource();
        String text = tab.getText();
        System.out.println(text + " tab has been closed");
    }

    public void restoreTabs() {
        ObservableList<Tab> list = tabPane.getTabs();
        if (!list.contains(generalTab)) {
            list.add(0, generalTab);
        }
        if (!list.contains(addressTab)) {
            list.add(1, addressTab);
        }
    }

    public void closingPolicyChanged(
            ObservableValue<? extends TabPane.TabClosingPolicy> prop,
            TabPane.TabClosingPolicy oldPolicy,
            TabPane.TabClosingPolicy newPolicy) {
        tabPane.setTabClosingPolicy(newPolicy);
    }
}
