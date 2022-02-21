package oop;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HR {
    private List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void layoff(Employee employee) {
        employees.remove(employee);
    }

    public void printAll() {
        employees.forEach(System.out::println);
    }

    public void payAll() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("NL", "NL"));
        for (Employee employee : employees) {
            System.out.printf("%s: %s%n", employee.getName(), nf.format(employee.getPay()));
        }
    }
}
