package cat.uvic.teknos.coursemanagement.domain.jdbc.repositories;

import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.repositories.CourseRepository;
import java.sql.Connection;


import java.util.Set;

public class JdbcCourseRepository implements CourseRepository {
    private final Connection connection;

    public JdbcCourseRepository(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void save(Course model) {
        
    }

    @Override
    public void delete(Course model) {

    }

    @Override
    public Course get(Integer id) {
        return null;
    }

    @Override
    public Set<Course> getAll() {
        return Set.of();
    }
}
