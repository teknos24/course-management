package cat.uvic.teknos.coursemanagement.domain.jpa.repositories;

import cat.uvic.teknos.coursemanagement.domain.jpa.models.JpaCourse;
import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.repositories.CourseRepository;
import jakarta.persistence.EntityManagerFactory;

import java.util.Set;

public class JpaCourseRepository implements CourseRepository {
    private final EntityManagerFactory entityManagerFactory;

    public JpaCourseRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Course model) {
        
    }

    @Override
    public void delete(Course model) {

    }

    @Override
    public Course get(Integer id) {
        return entityManagerFactory.createEntityManager().find(JpaCourse.class, id);
    }

    @Override
    public Set<Course> getAll() {
        return Set.of();
    }
}
