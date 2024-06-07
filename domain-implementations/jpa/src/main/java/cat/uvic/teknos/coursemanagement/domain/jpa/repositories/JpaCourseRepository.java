package cat.uvic.teknos.coursemanagement.domain.jpa.repositories;

import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.repositories.CourseRepository;
import jakarta.persistence.EntityManagerFactory;

import java.util.Set;

public class JpaCourseRepository implements CourseRepository {
    public JpaCourseRepository(EntityManagerFactory entityManagerFactory) {
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
