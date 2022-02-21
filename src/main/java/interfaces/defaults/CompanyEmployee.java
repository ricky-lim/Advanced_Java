package interfaces.defaults;

public class CompanyEmployee implements Company, Employee{

    @Override
    public String getFirstName() {
        return "Ricky";
    }

    @Override
    public String getLastName() {
        return "Lim";
    }

    @Override
    public void work() {
        System.out.println("Working...");
    }


    @Override
    public String getName() {
        return Employee.super.getName() + " works for " + Company.super.getName();
    }
}
