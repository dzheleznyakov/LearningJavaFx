package zh.learn.javafx.ch11mvc.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    public enum AgeCategory {
        BABY, CHILD, TEEN, ADULT, SENIOR, UNKNOWN
    }

    private ReadOnlyIntegerWrapper personId =
            new ReadOnlyIntegerWrapper(this, "personId", personSequence.incrementAndGet());
    private final StringProperty firstName =
            new SimpleStringProperty(this, "firstName", null);
    private final StringProperty lastName =
            new SimpleStringProperty(this, "lastName", null);
    private final ObjectProperty<LocalDate> birthDate =
            new SimpleObjectProperty<>(this, "birthDate", null);

    private static AtomicInteger personSequence = new AtomicInteger(0);

    public Person() {
        this(null, null, null);
    }

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.birthDate.setValue(birthDate);
    }

    public final int getPersonId() {
        return personId.get();
    }

    public final ReadOnlyIntegerProperty personIdProperty() {
        return personId.getReadOnlyProperty();
    }

    public final String getFirstName() {
        return firstName.get();
    }

    public final void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    public final StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate.get();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate.set(birthDate);
    }

    public ObjectProperty<LocalDate> birthDateProperty() {
        return birthDate;
    }

    public boolean isValidBirthDate(LocalDate bdate) {
        return isValidBirthDate(bdate, new ArrayList<>());
    }

    public boolean isValidBirthDate(LocalDate bdate, List<String> errorList) {
        if (bdate == null) {
            return true;
        }

        if (bdate.isAfter(LocalDate.now())) {
            errorList.add("Birth date must not be in future");
            return false;
        }

        return true;
    }

    public boolean isValidPerson(List<String> errorList) {
        return isValidPerson(this, errorList);
    }

    public boolean isValidPerson(Person p, List<String> errorList) {
        boolean isValid = true;

        String fn = p.firstName.get();
        if (fn == null || fn.trim().length() == 0) {
            errorList.add("First name must contain minimum one character.");
            isValid = false;
        }

        String ln = p.lastName.get();
        if (ln == null || ln.trim().length() == 0) {
            errorList.add("Last name must contain minimum one character.");
            isValid = false;
        }

        if (!isValidBirthDate(this.birthDate.get(), errorList)) {
            isValid = false;
        }

        return isValid;
    }

    public AgeCategory getAgeCategory() {
        if (birthDate.get() == null) {
            return AgeCategory.UNKNOWN;
        }
        long years = ChronoUnit.YEARS.between(birthDate.get(), LocalDate.now());
        if (years >= 0 && years < 2) {
            return AgeCategory.BABY;
        } else if (years >= 2 && years < 13) {
            return AgeCategory.CHILD;
        } else if (years >= 13 && years <= 19) {
            return AgeCategory.TEEN;
        } else if (years > 19 && years <= 50) {
            return AgeCategory.ADULT;
        } else if (years > 50) {
            return AgeCategory.SENIOR;
        } else {
            return AgeCategory.UNKNOWN;
        }
    }

    public boolean save(List<String> errorList) {
        boolean isSaved = false;
        if (isValidPerson(errorList)) {
            System.out.println("Saved " + this.toString());
            isSaved = true;
        }
        return isSaved;
    }

    @Override
    public String toString() {
        return "[personId=" + personId.get() +
                ", firstName=" + firstName.get() +
                ", lastName=" + lastName.get() +
                ", birthDate=" + birthDate.get() + "]";
    }
}
