package cat.uvic.teknos.coursemanagement.domain.jpa.repositories;

import cat.uvic.teknos.coursemanagement.models.Genre;
import cat.uvic.teknos.coursemanagement.repositories.GenreRepository;
import jakarta.persistence.EntityManagerFactory;

import java.util.Set;

public class JpaGenreRepository implements GenreRepository {
    private final EntityManagerFactory entityManagerFactory;

    public JpaGenreRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Genre model) {

    }

    private void update(Genre model) {
    }

    private void insert(Genre model) {
    }

    @Override
    public void delete(Genre model) {
    }

    @Override
    public Genre get(Integer id) {
        return null;
    }

    @Override
    public Set<Genre> getAll() {
      return null;
    }
}
