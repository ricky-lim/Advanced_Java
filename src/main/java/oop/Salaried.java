package oop;

public class Salaried extends Employee{
    public static double DEFAULT_SALARY = 70_000;

    private double salary = DEFAULT_SALARY;

    public Salaried() {}

    public Salaried(String name) {
        this(name, DEFAULT_SALARY);
    }

    public Salaried(String name, double salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public double getPay() {
        return salary / 12;
    }
}
