package database.jdbc;

public class Person {
    private static String DEFAULT_NAME = "Default Name";

    private Integer id;
    private String name;

    public Person(){
        this(DEFAULT_NAME);
    }

    public Person(String name){
        this.name = name;
    }

    public Person(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Person{id=%d, name='%s'}", id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!id.equals(person.id)) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
