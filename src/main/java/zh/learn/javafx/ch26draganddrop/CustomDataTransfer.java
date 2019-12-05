package zh.learn.javafx.ch26draganddrop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zh.learn.javafx.Aux;

import java.util.ArrayList;
import java.util.List;

public class CustomDataTransfer extends Application {
    ListView<Item> lv1 = new ListView<>();
    ListView<Item> lv2 = new ListView<>();

    static final DataFormat ITEM_LIST = new DataFormat("jdojo/itemlist");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = getUIs();

        addDndEventHandlers();

        Aux.style(root);
        Aux.showStage(stage, root, "Drag-and-Drop Test");
    }

    private GridPane getUIs() {
        Label msgLbl = new Label("Select one or more items from a list, " +
                "drag and drop them to another list");

        lv1.setPrefSize(200, 200);
        lv2.setPrefSize(200, 200);
        lv1.getItems().addAll(getList());

        lv1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lv2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(msgLbl, 0, 0, 3, 1);
        pane.addRow(1, new Label("List 1:"), new Label("List 2:"));
        pane.addRow(2, lv1, lv2);
        return pane;
    }

    private ObservableList<Item> getList() {
        ObservableList<Item> list = FXCollections.observableArrayList();
        list.addAll(new Item("Apple"), new Item("Orange"),
                new Item("Papaya"), new Item("Mango"),
                new Item("Grape"), new Item("Guava"));
        return list;
    }

    private void addDndEventHandlers() {
        lv1.setOnDragDetected(e -> dragDetected(e, lv1));
        lv2.setOnDragDetected(e -> dragDetected(e, lv2));

        lv1.setOnDragOver(e -> dragOver(e, lv1));
        lv2.setOnDragOver(e -> dragOver(e, lv2));

        lv1.setOnDragDropped(e -> dragDropped(e, lv1));
        lv2.setOnDragDropped(e -> dragDropped(e, lv2));

        lv1.setOnDragDone(e -> dragDone(e, lv1));
        lv2.setOnDragDone(e -> dragDone(e, lv2));
    }

    private void dragDetected(MouseEvent e, ListView<Item> listView) {
        int selectedCount = listView.getSelectionModel().getSelectedIndices().size();
        if (selectedCount == 0) {
            e.consume();
            return;
        }

        Dragboard dragboard = listView.startDragAndDrop(TransferMode.MOVE);
        ArrayList<Item> selectedItems = getSelectedItems(listView);
        ClipboardContent content = new ClipboardContent();
        content.put(ITEM_LIST, selectedItems);
        dragboard.setContent(content);

        e.consume();
    }

    private void dragOver(DragEvent e, ListView<Item> listView) {
        Dragboard dragboard = e.getDragboard();
        if (e.getGestureSource() != listView &&
                dragboard.hasContent(ITEM_LIST)) {
            e.acceptTransferModes(TransferMode.MOVE);
        }

        e.consume();
    }

    @SuppressWarnings("unchecked")
    private void dragDropped(DragEvent e, ListView<Item> listView) {
        boolean dragCompleted = false;

        Dragboard dragboard = e.getDragboard();
        if (dragboard.hasContent(ITEM_LIST)) {
            ArrayList<Item> list = (ArrayList<Item>) dragboard.getContent(ITEM_LIST);
            listView.getItems().addAll(list);
            dragCompleted = true;
        }

        e.setDropCompleted(dragCompleted);
        e.consume();
    }

    private void dragDone(DragEvent e, ListView<Item> listView) {
        TransferMode tm = e.getTransferMode();
        if (tm == TransferMode.MOVE) {
            removeSelectedItems(listView);
        }
        e.consume();
    }

    private ArrayList<Item> getSelectedItems(ListView<Item> listView) {
        return new ArrayList<>(listView.getSelectionModel().getSelectedItems());
    }

    private void removeSelectedItems(ListView<Item> listView) {
        List<Item> selectedList = new ArrayList<>();
        for (Item item : listView.getSelectionModel().getSelectedItems()) {
            selectedList.add(item);
        }

        listView.getSelectionModel().clearSelection();

        listView.getItems().removeAll(selectedList);
    }
}
