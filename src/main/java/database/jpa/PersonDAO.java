package database.jpa;

import java.util.List;

public interface PersonDAO {
    List<Person> findAll();
    Person findById(Integer id);
    Integer save(Person person);
    void delete(Person person);
    List<Integer> getIds();
}
