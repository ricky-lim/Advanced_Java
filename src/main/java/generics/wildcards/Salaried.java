package generics.wildcards;

public class Salaried extends Employee {
    private static double DEFAULT_SALARY = 100_000;

    private double salary;

    public Salaried(String name) {
        this(name, DEFAULT_SALARY);
    }

    public Salaried(String name, double salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salaried{" +
                "salary=" + salary +
                '}';
    }
}
