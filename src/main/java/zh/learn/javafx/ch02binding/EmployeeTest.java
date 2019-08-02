package zh.learn.javafx.ch02binding;

import java.beans.PropertyChangeEvent;

public class EmployeeTest {
    public static void main(String[] args) {
        final Employee e1 = new Employee("John Jacobs", 2000.0);

        computeTax(e1.getSalary());
        e1.addPropertyChangeListener(EmployeeTest::handlePropertyChange);

        e1.setSalary(3000.0);
        e1.setSalary(3000.0);
        e1.setSalary(6000.0);
    }

    private static void handlePropertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();

        if ("salary".equals(propertyName)) {
            System.out.println("Salary has changed");
            System.out.print("Old: " + e.getOldValue());
            System.out.println(", New: " + e.getNewValue());
            computeTax((Double) e.getNewValue());
        }
    }

    private static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0;
        double tax = salary * TAX_PERCENT / 100;
        System.out.println("Salary: " + salary + ", Tax: " + tax);
    }
}
