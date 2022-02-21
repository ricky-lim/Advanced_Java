package generics.wildcards;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class HR {
    public static void printEmpNames(List<Employee> employees){
        employees.stream().forEach(System.out::println);
    }

    public static void printAllEmpNames(List<? extends Employee> employees){
        employees.stream().forEach(System.out::println);
        // You can not add
//        employees.add(new Employee("Ricky"));
//        employees.add(new Salaried("Lim"));
    }

    public static void printMixedEmpNames(Employee[] employees){
        Arrays.stream(employees).forEach(System.out::println);
    }

    public static void printAllFiltered(List<? extends Employee> employees, Predicate<? super Employee> predicate){
        for (Employee e: employees) {
            if (predicate.test(e)){
                System.out.println(e);
//                System.out.println(e.getName());
            }
        }
    }
}
