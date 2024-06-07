package cat.uvic.teknos.coursemanagement.domain.jdbc.repositories;

import cat.uvic.teknos.coursemanagement.models.Student;
import cat.uvic.teknos.coursemanagement.repositories.StudentRepository;

import java.sql.*;
import java.util.Set;

public class JdbcStudentRepository implements StudentRepository {
    private final Connection connection;

    public JdbcStudentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Student model) {

    }

    @Override
    public void delete(Student model) {

    }

    @Override
    public Student get(Integer id) {
        return null;
    }

    @Override
    public Set<Student> getAll() {
        return Set.of();
    }
}
