package zh.learn.javafx.ch12control.combobox;

import javafx.scene.control.ListCell;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class StringShapeCell extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item);
            Shape shape = this.getShape(item);
            setGraphic(shape);
        }
    }

    public Shape getShape(String shapeType) {
        Shape shape;
        switch (shapeType.toLowerCase()) {
            case "line":
                shape = new Line(0, 10, 20, 10);
                break;
            case "rectangle":
                shape = new Rectangle(0, 0, 20, 20);
                break;
            case "circle":
                shape = new Circle(20, 20, 10);
                break;
            default:
                shape = null;
        }
        return shape;
    }
}
