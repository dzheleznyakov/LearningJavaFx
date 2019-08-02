package zh.learn.javafx.ch13tableview;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.util.StringConverter;
import zh.learn.javafx.ch12control.pickers.LocalDateStringConverter;

import java.time.LocalDate;

@SuppressWarnings("unchecked")
public class DatePickerTableCell<S, T> extends TableCell<S, LocalDate> {
    private DatePicker datePicker;
    private StringConverter converter;
    private boolean datePickerEditable = true;

    public DatePickerTableCell() {
        this.converter = new LocalDateStringConverter();
    }

    public DatePickerTableCell(boolean datePickerEditable) {
        this.converter = new LocalDateStringConverter();
        this.datePickerEditable = datePickerEditable;
    }

    public DatePickerTableCell(StringConverter<LocalDate> converter) {
        this.converter = converter;
    }

    public DatePickerTableCell(StringConverter<LocalDate> converter, boolean datePickerEditable) {
        this.converter = converter;
        this.datePickerEditable = datePickerEditable;
    }

    @Override
    public void startEdit() {
        if (!isEditable() || !getTableView().isEditable() || !getTableColumn().isEditable()) {
            return;
        }

        super.startEdit();

        if (datePicker == null) {
            this.createDatePicker();
        }

        this.setGraphic(datePicker);
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        this.setText(converter.toString(this.getItem()));
        this.setGraphic(null);
    }

    @Override
    protected void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            this.setText(null);
            this.setGraphic(null);
        } else {
            if (this.isEditing()) {
                if (datePicker != null) {
                    datePicker.setValue(item);
                }
                this.setText(null);
                this.setGraphic(datePicker);
            } else {
                this.setText(converter.toString(item));
                this.setGraphic(null);
            }
        }
    }

    private void createDatePicker() {
        datePicker = new DatePicker();
        datePicker.setConverter(converter);

        datePicker.setValue(this.getItem());

        datePicker.setPrefWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        datePicker.setEditable(this.datePickerEditable);

        datePicker.valueProperty().addListener((prop, oldValue, newValue) -> {
            if (DatePickerTableCell.this.isEditing()) {
                DatePickerTableCell.this.commitEdit(newValue);
            }
        });
    }

    public static <S> Callback<TableColumn<S, LocalDate>, TableCell<S, LocalDate>> forTableColumn() {
        return forTableColumn(true);
    }

    public static <S> Callback<TableColumn<S, LocalDate>, TableCell<S, LocalDate>> forTableColumn(boolean datePickerEditable) {
        return col -> new DatePickerTableCell<>(datePickerEditable);
    }

    public static <S> Callback<TableColumn<S, LocalDate>, TableCell<S, LocalDate>> forTableColumn(StringConverter<LocalDate> converter, boolean datePickerEditable) {
        return col -> new DatePickerTableCell<>(converter, datePickerEditable);
    }
}
