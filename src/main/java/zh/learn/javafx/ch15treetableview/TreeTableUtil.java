package zh.learn.javafx.ch15treetableview;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import zh.learn.javafx.ch11mvc.model.Person;

import java.time.LocalDate;

public class TreeTableUtil {
    public static TreeItem<Person> getModel() {
        Person ram = new Person("Ram", "Singh", LocalDate.of(1930, 1, 1));

        Person janki = new Person("Janki", "Sharan", LocalDate.of(1956, 12, 17));
        Person sita = new Person("Sita", "Sharan", LocalDate.of(1961, 3, 1));
        Person kishori = new Person("Kishori", "Sharan", LocalDate.of(1968, 1, 12));
        Person ratna = new Person("Ratna", "Sharan", LocalDate.of(1978, 4, 14));

        Person navin = new Person("Navin", "Sharan", LocalDate.of(1980, 5, 10));
        Person vandana = new Person("Vandana", "Sharan", LocalDate.of(1981, 3, 20));
        Person neeraj = new Person("Neeraj", "Sharan", LocalDate.of(1982, 6, 3));

        Person gaurav = new Person("Gaurav", "Sharan", LocalDate.of(1990, 8, 27));
        Person saurav = new Person("Saurav", "Sharan", LocalDate.of(1994, 5, 15));

        Person palak = new Person("Palak", "Sharan", LocalDate.of(2010, 6, 3));
        Person ashwin = new Person("Ashwin", "Sharan", LocalDate.of(2012, 10, 11));
        Person advik = new Person("Advik", "Sharan", LocalDate.of(2012, 10, 11));

        TreeItem<Person> navinNode = new TreeItem<>(navin);
        navinNode.getChildren().addAll(new TreeItem<>(ashwin), new TreeItem<>(advik));
        TreeItem<Person> vandanaNode = new TreeItem<>(vandana);
        vandanaNode.getChildren().addAll(new TreeItem<>(palak));

        TreeItem<Person> jankiNode = new TreeItem<>(janki);
        jankiNode.getChildren().addAll(navinNode, new TreeItem<>(neeraj), vandanaNode);

        TreeItem<Person> sitaNode = new TreeItem<>(sita);
        sitaNode.getChildren().addAll(new TreeItem<>(gaurav), new TreeItem<>(saurav));

        TreeItem<Person> rootNode = new TreeItem<>(ram);
        rootNode.getChildren().addAll(jankiNode, sitaNode, new TreeItem<>(kishori), new TreeItem<>(ratna));

        return rootNode;
    }

    public static TreeTableColumn<Person, String> getFirstNameColumn() {
        TreeTableColumn<Person, String> fNameCol = new TreeTableColumn<>("First Name");
        fNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("firstName"));
        return fNameCol;
    }

    public static TreeTableColumn<Person, String> getLastNameColumn() {
        TreeTableColumn<Person, String> lNameCol = new TreeTableColumn<>("Last Name");
        lNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("lastName"));
        return lNameCol;
    }

    public static TreeTableColumn<Person, LocalDate> getBirthDateColumn() {
        TreeTableColumn<Person, LocalDate> bDateCol = new TreeTableColumn<>("Birth Date");
        bDateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthDate"));
        return bDateCol;
    }

    public static TreeTableColumn<Person, Person.AgeCategory> getAgeCategoryColumn() {
        TreeTableColumn<Person, Person.AgeCategory> bDateCol = new TreeTableColumn<>("Age Category");
        bDateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("ageCategory"));
        return bDateCol;
    }
}
