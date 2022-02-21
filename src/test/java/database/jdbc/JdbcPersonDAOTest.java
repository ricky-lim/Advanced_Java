package database.jdbc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JdbcPersonDAOTest {
    private PersonDAO dao = new JdbcPersonDAO();

    @Test
    void findAll() {
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
        Person p = new Person("Salah");
        int generatedId = dao.save(p);
        assertNotNull(dao.findById(generatedId));
    }

    @Test
    void delete() {
        int maxId = dao.getIds().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(1);
        System.out.println("Max id: " + maxId);
        Person p = dao.findById(maxId);
        dao.delete(p);
        assertNull(dao.findById(maxId));
    }

    @Test
    void getIds() {
        System.out.println(dao.getIds());
    }
}