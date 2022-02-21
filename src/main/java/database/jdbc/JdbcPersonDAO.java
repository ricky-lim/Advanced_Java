package database.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDAO implements PersonDAO {
    private static final String URL = "jdbc:sqlite:hr.db";
    private static final String GET_ALL = "SELECT * FROM People";
    private static final String GET_BY_ID = "SELECT * FROM People WHERE id = ?";
    private static final String GET_IDS = "SELECT id FROM People";
    private static final String INSERT_PERSON = "INSERT INTO PEOPLE(name) VALUES (?)";
    private static final String DELETE_PERSON = "DELETE FROM People WHERE id=?";

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(URL);
                PreparedStatement statement = conn.prepareStatement(GET_ALL);
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                people.add(new Person(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    @Override
    public Person findById(Integer id) {
        Person p = null;
        try (
                Connection conn = DriverManager.getConnection(URL);
                PreparedStatement statement = conn.prepareStatement(GET_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                p = new Person(id, rs.getString("name"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Integer save(Person p) {
        int generatedKey = 0;
        try (
                Connection conn = DriverManager.getConnection(URL);
                PreparedStatement statement = conn.prepareStatement(INSERT_PERSON, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, p.getName());
            int updateCount = statement.executeUpdate();
            if (updateCount != 1){
                throw new SQLException("No rows added");
            }

            try (ResultSet keys = statement.getGeneratedKeys();){
                if (keys.next()){
                    generatedKey = keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedKey;
    }

    @Override
    public void delete(Person p) {
        try (
                Connection conn = DriverManager.getConnection(URL);
                PreparedStatement statement = conn.prepareStatement(DELETE_PERSON);
                ) {
            statement.setInt(1, p.getId());
            int updateCount = statement.executeUpdate();
            if (updateCount != 1) throw new SQLException("No rows removed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> getIds() {
        List<Integer> ids = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(URL);
                PreparedStatement statement = conn.prepareStatement(GET_IDS);
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
