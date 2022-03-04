package lambdastreams;

import database.jpa.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsePerson {
    private List<String> names = Arrays.asList("John Cenna", "Peter Parker", "Peter Pan", "Josh Groban");

    public List<Person> createPersonList(){
        return names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());
    }

    public Person[] createPersonArray(){
        return names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
    }

    public List<Person> createPersonListUsingNew(){
        return names.stream()
                .map(Person::new)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void main(String[] args) {
        UsePerson p = new UsePerson();
        System.out.println(p.createPersonList());
        System.out.println(p.createPersonListUsingNew());
        Arrays.stream(p.createPersonArray()).forEach(System.out::println);
    }
}
