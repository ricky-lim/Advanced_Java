package oop;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Employee {
    public static final String DEFAULT_NAME = "Unknown";
    private static long nextId = 1;

    private long id;
    private String name;
    private LocalDate hireDate;

    public Employee() {
        this(DEFAULT_NAME);
    }

    public Employee(String name) {
        id = nextId++;
        this.name = name;
        hireDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPay();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return hireDate != null ? hireDate.equals(employee.hireDate) : employee.hireDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', hireDate=%s}", id, name, hireDate);
    }
}
