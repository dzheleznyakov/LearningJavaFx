package zh.learn.javafx.ch16webview;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;

public class BrowserHistory extends HBox {
    public BrowserHistory(WebView webView) {
        setSpacing(4);
        WebHistory history = webView.getEngine().getHistory();
        Button backBtn = new Button("Back");
        Button forwardBtn = new Button("Forward");
        backBtn.setDisable(true);
        forwardBtn.setDisable(true);

        backBtn.setOnAction(e -> history.go(-1));
        forwardBtn.setOnAction(e -> history.go(1));

        history.currentIndexProperty().addListener((p, oldValue, newValue) -> {
            int currentIndex = newValue.intValue();
            backBtn.setDisable(currentIndex <= 0);
            forwardBtn.setDisable(currentIndex >= history.getEntries().size() - 1);
        });

        ComboBox<Entry> historyList = new ComboBox<>();
        historyList.setPrefWidth(150);
        historyList.setItems(history.getEntries());

        historyList.setCellFactory(entry -> new ListCell<Entry>() {
            @Override
            protected void updateItem(Entry item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    String pageTitle = item.getTitle();
                    setText(pageTitle);
                }
            }
        });

        historyList.setOnAction(e -> {
            int currentIndex = history.getCurrentIndex();
            Entry selectedEntry = historyList.getValue();
            int selectedIndex = historyList.getItems().indexOf(selectedEntry);
            int offset = selectedIndex - currentIndex;
            history.go(offset);
        });

        getChildren().addAll(backBtn, forwardBtn, new Label("History:"), historyList);
    }
}
