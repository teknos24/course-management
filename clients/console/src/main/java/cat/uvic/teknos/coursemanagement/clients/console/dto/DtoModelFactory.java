package cat.uvic.teknos.coursemanagement.clients.console.dto;

import cat.uvic.teknos.coursemanagement.models.*;

public class DtoModelFactory implements ModelFactory {
    @Override
    public Address createAddress() {
        return new AddressDto();
    }

    @Override
    public Course createCourse() {
        return new CourseDto();
    }

    @Override
    public Student courseStudent() {
        return new StudentDto();
    }

    @Override
    public Genre createGenre() {
        return new GenreDto();
    }
}
