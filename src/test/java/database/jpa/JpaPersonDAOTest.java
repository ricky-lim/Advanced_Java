package database.jpa;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JpaPersonDAOTest {
    private PersonDAO dao = new JpaPersonDAO();

    @Test
    void findAll() {
        List<Person> people = dao.findAll();
        System.out.println(people);
        assertTrue(dao.findAll().size() > 0);
    }

    @Test
    void findById() {
        for (int id : dao.getIds()) {
            assertNotNull(dao.findById(id));
        }
    }

    @Test
    void save() {
        Person newPerson = new Person("Nobita");
        int generatedId = dao.save(newPerson);
        assertNotNull(dao.findById(generatedId));

    }

    @Test
    void delete() {
        int maxId = dao.getIds().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(1);
        Person p = dao.findById(maxId);
        dao.delete(p);
        assertNull(dao.findById(maxId));
    }

    @Test
    void getIds() {
        dao.getIds().stream()
                .forEach(System.out::println);
    }
}