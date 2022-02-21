package generics.wildcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HRDemo {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Ana"));
        emps.add(new Employee("Bart"));
        emps.add(new Employee("Corie"));

        List<Salaried> salarieds = new ArrayList<>();
        salarieds.add(new Salaried("Bob"));
        salarieds.add(new Salaried("Jack"));

//        HR.printEmpNames(emps);
//        HR.printAllEmpNames(salarieds);
//        HR.printAllFiltered(emps, e -> e.toString().length() % 2 == 0);

//        HR.printAllFiltered(emps, e -> e.toString().length() >= 3);
//        HR.printAllFiltered(salarieds, e -> e.getName().equals("Jack"));
//        HR.printAllFiltered(salarieds, (Object s) -> s.equals("Jack"));

//        Employee[] mixedEmployee = new Employee[3];
//        mixedEmployee[0] = new Employee("a1");
//        mixedEmployee[1] = new Salaried("a3");
//        mixedEmployee[2] = new Employee("a4");
//        HR.printMixedEmpNames(mixedEmployee);

    }
}
