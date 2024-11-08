package cat.uvic.teknos.coursemanagement.domain.jpa.repositories;

import cat.uvic.teknos.coursemanagement.domain.jpa.models.JpaCourse;
import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.repositories.CourseRepository;
import jakarta.persistence.EntityManagerFactory;

import java.util.HashSet;
import java.util.Set;

public class JpaCourseRepository implements CourseRepository {
    private final EntityManagerFactory entityManagerFactory;

    public JpaCourseRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Course model) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if (model.getId() > 0) {
           entityManager.persist(model);
        } else {
           entityManager.merge(model);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
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
        var entityManager = entityManagerFactory.createEntityManager();
        Set<Course> addresses = new HashSet<>(entityManager.createQuery("SELECT c FROM JpaCourse c", JpaCourse.class).getResultList());
        entityManager.close();
        return addresses;
    }
}
