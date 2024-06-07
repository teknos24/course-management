package cat.uvic.teknos.coursemanagement.domain.jdbc.repositories;

import cat.uvic.teknos.coursemanagement.models.Genre;
import cat.uvic.teknos.coursemanagement.repositories.GenreRepository;

import java.sql.Connection;
import java.util.Set;

public class JdbcGenreRepository implements GenreRepository {
    private final Connection connection;

    public JdbcGenreRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Genre model) {
        if (model.getId() <= 0) {
            insert(model);
        } else {
            update(model);
        }
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
