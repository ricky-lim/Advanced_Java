package oop;

public class Hourly extends Employee {
    public static double DEFAULT_RATE = 50;
    public static int DEFAULT_HOUR = 160;

    private double rate = DEFAULT_RATE;
    private int hours = DEFAULT_HOUR;

    public Hourly() {}

    public Hourly(String name){
        this(name, DEFAULT_RATE);
    }

    public Hourly(String name, double rate){
        super(name);
        this.rate = rate;
    }


    @Override
    public double getPay() {
        return hours * rate;
    }
}
