package oop;

public class UseHR {
    public static void main(String[] args) {
        HR hr = new HR();
        hr.hire(new Salaried("Bob"));
        hr.hire(new Hourly("Jane"));

        hr.printAll();
        hr.payAll();
    }
}
