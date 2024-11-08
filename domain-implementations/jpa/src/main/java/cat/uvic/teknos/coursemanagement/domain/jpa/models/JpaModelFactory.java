package cat.uvic.teknos.coursemanagement.domain.jpa.models;

import cat.uvic.teknos.coursemanagement.models.*;

public class JpaModelFactory implements ModelFactory {
    @Override
    public JpaAddress createAddress() {
        return new JpaAddress();
    }

    @Override
    public JpaCourse createCourse() {
        return new JpaCourse();
    }

    @Override
    public JpaStudent courseStudent() {
        return new JpaStudent();
    }

    @Override
    public JpaGenre createGenre() {
        return new JpaGenre();
    }
}
